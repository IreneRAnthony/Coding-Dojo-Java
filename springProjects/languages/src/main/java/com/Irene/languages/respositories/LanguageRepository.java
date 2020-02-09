package com.Irene.languages.respositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.Irene.languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
	List<Language> findAll();
	List<Language> findByCreator(String search);
	List<Language> countByName(String search);
	List<Language> deleteByNameStartingWith(String search);
}
