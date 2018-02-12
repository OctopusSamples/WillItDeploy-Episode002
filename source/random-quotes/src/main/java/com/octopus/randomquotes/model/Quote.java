package com.octopus.randomquotes.model;

public class Quote {

    Long id;
    String quoteText;
    String author;

    public Quote() {
    }

    public Quote(Long id, String quoteText, String author) {
        this.id = id;
        this.quoteText = quoteText;
        this.author = author;
    }



    public String getQuoteText() {
        return quoteText;
    }

    public String getAuthor() {
        return author;
    }
}
