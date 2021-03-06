package com.Irene.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.Irene.lookify.repositories.SongRepository;
import com.Irene.lookify.models.Song;

@Service
public class SongService {

	private final SongRepository songRepository;
	
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	public List<Song> allSongs(){
		return songRepository.findAll();
	}
	
	public Song createSong(Song b) {
		return songRepository.save(b);
	}
	
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
	
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}

	public List<Song> findByArtist(String artist) {
		List<Song> currentArtist = songRepository.findByArtist(artist);
		return currentArtist;
	}
	
	public List<Song> findByRating(int rating){
		List<Song> songRating = songRepository.findByRating(rating);
		return songRating;
	}
	
	public List<Song> findByRatingLessThanEqual(int rating){
		List<Song> descendingRatings = songRepository.findByRatingLessThanEqual(rating);
		return descendingRatings;
	}
	
	public List<Song> topTenByRating() {

		return songRepository.findTop10ByOrderByRatingDesc();

	}

	public List<Song> songsContainingArtist(String artist) {

		return songRepository.findByArtistContaining(artist);

	}
	
}
