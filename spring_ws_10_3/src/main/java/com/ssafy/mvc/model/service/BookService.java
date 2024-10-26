package com.ssafy.mvc.model.service;

import java.util.List;

import com.ssafy.mvc.model.dto.Book;
import com.ssafy.mvc.model.dto.SearchCondition;

public interface BookService {
	
	List<Book> searchByCondition(SearchCondition condition);
	
	boolean registBook(Book book);
	
	boolean modifyBook(Book book);
	
	Book searchByIsbn(String isbn);
	
	boolean removeBook(String isbn);
}
