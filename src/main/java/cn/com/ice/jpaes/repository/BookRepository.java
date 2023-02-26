package cn.com.ice.jpaes.repository;

import cn.com.ice.jpaes.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book, String> {
    //可以自定义一些查询方法，遵循命名规则
    List<Book> findByName(String name);

}