package com.joshuamatos.Crud2.books;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunnerBooks(BookRepository bookRepository) {
        return args -> {
            Clock clock = Clock.fixed(Instant.parse("2014-12-22T10:15:30.00Z"), ZoneId.of("UTC"));
            LocalDateTime dateTime = LocalDateTime.now(clock);
            Book book1 = new Book("Grav", dateTime);
            Book book2 = new Book("Grates", dateTime);
            Book book3 = new Book("Grobs", dateTime);
            Book book4 = new Book("Elden", dateTime);
            Book book5 = new Book("Ring", dateTime);
            Book book6 = new Book("Axes", dateTime);
            bookRepository.saveAll(List.of(book1, book2, book3, book4, book5, book6));
        };
    }
}