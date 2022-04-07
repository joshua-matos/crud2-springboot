package com.joshuamatos.Crud2.books;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class BookController {


    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public Optional<Book> createABookWithJSONRequest(@RequestBody Book book) {
        return bookService.createABook(book);
    }

    @GetMapping("/books/{id}")
    public Optional<Book> returnASingleBookByPathVarId(@PathVariable Long id) {
        return bookService.returnASingleBookById(id);
    }

    @PatchMapping("/books/{id}")
    public Optional<Book> patchASingleBooksByPathVarId(
            @PathVariable Long id,
            @RequestBody(required = false) Book book) {
        return bookService.updateASingleBook(id, book);
    }

    @DeleteMapping("/books/{id}")
    public String deleteASingleBooksById(@PathVariable Long id) {
        return bookService.deleteASingleBookById(id);
    }

    @GetMapping("/books")
    public List<Book> returnAllBookUsingList() {
        return bookService.returnAListOfBooks();
    }
}