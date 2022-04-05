package com.joshuamatos.Crud2.books;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunnerBooks(BookRepository bookRepository){
        return args -> {
                Clock clock = Clock.fixed(Instant.parse("2014-12-22T10:15:30.00Z"), ZoneId.of("UTC"));
                LocalDateTime dateTime = LocalDateTime.now(clock);
                Book book1 = new Book("Grav", dateTime);
        };
    }
}