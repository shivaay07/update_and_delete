package com.duttech.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.duttech.mvc.models.Book;
import com.duttech.mvc.repositories.BookRepository;

@Service
public class BookService {

	//Adding the book Repository as a dependency
	
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
//	return all the books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

//	create a book
	
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	
//	retrieve a book
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		else {
			return null;
		}
	}

	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
		
	}

	public Book update(Long id, String title, String desc, String lang, Integer numOfPages) {
		Book newBook = findBook(id);
		newBook.setTitle(title);
		newBook.setDescription(desc);
		newBook.setLanguage(lang);
		newBook.setNumberOfPages(numOfPages);
		return bookRepository.save(newBook);
		
		
	}
}
