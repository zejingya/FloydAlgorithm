package com.zejing.book.service.Impl;

import com.zejing.book.dao.BookDAO;
import com.zejing.book.pojo.Book;
import com.zejing.book.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;
    @Override
    public List<Book> getBookList() {
        return bookDAO.getBookList();
    }
}
