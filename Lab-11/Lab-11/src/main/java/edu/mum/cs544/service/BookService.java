package edu.mum.cs544.service;

import edu.mum.cs544.domain.Book;
import edu.mum.cs544.repository.IBookDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BookService {
    @Resource
    private IBookDao bookDao;

    public List<Book> getAll() {
        return bookDao.getAll();
    }

    public void add(Book book) {
        bookDao.add(book);
    }

    public Book get(int id) {
        return bookDao.get(id);
    }

    public void update(Book book) {
        bookDao.update(book);
    }

    public void delete(int id) {
        bookDao.delete(id);
    }
}
