package com.arie80.student.controller;

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

import com.arie80.student.model.Course;
import com.arie80.student.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	@GetMapping("")
	public String getAllCourse(Model model) {
		model.addAttribute("courses", courseService.findAll());
		return "course/index_course";
	}
	
	@GetMapping("add")
	public String addCourse(Model model) {
		model.addAttribute("course", new Course());
		model.addAttribute("courses", courseService.findAll());
		return "course/form_course";
		
	}
	
	@PostMapping("add")
	public String createCourse(@Valid @ModelAttribute("course") Course course, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("validated", "is-invalid");
			return "course/form_course";
		}

		courseService.save(course);
		return "redirect:/course";
	}
	
	@GetMapping("view/{id}")
	public String getCourse(@PathVariable int id, Model model) {
		model.addAttribute("course", courseService.findById(id));
		return "course/view";
	}
	
	@GetMapping("edit/{id}")
	public String editUser(@PathVariable @ModelAttribute("course") int id, Model model) {
		model.addAttribute("course", courseService.findById(id).orElse(new Course()));
		return "course/form_course";
	}
	
	@GetMapping("delete/{id}")
	public String deleteUser(@PathVariable int id) {
		courseService.deleteById(id);
		return "redirect:/course";
	}
}
