package org.example.web.dto;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

public class MultipartFileValid {

    @NotNull
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
