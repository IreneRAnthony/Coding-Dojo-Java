package com.Irene.routingfamiliarity;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class DojoController {
	
	@RequestMapping(path = "/?an-?ose")
	public String sanJose() {
		//String newS = s.toUpperCase();
		//String newJ = j.toUpperCase();
		return  "SJ dojo is the headquarters.";
	}

		@RequestMapping(path = "/{dojo}")
		public String dojoRoute(@PathVariable("dojo") String dojo) {
			return "The "+ dojo + " is awesome!";
		}
		
		@RequestMapping(path = "/{location}-dojo")
		public String dojoLocation(@PathVariable("location") String location) {
			String output = location.substring(0, 1).toUpperCase() + location.substring(1);
			return output + " Dojo is located in Southern California.";
		}
		
		
}