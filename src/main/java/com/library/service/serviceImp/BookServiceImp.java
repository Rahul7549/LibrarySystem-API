package com.library.service.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.library.service.Repository.BooksRepository;
import com.library.service.model.Books;


@Service
public class BookServiceImp {
	
	@Autowired
	BooksRepository booksRepository;
	
	public ResponseEntity<?> getAllBooks()   
	{ 
		List<Books> books=booksRepository.findAll();
		if(books.size()>0)
			return new ResponseEntity<List<Books>>(books,HttpStatus.OK);
		else
			return new ResponseEntity<>("No Books available",HttpStatus.NOT_FOUND);
	}
	//get booby id.......
	public Books getBookById(long bookid)   
	{ 
		Optional<Books> books=booksRepository.findById(bookid);
		if(books.isPresent()) {
			return books.get();
		}
		return null;
	}
	
	
	//create Book...
	public Books createBook(Books newBook)
	{
		return booksRepository.save(newBook);
	}
	
	///UPDATE BOOKS
	public Books updateBook(Books newBook)
	{
		return booksRepository.findById(newBook.getBookid())
				.map(book -> {
					book.setAuthor(newBook.getAuthor());
					book.setTitle(newBook.getTitle());
					book.setAvailable(newBook.isAvailable());
					book.setPrice(newBook.getPrice());
					return booksRepository.save(book);
				})
				.orElseGet(() ->{
					return booksRepository.save(newBook);
				});
		
	}
	//Delete book
	public void deleteBook(Long bookid) {
		booksRepository.deleteById(bookid);
		
	}

}
