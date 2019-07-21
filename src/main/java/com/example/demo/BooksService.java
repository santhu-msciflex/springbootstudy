package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksService {

	@GetMapping("/something")	
	public List<Book> getBooks(){		
		return Arrays.asList(new Book(100, "Sample Book", "Santhosh"));		
	}
	
	@GetMapping("/something1")	
	public List<Book> getBooks1(){		
		return Arrays.asList(new Book(101, "Sample Book1", "Santhosh1"));		
	}
}

class Book {
	private int id;
	private String name;
	private String author;
	
	public Book( int id, String name, String author) {
		this.id = id;
		this.name = name;
		this.author = author;		
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}
	
}