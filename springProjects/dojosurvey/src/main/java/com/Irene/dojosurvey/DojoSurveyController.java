package com.Irene.dojosurvey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DojoSurveyController {
	
	@RequestMapping("/")
	public String homePage() {
		return "index.jsp";
	}
	
	@RequestMapping(value = "/process")
	public String processResults(Model model,
		@RequestParam(value = "name") String name, 
		@RequestParam(value = "location") String location, 
		@RequestParam(value = "language") String language, 
		@RequestParam(value = "comment") String comment){
		
		model.addAttribute("name", name);
		model.addAttribute("location", location);
		model.addAttribute("language", language);
		model.addAttribute("comment", comment);
		
		return "showProfile.jsp";
	}
	
	
}
