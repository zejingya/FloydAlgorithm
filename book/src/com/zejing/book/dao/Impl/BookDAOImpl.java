package com.zejing.book.dao.Impl;

import com.zejing.book.dao.BookDAO;
import com.zejing.book.pojo.Book;
import com.zejing.myssm.basedao.BaseDAO;

import java.util.List;

public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {
    @Override
    public List<Book> getBookList() {
        return executeQuery("select * from t_book where bookStatus=0");
    }
}
