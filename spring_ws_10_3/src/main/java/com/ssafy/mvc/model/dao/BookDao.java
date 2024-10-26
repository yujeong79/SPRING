package com.ssafy.mvc.model.dao;

import java.util.List;

import com.ssafy.mvc.model.dto.Book;
import com.ssafy.mvc.model.dto.SearchCondition;

public interface BookDao {
	
	List<Book> selectByCondition(SearchCondition condition);
	
	int insertBook(Book book);
	
	int updateBook(Book book);
	
	Book selectByIsbn(String isbn);
	
	int deleteBook(String isbn);
	
}
