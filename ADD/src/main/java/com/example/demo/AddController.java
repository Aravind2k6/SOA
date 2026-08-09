package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ms1")
public class AddController {
	//@Autowired
	
	@GetMapping("/add")
	public String add(@RequestParam("a") int a, @RequestParam("b") int b) {
		int result = a + b;
		return "MS - Addition = " + result;
	}

}

