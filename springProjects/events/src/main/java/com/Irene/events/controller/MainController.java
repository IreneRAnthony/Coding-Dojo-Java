package com.Irene.events.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Irene.events.model.Event;
import com.Irene.events.model.Message;
import com.Irene.events.model.User;
import com.Irene.events.service.EventService;
import com.Irene.events.service.MessageService;
import com.Irene.events.service.UserService;
import com.Irene.events.validator.UserValidator;

@Controller
public class MainController {
	private final UserService userService;
	private final MessageService messageService;
	private final EventService eventService;
	private final UserValidator userValidator;
	
	public MainController(UserService userService, MessageService messageService, EventService eventService, UserValidator userValidator) {
		this.eventService = eventService;
		this.messageService = messageService;
		this.userService = userService;
		this.userValidator = userValidator;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginRegistration(@ModelAttribute("user") User user) {
		return "";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, RedirectAttributes redirectAttr) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "";
		} else {
			User new_user = userService.registerUser(user);
			session.setAttribute("loggedin", user);
			session.setAttribute("userId", new_user.getId());
			return "redirect:/events";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirectAttr) {
		if(userService.authenticateUser(email, password)) {
	    	 User user = userService.findByEmail(email);
	    	 if(user == null) {
	    		 redirectAttr.addFlashAttribute("error", "No such user");
	    	 } else if(!userService.authenticateUser(email, password)) {
	    		 redirectAttr.addFlashAttribute("error", "Invalid Password");
	    	 } else {
	    		 session.setAttribute("userId", user.getId());
	        	 session.setAttribute("loggedIn", true);
	        	 return "redirect:/home";
	    	 }
	     }
		return "redirect:/events";
	}
	
	@RequestMapping(value = "/events/{event_id}", method = RequestMethod.GET)
	public String specificEvent(@PathVariable("event_id") Long id, Model model) {
		Event currentEvent = eventService.findEvent(id);
		model.addAttribute("currentEvent", currentEvent);
		return "";
	}
	
	@RequestMapping(value = "/events/{event_id}", method = RequestMethod.POST)
	public String createComment(@ModelAttribute("comment") Message message) {
		
	}
	
}
