package com.Irene.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Irene.languages.models.Language;
import com.Irene.languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping(value = "/languages", method = RequestMethod.GET)
	public String index(Model model) {
		List<Language> language = languageService.allLanguages();
		model.addAttribute("language", language);
		return "/lang/index.jsp";
	}
	
	@RequestMapping(value = "/languages", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "/lang/languages.jsp";
		} else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping(value = "/languages/{id}", method = RequestMethod.GET)
	public String show(@PathVariable(value = "id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "/lang/show.jsp";
	}
	
//	@RequestMapping(value = "/languages/{id}/edit", method = RequestMethod.GET)
	@GetMapping("/languages/{id}/edit")
	public String editPage(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "/lang/edit.jsp";
	}
	
	@RequestMapping(value = "/languages/{id}", method = RequestMethod.PUT)
	public String edit(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "/lang/edit.jsp";
		} else {
			languageService.updateLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping(value = "/languages/{id}/delete", method = RequestMethod.GET)
	public String destroy(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
	
}
