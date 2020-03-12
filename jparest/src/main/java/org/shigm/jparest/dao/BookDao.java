package org.shigm.jparest.dao;

import org.shigm.jparest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface BookDao extends JpaRepository<Book,Integer> {

    @RestResource(path = "oo",rel = "findByName")
    List<Book>  findBookByNameContaining(@Param("name") String  name);
}
