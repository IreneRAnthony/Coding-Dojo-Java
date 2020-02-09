package com.chughes.ninjagold.service;

import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GoldService {

	public ArrayList <String> activities = new ArrayList <String>();
	
	private int gold;
	
	public int getGold() {
		return gold;
	}
	
	public ArrayList<String> getActivities() {
		return activities;
	}
	
	public void setGold() {
		gold = 0;
	}
	
	public String formatDate() {
		Date date = new Date();
		String newTime = new SimpleDateFormat("MMMMM dd YYYY hh:mm a").format(date);
		return newTime;
	}
	
	public void processMoney(String hidden) {
		
		if (hidden.equals("farm")) {
			int amount = new Random().nextInt(10) + 10;
			gold += amount;
			String time = formatDate();
			activities.add(0, "You entered a " + hidden + " and earned " + amount + " " + (time));
		}
		if (hidden.equals("cave")) {
			int amount =  new Random().nextInt(5) + 5;
			gold += amount;
			String time = formatDate();
			activities.add(0, "You entered a " + hidden + " and earned " + amount + " " + (time));
		}
		if (hidden.equals("house")) {
			int amount = new Random().nextInt(2) + 3;
			gold += amount;
			String time = formatDate();
			activities.add(0, "You entered a " + hidden + " and earned " + amount + " " + (time));
		}
		if (hidden.equals("casino")) {
			int amount = new Random().nextInt(50 + 50) - 50;
			gold += amount;
			String time = formatDate();
			if(amount < 0) {
				activities.add(0, "You entered a casino and lost " + amount + " gold... Ouch." + " " + (time));
			} else {
				activities.add(0, "You entered a casino and earned " + amount + " " + (time));
			}
		}
		
	}
	
}
