package org.example.web.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private Integer id;

    @NotEmpty(message = "it should be not empty")
    @Size(min = 2, max = 20, message = "Size is not right, MIN = 2, MAX = 20")
    private String author;

    @NotEmpty(message = "it should be not empty")
    @Size(min = 2, max = 15, message = "Size is not right, MIN = 2, MAX = 15")
    private String title;

    @Digits(integer = 4, fraction = 0)
    private Integer size;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", size=" + size +
                '}';
    }
}
