package com.rickywong.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rickywong.languages.models.Language;
import com.rickywong.languages.repositories.LanguageRepository;


@Service
// Set Methods
public class LanguageService {
	private final LanguageRepository langRepo;
	
	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}
	public List<Language> allLanguages(){
		return langRepo.findAll();
	}
	public Language createLanguage(Language lang) {
		return langRepo.save(lang);
	}
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = langRepo.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get()
;		}
		else {
			return null;
		}
	}
	public void updateLanguage(Language language) {
		Optional<Language> optionalLanguage = langRepo.findById(language.getId());
		if (optionalLanguage.isPresent()) {
			Language lang = optionalLanguage.get();
			lang.setId(language.getId());
			lang.setName(language.getName());
			lang.setCreator(language.getCreator());
			lang.setCurrentVersion(language.getCurrentVersion());
			langRepo.save(language);
		}
	}
	public void deleteBook(Long id) {
		langRepo.deleteById(id);
	}
}
