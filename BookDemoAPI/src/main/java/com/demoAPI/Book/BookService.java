package com.demoAPI.Book;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public class BookService {

	private static List<Book> list = new ArrayList<>();
	
	static {
		list.add(new Book(1, "Java Refference", "Zeak"));
		list.add(new Book(2, "Python Refference", "Jared"));
		list.add(new Book(3, "DBMS Refference", "Michela"));
	}
	public List<Book> getAllBooks()
	{	
		return list;
	}
	
	public void addBook(Book b) {
		list.add(b);
	}
	
	public void updateBook(Book book, int bookId) {

	       list= list.stream().map(b->{
	    	   if(b.getId()==bookId) {
	    		   b.setTitle(book.getTitle());
	    		   b.setAuthor(book.getAuthor());
	    	   }
	    	   return b;
	       }).collect(Collectors.toList());
	    }
	
	public void deleteBook(int bookId) {
		list=list.stream().filter(book->{
			if(book.getId()!=bookId) {
				return true;
			}else {
				return false;
			}
		}).collect(Collectors.toList());
	}
	}