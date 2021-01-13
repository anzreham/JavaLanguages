package com.rhm.demo.services;

import com.rhm.demo.models.Language;
import com.rhm.demo.repositories.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public
class LanguageService {
    private final LanguageRepository languageRepository;


    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    // returns all the Languages
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    // creates a book
    public Language createLanguage(Language b) {
        return languageRepository.save(b);
    }
    // retrieves a book
    public Language findLanguage(Long id) {
        Optional<Language> optionalBook = languageRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
     // delete object
    public void deleteLanguage(Long id) {
        languageRepository.deleteById(id);
    }

    //update objec//
    public Language updateLanguage(Language b) {
        return languageRepository.save(b);
    }
}
