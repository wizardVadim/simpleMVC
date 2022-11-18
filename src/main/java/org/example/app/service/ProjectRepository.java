package org.example.app.service;

import org.example.web.dto.Book;

import java.util.List;

public interface ProjectRepository<T> {
    List<Book> retreiveAll();

    void store(Book book);

    void removeItemById(Integer itemIdToRemove);

    void removeItemByRegex(String regexToRemove);
}
