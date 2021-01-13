package com.rhm.demo.contollers;
import com.rhm.demo.models.Language;
import com.rhm.demo.services.LanguageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
public class LanguagesApi {
    private final LanguageService languageService;



    public LanguagesApi(LanguageService bookService, LanguageService languageService){
        this.languageService = languageService;

    }


    @GetMapping("/languages")
    public String index(Model model, @ModelAttribute("language") Language language) {
        List<Language> languages = languageService.allLanguages();
        for (Language var : languages)
        {
            System.out.println(var.getName());
        }
        model.addAttribute("languages", languages);
        return "index";
    }


    @RequestMapping("/languages/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "show";
    }

    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }


    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "/edit";
    }
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/edit";
        } else {
            languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
//
//    @GetMapping("/languages/new")
//    public String newbook(@ModelAttribute("book") Language language) {
//
//        return "new";


    @RequestMapping(value="/languages", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/index";
        } else {
            languageService.createLanguage(language);

            return "redirect:/languages";
        }
    }
}


//    @RequestMapping(value="/api/books", method= RequestMethod.POST)
//    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
//        Book book = new Book(title, desc, lang, numOfPages);
//        return bookService.createBook(book);
//    }



//    @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
//    public void destroy(@PathVariable("id") Long id) {
//        bookService.deleteBook(id);
//    }















//
//    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
//    public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String description, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
//        System.out.println("done");
//        Book book = new Book(id,title, description, lang, numOfPages);
//        return bookService.updateBook(book);
//
//    }