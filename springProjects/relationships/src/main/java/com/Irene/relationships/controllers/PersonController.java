package com.Irene.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Irene.relationships.models.Person;
import com.Irene.relationships.services.PersonService;

@Controller
public class PersonController {
	private final PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@RequestMapping(value = "/persons/new", method = RequestMethod.GET)
	public String newPerson(@ModelAttribute("person") Person person) {
		return "license/newPerson.jsp";
	}
	
	@RequestMapping(value = "/persons/new", method = RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "license/newPerson.jsp";
		} else {
			personService.createPerson(person);
			return "redirect:/licenses/new";
		}
	}
	
	@RequestMapping(value = "/licenses/new", method = RequestMethod.GET)
	public String newLicense(Model model) {
		List<Person> person = personService.allPersons();
		model.addAttribute("person", person);
		return "license/newLicense.jsp";
	}
	
	@RequestMapping(value = "/persons/{id}", method = RequestMethod.GET)
	public String showPerson(@PathVariable(value = "id") Long id, Model model) {
		Person person = personService.findPerson(id);
		model.addAttribute("person", person);
		return "license/showPerson.jsp";
	}
	
	@RequestMapping(value = "/person/license/show", method = RequestMethod.GET)
	public String showAll(Model model) {
		List<Person> person = personService.allPersons();
		model.addAttribute("person", person);
		return "license/showAll.jsp";
	}
}
