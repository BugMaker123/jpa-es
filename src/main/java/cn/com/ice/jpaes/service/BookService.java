package cn.com.ice.jpaes.service;

import cn.com.ice.jpaes.entity.Book;
import cn.com.ice.jpaes.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;


    public void save(Book book) {
        //保存到es和数据库中
        bookRepository.save(book);
    }

    public List<Book> findByName(String name) {
        //从es中查询符合条件的书籍
        return bookRepository.findByName(name);
    }
}