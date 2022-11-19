package org.example.app.exceptions;

public class BookShelfUploadException extends Exception{
    private String message;

    public BookShelfUploadException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
