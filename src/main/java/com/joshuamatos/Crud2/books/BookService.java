package com.joshuamatos.Crud2.books;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    //Create
    public Optional<Book> createABook(Book book) {
        if (book.getName() != null || book.getPublishDate() != null) {
            bookRepository.save(book);
            return Optional.of(book);
        } else return Optional.empty();
    }


    //Read
    public Optional<Book> returnASingleBookById(Long id) {
        if (bookRepository.existsById(id)) {
            return bookRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }

    //Update
    public Optional<Book> updateASingleBook(Long id, Book book) {
        if (bookRepository.existsById(id)) {
            Book updateBook = bookRepository.findUserById(id);

            if (book.getName() != null && book.getName().length() > 0) {
                updateBook.setName(book.getName());
            }

            if (book.getPublishDate() != null) {
                updateBook.setPublishDate(book.getPublishDate());
            }
            return Optional.of(updateBook);
        } else {
            return Optional.empty();
        }
    }

    //Delete
    public String deleteASingleBookById(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return "book deleted. Count:" + bookRepository.count();
        } else {
            return "book does not exist.";
        }
    }

    //List
    public List<Book> returnAListOfBooks() {
        return bookRepository.findAll();
    }


}