package com.Irene.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Irene.relationships.models.License;
import com.Irene.relationships.services.LicenseService;


@Controller
public class LicenseController {
	private final LicenseService licenseService;
	
	public LicenseController(LicenseService licenseService) {
		this.licenseService = licenseService;
	}
	
	@RequestMapping(value = "/licenses/new", method = RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if (result.hasErrors()) {
			return "licenses/newLicense.jsp";
		} else {
			license.setNumber(licenseService.generateLicense());
			licenseService.createLicense(license);
			return "redirect:/persons/"+license.getPerson().getId();
		}
	}
	
}
