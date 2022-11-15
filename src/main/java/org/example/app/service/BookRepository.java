package org.example.app.service;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository implements ProjectRepository<Book>, ApplicationContextAware {


    private final Logger logger = Logger.getLogger(BookRepository.class);
//    private final List<Book> repo = new ArrayList<>();
    private ApplicationContext context;

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public BookRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> retreiveAll() {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books", (ResultSet rs, int rowNum) ->
        {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setAuthor(rs.getString("author"));
            book.setTitle(rs.getString("title"));
            book.setSize(rs.getInt("size"));
            return book;
        });
        return new ArrayList<>(books);
    }

    @Override
    public void store(Book book) {
//        book.setId(context.getBean(IdProvider.class).provideId(book));
        logger.info("Store new book");
//        repo.add(book);
    }

    @Override
    public void remove(final Book book) {
        boolean bookIsContained = false;

//        for (Book bookFromRepo : repo) {
//            if (bookFromRepo.getId().equals(book.getId())) {
//                repo.remove(bookFromRepo);
//                bookIsContained = true;
//                break;
//            }
//        }
        if (bookIsContained) {
            logger.info("Book by ID: " + book.getId() + " is deleted");
        } else {
            logger.info("Book by ID: " + book.getId() + " is not contained");
        }
    }

    @Override
    public void removeItemById(Integer itemIdToRemove) {
        boolean bookIsContained = false;
        for(Book book : retreiveAll()) {
            if (book.getId().equals(itemIdToRemove)) {
                logger.info("Remove book: " + book.getId() + ", " + book.getTitle());
//                repo.remove(book);
                bookIsContained = true;
            }
        }
        if (!bookIsContained) {
            logger.info("Remove books is not completed ");
        }
    }

    @Override
    public void removeItemByRegex(String regexToRemove) {
        boolean bookIsContained = false;
        for (Book book : retreiveAll()) {
            if (book.getAuthor().equals(regexToRemove)
                    || book.getTitle().equals(regexToRemove)
                    || (book.getSize() != null && book.getSize().equals(Integer.valueOf(regexToRemove)))
            ) {
                logger.info("Remove book: " + book.getId() + ", " + book.getTitle());
//                repo.remove(book);
                bookIsContained = true;
            }
        }
        if (!bookIsContained) {
            logger.info("Remove books is not completed ");
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    private void defaultInit() {
        logger.info("default INIT in repo bean");
    }

    private  void defaultDestroy() {
        logger.info("default DESTROY in repo bean");
    }
}
