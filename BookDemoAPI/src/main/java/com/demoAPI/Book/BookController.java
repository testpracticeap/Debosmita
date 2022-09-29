package com.demoAPI.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookservice;

	@GetMapping("/books")
	public List<Book> getBooks() {

		return this.bookservice.getAllBooks();
	}
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		this.bookservice.addBook(book);
		return book;
	}
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
		
		this.bookservice.updateBook(book, bookId); 
		return book;
	}
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {
		this.bookservice.deleteBook(bookId); 
	}
}