package com.Irene.thecode;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		session.invalidate();
		return "index.jsp";
	}
	
	@RequestMapping(value = "/process", method = RequestMethod.POST)
	public String processing(HttpSession session, @RequestParam(value = "code") String code) {
		// process information
		System.out.println(code);
		if(code.equals("bushido")) {
			session.setAttribute("correct", 1);
			return "redirect:/code";
		} else {
			return "redirect:/incorrect";
		}
	}
	
	@RequestMapping(value = "/code")
	public String correct(HttpSession session) {
		if(session.getAttribute("correct") == null) {
			return "redirect:/";
		} else {
			return "Correct.jsp";
		}
	}
	
	@RequestMapping(value = "/incorrect")
	public String flashMessages(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("error", "You must train harder!");
		return "redirect:/";
	}
}
