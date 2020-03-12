package org.shigm.thymeleaf.controller;

import org.shigm.thymeleaf.bean.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class BookController {
    @GetMapping("/book")
    public String Book(Model model){
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setId(i);
            book.setAuthor("shigm"+i);
            book.setName("三国演义"+i);
            book.setPrice(100.0);
            books.add(book);
        }
        model.addAttribute("books",books);
        return "books";
    }
}
