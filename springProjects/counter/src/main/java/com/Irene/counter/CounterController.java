package com.Irene.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
			return "index.jsp";
		} else {
		Integer count = (Integer) session.getAttribute("count");
		count++;
		session.setAttribute("count", count);
		return "index.jsp";
		}
	}
	
	@RequestMapping("/counter")
	public String Counter(Model model, HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		model.addAttribute("counter", count);
		return "counter.jsp";
	}
	
	@RequestMapping("/reset")
	public String setSession(HttpSession session) {
		session.setAttribute("count", 0);
		return "Reset.jsp";
	}
	
}
