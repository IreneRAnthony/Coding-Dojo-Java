package com.Irene.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloName {
	/*
	 * @RequestMapping("/") public String helloHuman() { return "Hello Human!"; }
	 */
	
	
	@RequestMapping("/")
	public String helloFirstName (@RequestParam(value = "name", defaultValue = "Human") String first_name){
		return "Hello" + first_name + "!";
	}
	
}
