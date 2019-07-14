package edu.mum.cs544.repository;

import edu.mum.cs544.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookDao extends JpaRepository<Book,Integer> {

}
