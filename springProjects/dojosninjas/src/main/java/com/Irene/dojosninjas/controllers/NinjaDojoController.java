package com.Irene.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Irene.dojosninjas.models.Dojo;
import com.Irene.dojosninjas.models.Ninja;
import com.Irene.dojosninjas.services.DojoService;
import com.Irene.dojosninjas.services.NinjaService;

@Controller
public class NinjaDojoController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	
	public NinjaDojoController(NinjaService ninjaService, DojoService dojoService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping(value = "/ninjas/new", method = RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result) {
	if(result.hasErrors()) {
		return "newNinja.jsp";
	} else {
		ninjaService.createNinja(ninja);
		return "redirect:/dojos/"+ninja.getDojo().getId();
	}
}
	
	@RequestMapping(value ="/dojos/new", method = RequestMethod.GET)
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	@RequestMapping(value="/dojos/new", method = RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "newDojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	
	@RequestMapping(value = "/ninjas/new", method = RequestMethod.GET)
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojo = dojoService.allDojo();
		model.addAttribute("dojo", dojo);
		return "newNinja.jsp";
}
	
	@RequestMapping(value = "/dojos/{id}", method = RequestMethod.GET)
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		List<Ninja> ninja = dojo.getNinjas();
		model.addAttribute("ninja", ninja);
		return "show.jsp";
	}
	
}
