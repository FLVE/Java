package me.iwjf.controller;

import me.iwjf.bean.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    @GetMapping("/book")
    public String book(Model model){
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setId((long) i);
            book.setName("西游记"+i);
            book.setAuthor("吴承恩"+i);
            book.setPrice(78.8);
            bookList.add(book);
        }
        model.addAttribute("books",bookList);
        return "book";

    }
}
