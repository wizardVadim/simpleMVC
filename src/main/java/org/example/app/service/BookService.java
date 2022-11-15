package org.example.app.service;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private Logger logger = Logger.getLogger(BookService.class);
    private final ProjectRepository<Book> bookRepo;

    @Autowired
    public BookService(ProjectRepository<Book> bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.retreiveAll();
    }

    public void saveBook(Book book) {
        bookRepo.store(book);
    }

    public void removeBook(Book book) {
        bookRepo.remove(book);
    }

    public void removeBookById(Integer bookIdToRemove) {
        bookRepo.removeItemById(bookIdToRemove);
    }

    public void removeBookByRegex(String regexToRemove) {
        bookRepo.removeItemByRegex(regexToRemove);
    }

    private void defaultInit() {
        logger.info("default INIT in book service");
    }

    private  void defaultDestroy() {
        logger.info("default DESTROY in book service");
    }
}
