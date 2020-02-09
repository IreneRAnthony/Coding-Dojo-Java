package com.Irene.lookify.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.Irene.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	List<Song> findAll();
	List<Song> findByArtist(String search);
	List<Song> countByTitle(String search);
	List<Song> deleteByTitleStartingWith(String search);
	List<Song> findByRating(int search);
	List<Song> findByRatingLessThanEqual(int search);
	List<Song> findByArtistContaining(String search);
	List<Song> findTop10ByOrderByRatingDesc();
}
