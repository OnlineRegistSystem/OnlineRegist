package com.online.service;

import java.util.List;

import com.online.model.Book;

public interface BookService {
	
	public int addBook(Book record);
	public int setBook(Integer bookId,int type);
	public List getBook(Integer userId);

}
