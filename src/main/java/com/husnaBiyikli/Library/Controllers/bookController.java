package com.husnaBiyikli.Library.Controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.husnaBiyikli.Library.Entitys.authors;
import com.husnaBiyikli.Library.Entitys.books;
import com.husnaBiyikli.Library.Entitys.publishingHouses;
import com.husnaBiyikli.Library.Model.BookSearchDTO;
import com.husnaBiyikli.Library.Services.authorService;
import com.husnaBiyikli.Library.Services.bookService;
import com.husnaBiyikli.Library.Services.publishingHouseService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/home")
public class bookController {

    @Autowired
    private bookService bookService;

    @Autowired
    private authorService authorService;

    @Autowired
    private publishingHouseService publishingHouseService;

    public bookController(bookService bookService, authorService authorService,
            publishingHouseService publishingHouseService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publishingHouseService = publishingHouseService;
    }

    @GetMapping("/allbook")
    public String getAllBook(@ModelAttribute("search") BookSearchDTO dto, Model model, Model theModel) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isAdmin = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(role -> role.equals("ADMIN"));
        System.out.println(authentication.getAuthorities());
        theModel.addAttribute("isAdmin", isAdmin);
        List<books> books = dto.getBooks();
        if (books != null && !books.isEmpty()) {
            model.addAttribute("search", dto.getBooks());
        } else {
            model.addAttribute("search", bookService.getAll());
        }
        return "home";
    }

    @RequestMapping(value = "/addbook", method = { RequestMethod.GET, RequestMethod.POST })
    public String addBook(Model model, books book) {
        model.addAttribute("newBook", book);
        return "addBook";
    }

    @PostMapping("/savebook")
    public String saveBook(@Valid @ModelAttribute("newBook") books book, BindingResult bindingResult, authors author,
            publishingHouses house) {
        if (bindingResult.hasErrors()) {
            return "addBook";
        } else {

            if (authorService.getAuthor(book.getAuthor()) == null) {
                author.setAuthor(book.getAuthor());
                authorService.saveAuthor(author);
                book.setAuthorId(author.getId());
            } else {
                book.setAuthorId(authorService.getAuthor(book.getAuthor()).getId());
            }
            if (publishingHouseService.getPublishingHouses(book.getPublishingHouse()) == null) {
                house.setPublishingHouses(book.getPublishingHouse());
                publishingHouseService.saveHouse(house);
                book.setHouseId(house.getId());
            } else {
                book.setHouseId(house.getId());
            }
            bookService.saveBook(book);
            return "redirect:/home/allbook";

        }
    }

    @GetMapping("/getbook/{id}")
    public String getBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBook(id));
        return "detailsofbook";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/home/allbook";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("updateBook", bookService.getBook(id));
        return "updateBook";
    }

    @PostMapping("/updateBook")
    public String updateBook(@ModelAttribute("updateBook") books book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateBook";
        } else {
            bookService.saveBook(book);
            return "redirect:/home/allbook";
        }
    }

    @RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
    public String search(Model model, @RequestParam("searchInput") String search,
            RedirectAttributes redirectAttributes) {
        if (search.equals("")) {
            return "redirect:/home/allbook";
        }
        List<books> booksIsbn = new ArrayList<>();

        for (Long isbn : bookService.getAllISBN()) {
            if (search.equals(isbn.toString())) {
                booksIsbn.add(bookService.getBook(isbn));
            }
        }
        List<books> books = bookService.getSearchBooks(search);
        books.addAll(booksIsbn);
        Set<books> uniqueBooks = new HashSet<>(books);
        books.clear();
        books.addAll(uniqueBooks);

        BookSearchDTO dto = new BookSearchDTO();

        dto.setBooks(books);
        redirectAttributes.addFlashAttribute("search", dto);

        return "redirect:/home/allbook";
    }
}
