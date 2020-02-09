package com.Irene.displaydate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String homePage() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String datePage(Model model) {
		Date date = new Date();
		String newDate = new SimpleDateFormat("EEEEEEE, dd MMMMMMMM, YYYY").format(date);
		model.addAttribute("CurrentDate", newDate);
		return "dateIndex.jsp";
	}
	
	@RequestMapping("/time")
	public String timePage(Model model) {
		Date date = new Date();
		String newTime = new SimpleDateFormat("hh:mm a").format(date);
		model.addAttribute("CurrentTime", newTime);
		return "timeIndex.jsp";
	}
}
