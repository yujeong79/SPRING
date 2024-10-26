package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.BookDao;
import com.ssafy.mvc.model.dto.Book;
import com.ssafy.mvc.model.dto.SearchCondition;

@Service
public class BookServiceImpl implements BookService {

	private BookDao dao;
	
	public BookServiceImpl(BookDao dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Book> searchByCondition(SearchCondition condition) {
		return dao.selectByCondition(condition);
	}

	@Override
	public boolean registBook(Book book) {
		return dao.insertBook(book) > 0;
	}

	@Override
	public boolean modifyBook(Book book) {
		return dao.updateBook(book) > 0;
	}

	@Override
	public Book searchByIsbn(String isbn) {
		return dao.selectByIsbn(isbn);
	}

	@Override
	public boolean removeBook(String isbn) {
		return dao.deleteBook(isbn) > 0;
	}

}
