package com.arie80.student.controller;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arie80.student.model.Balance;
import com.arie80.student.model.Student;
import com.arie80.student.service.BalanceService;
import com.arie80.student.service.CourseService;
import com.arie80.student.service.StudentService;


@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private BalanceService balanceService;

	@Autowired
	private CourseService courseService;

	@GetMapping("")
	public String getAllUser(Model model, Student student) {
		model.addAttribute("students", studentService.findAll());
		balanceService.findAll().forEach(n -> {
			student.setBalance(new Balance(
					n.getPayment(),
					n.getTotalCost(),
					n.getTuitionBalance()
				));
		});
		
		return "student/index_student";
	}

	@GetMapping("add")
	public String addUser(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("courses", courseService.findAll());
		model.addAttribute("grades", grade());
		return "student/form_student";

	}

	/*
	 * Create Grade data 
	 */
	private Map<String, String> grade() {
		Map<String, String> grade = new TreeMap<String, String>();
		grade.put("freshmen", "Freshmen");
		grade.put("sophomore", "Sophomore");
		grade.put("junior", "Junior");
		grade.put("senior", "Senior");
		return grade;
	}

	@PostMapping("add")
	public String createUser(@Valid @ModelAttribute("student") Student student, Balance balance, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("validated", "is-invalid");
			model.addAttribute("courses", courseService.findAll());
			model.addAttribute("grades", grade());
			return "student/form_student";
		}
		
		studentService.save(student);
		balance.setStudent(student);
		balance.setTotalCost(totalCost(student));
		balance.setTuitionBalance(student.getPayment() - totalCost(student));
		balanceService.save(balance);
		return "redirect:/student";
	}

	private Double totalCost(Student student) {
		return student.getCourses().stream().mapToDouble(i -> i.getCost()).sum();
	}

	@GetMapping("view/{id}")
	public String getUser(@PathVariable int id, Model model) {
		Optional<Balance> balance = balanceService.findById(id);
		model.addAttribute("student", studentService.findById(id).orElse(new Student()));
		model.addAttribute("payment", balance.get().getPayment());
		model.addAttribute("totalCost", balance.get().getTotalCost());
		model.addAttribute("balance", balance.get().getTuitionBalance());
		return "student/view";
	}

	@GetMapping("edit/{id}")
	public String editUser(@PathVariable @ModelAttribute("student") int id, Model model) {
		model.addAttribute("student", studentService.findById(id).orElse(new Student()));
		studentService.findById(id).get().getCourses().forEach(n -> {
			n.setSelected("selected");
		});
		studentService.findById(id).get().setPayment(balanceService.findById(id).get().getPayment());
		model.addAttribute("balance", balanceService.findById(id).get().getPayment());
		model.addAttribute("courses", courseService.findAll());
		model.addAttribute("grades", grade());
		return "student/form_student";
	}

	@GetMapping("delete/{id}")
	public String deleteUser(@PathVariable int id) {
		studentService.deleteById(id);
		return "redirect:/student";
	}
}
