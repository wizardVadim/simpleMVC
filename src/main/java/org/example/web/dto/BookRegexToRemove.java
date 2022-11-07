package org.example.web.dto;

import javax.validation.constraints.NotEmpty;

public class BookRegexToRemove {

    @NotEmpty
    private String regex;

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
}
