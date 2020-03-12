package org.shigm.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDao extends JpaRepository<Book,Integer> {

    List<Book> findBookByIdGreaterThan(Integer id);
}
