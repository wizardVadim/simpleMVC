package org.example.app.service;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository implements ProjectRepository<Book> {


    private final Logger logger = Logger.getLogger(BookRepository.class);
    private final List<Book> repo = new ArrayList<>();

    @Override
    public List<Book> retreiveAll() {
        return new ArrayList<>(repo);
    }

    @Override
    public void store(Book book) {
        book.setId(book.hashCode());
        logger.info("Store new book");
        repo.add(book);
    }

    @Override
    public void remove(final Book book) {
        boolean bookIsContained = false;

        for (Book bookFromRepo : repo) {
            if (bookFromRepo.getId().equals(book.getId())) {
                repo.remove(bookFromRepo);
                bookIsContained = true;
                break;
            }
        }
        if (bookIsContained) {
            logger.info("Book by ID: " + book.getId() + " is deleted");
        } else {
            logger.info("Book by ID: " + book.getId() + " is not contained");
        }
    }

    @Override
    public boolean removeItemById(Integer itemIdToRemove) {
        for(Book book : retreiveAll()) {
            if (book.getId().equals(itemIdToRemove)) {
                logger.info("Remove book: " + book.getId() + ", " + book.getTitle());
                return repo.remove(book);
            }
        }
        logger.info("Remove book is not completed ");
        return false;
    }
}
