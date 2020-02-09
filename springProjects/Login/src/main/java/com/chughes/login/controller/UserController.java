package com.chughes.login.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chughes.login.model.User;
import com.chughes.login.service.UserService;
import com.chughes.login.validator.UserValidator;

@Controller
public class UserController {
	private final UserService userService;
    private final UserValidator userValidator;
 
    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
 
 @RequestMapping("/registration")
 public String registerForm(@ModelAttribute("user") User user) {
     return "registrationPage.jsp";
 }
 @RequestMapping("/login")
 public String login() {
     return "loginPage.jsp";
 }
 
 @RequestMapping(value="/registration", method=RequestMethod.POST)
 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, RedirectAttributes redirectAttr) {
	 userValidator.validate(user, result);
	 if(result.hasErrors()) {
		 return "registrationPage.jsp";
	 } else {
		 User new_user = userService.registerUser(user);
		 session.setAttribute("loggedIn", user);
		 session.setAttribute("userId", new_user.getId());
		 return "redirect:/home";
	 }
     // if result has errors, return the registration page (don't worry about validations just now)
     // else, save the user in the database, save the user id in session, and redirect them to the /home route
 }
 
 @RequestMapping(value="/login", method=RequestMethod.POST)
 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirectAttr) {
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
     return "redirect:/login";
	 // if the user is authenticated, save their user id in session
     // else, add error messages and return the login page
 }
 
 @RequestMapping("/home")
 public String home(HttpSession session, Model model) {
	 Long id = (Long) session.getAttribute("userId");
	 User user = userService.findUserById(id);
	 model.addAttribute("user", user);
	 return "homePage.jsp";
     // get user from session, save them in the model and return the home page
 }
 @RequestMapping("/logout")
 public String logout(HttpSession session) {
	 session.invalidate();
	 return "redirect:/login";
     // invalidate session
     // redirect to login page
 }
}