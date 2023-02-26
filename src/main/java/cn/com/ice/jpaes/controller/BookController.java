package cn.com.ice.jpaes.controller;

import cn.com.ice.jpaes.entity.Book;
import cn.com.ice.jpaes.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("saveData")
    public void saveData(@RequestBody Book book){
        bookService.save(book);
        System.out.println("write over");
    }

    @PostMapping("getDataByName")
    public void getDataById(String name){
        List<Book> books = bookService.findByName(name);
        System.out.println(books.toString());
    }
}
