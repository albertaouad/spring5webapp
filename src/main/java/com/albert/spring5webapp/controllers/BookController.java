package com.albert.spring5webapp.controllers;

import com.albert.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// Controller Annotation to specify that its a Spring Bean (spring Managed Component)
@Controller
public class BookController {

    private BookRepository bookRepository;

    // Inject bookRepository
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //When requesting books url this method will be called and we will add an attribute to the model
    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());

        //return the view name that will be associated with the thymleaf view
        return "books";
    }
}
