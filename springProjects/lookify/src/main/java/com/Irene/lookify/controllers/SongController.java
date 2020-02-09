package com.Irene.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Irene.lookify.models.Song;
import com.Irene.lookify.services.SongService;

@Controller
public class SongController {
	private final SongService songService;
	
	public SongController(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "music/index.jsp";
	}
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(Model model) {
		List<Song> song = songService.allSongs();
		model.addAttribute("song", song);
		return "music/dashboard.jsp";
	}
	
	@RequestMapping(value = "/songs/{id}", method = RequestMethod.GET)
	public String showSong(@PathVariable(value = "id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "music/show.jsp";
	}
	
	@RequestMapping(value = "/songs/new", method = RequestMethod.GET)
	public String createSong() {
		return "music/new.jsp";
	}
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.POST)
	public String processSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "/music/new.jsp";
		} else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/songs/search")
	public String search(@RequestParam("artist") String artist, Model model) {
		model.addAttribute("songs",	songService.songsContainingArtist(artist));
		model.addAttribute("artist", artist);
		return "/songs/searched.jsp";
	}
	
	

	@RequestMapping(value = "/song/{id}/delete", method = RequestMethod.GET)
	public String deleteSong(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value = "/search/topTen", method = RequestMethod.GET)
	public String topTen(Model model) {
		model.addAttribute("songs", songService.topTenByRating());
		return "music/topTen.jsp";
	}
	
}
