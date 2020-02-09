package com.Irene.events.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Irene.events.model.Event;
import com.Irene.events.repository.EventRepository;

@Service
public class EventService {
	private final EventRepository eventRepository;
	
	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	public List<Event> allEvents(){
		return eventRepository.findAll();
	}
	
	public Event createEvent(Event b) {
		return eventRepository.save(b);
	}
	
	public Event findEvent(Long id) {
		Optional <Event> optionalEvent = eventRepository.findById(id);
		if(optionalEvent.isPresent()) {
			return optionalEvent.get();
		} else {
			return null;
		}
	}
	
	public void deleteEvent(Long id) {
		eventRepository.deleteById(id);
	}
	
	public Event updateEvent(Event event) {
		eventRepository.save(event);
		return null;
	}
	
}
