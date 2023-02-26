package cn.com.ice.jpaes;

import cn.com.ice.jpaes.entity.Book;
import cn.com.ice.jpaes.repository.BookRepository;
import cn.com.ice.jpaes.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
//@RunWith(SpringRunner.class)
@SpringBootTest
class JpaEsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;

    @Test
    public void testSave() {
        //创建一个书籍对象
        Book book = new Book();
        book.setId("1");
        book.setName("Java编程思想");
        book.setAuthor("Bruce Eckel");
        book.setPrice(99.0);
        //调用保存方法
        bookService.save(book);
        //从es中查询该书籍
        Optional<Book> optional = bookRepository.findById("1");
        //断言该书籍存在且属性正确
        Assert.assertTrue(optional.isPresent());
        Assert.assertEquals(book.getName(), optional.get().getName());
    }

    @Test
    public void testFindByName() {
        //创建两个书籍对象，其中一个包含Java这个词
        Book book1 = new Book();
        book1.setId("2");
        book1.setName("Effective Java");
        book1.setAuthor("Joshua Bloch");
        book1.setPrice(79.0);

        Book book2 = new Book();
        book2.setId("3");
        book2.setName("Python编程从入门到精通");
        book2.setAuthor("Eric Matthes");
        book2.setPrice(69.0);
        //调用保存方法
        List<Book> books = Arrays.asList(book1,book2);
        for (Book b : books) {
            bookService.save(b);
        }
        //从es中查询包含Java的书籍
        List<Book> result = bookService.findByName("Java");
        //断言结果只有一本书且属性正确
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(book1.getName(), result.get(0).getName());
    }
}
