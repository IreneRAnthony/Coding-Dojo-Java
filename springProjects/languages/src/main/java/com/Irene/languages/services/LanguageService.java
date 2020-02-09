package com.Irene.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.Irene.languages.models.Language;
import com.Irene.languages.respositories.LanguageRepository;

@Service
public class LanguageService {

private final LanguageRepository languageRepository;

	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<Language> allLanguages(){
		return languageRepository.findAll();
	}
	
	public Language createLanguage(Language b){
		return languageRepository.save(b);
	}
	
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	
	public Language updateLanguage(Language language) {
		languageRepository.save(language);
		return null;
	}
	
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
	}
	
}
