package org.shigm.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaApplicationTests {

    @Autowired
    BookDao dao;
    @Test
    void contextLoads() {
        Book s = new Book();
        s.setAuthor("时光明");
        s.setName("三国演义");
        dao.save(s);
    }

    @Test
    public  void update(){
        Book s = new Book();
        s.setName("水浒传");
        s.setAuthor("yangjie");
        s.setId(1);
        dao.saveAndFlush(s);
    }

    @Test
    public void find(){
        Optional<Book> byId = dao.findById(1);
        System.out.println(byId.get());

        List<Book> all = dao.findAll();
        System.out.println(all);
    }
    @Test
    public void find1(){
        List<Book> books = dao.findBookByIdGreaterThan(2);
        System.out.println(books);
    }
}
