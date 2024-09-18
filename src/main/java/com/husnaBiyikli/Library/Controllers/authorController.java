package com.husnaBiyikli.Library.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.husnaBiyikli.Library.Entitys.authors;
import com.husnaBiyikli.Library.Services.authorService;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/authors")
public class authorController {

    @Autowired
    private authorService authorService;

    public authorController(authorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/getauthors")
    public String getAll(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors";
    }

    @GetMapping("/addauthor")
    public String addAuthor(Model model, authors author) {
        model.addAttribute("newAuthor", author);
        return "addAuthor";
    }

    @PostMapping("/saveAuthor")
    public String saveAuthor(@Valid @ModelAttribute("newAuthor") authors author, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addAuthor";
        } else {
            authorService.saveAuthor(author);
            return "redirect:/authors/getauthors";
        }
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("updateAuthor", authorService.getAuthorById(id));
        return "updateAuthor";
    }

    @PostMapping("/updateAuthor")
    public String updateHouse(@ModelAttribute("updateAuthor") authors author, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateAuthor";
        } else {
            authorService.saveAuthor(author);
            return "redirect:/authors/getauthors";
        }
    }
}
