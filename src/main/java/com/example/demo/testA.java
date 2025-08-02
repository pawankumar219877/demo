package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class testA {

}
@Configuration
 class BookSearch{
    @Bean
    public BookRepository bookRepository() {
        return new BookRepository();
    }
    @Bean
    public RecommendationService recommendationService() {
        return new RecommendationService();
    }
}

class RecommendationService {
    @Autowired
    public BookRepository repository;

    public String recommendBook() {
        return repository.getBooks().get(0);
    }
}

class BookRepository {
    public List<String> getBooks() {
        List<String> books = new ArrayList<>();
        books.add("Book");
        books.add("Short book");
        books.add("Long book");

        return books;
    }
}