package com.duttech.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duttech.mvc.models.Book;
import com.duttech.mvc.services.BookService;

@Controller
public class BooksController {
	private final BookService bookService;
	
	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/books/{id}")
	public String showBook(@PathVariable("id") Long id,
			Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute(book);
		return "/books/show.jsp";
	}
	
	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("books") Book book) {
		return "/books/new.jsp";
	}
	
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "/books/index.jsp";
	}
}
