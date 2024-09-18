package com.husnaBiyikli.Library.ServiceImpl;

import java.util.List;
import com.husnaBiyikli.Library.Entitys.books;

public interface bookImpl {

    List<books> getAll();

    void saveBook(books book);

    books getBook(Long id);

    void delete(Long id);

    List<Long> getAllISBN();

    List<books> getSearchBooks(String name);
}
