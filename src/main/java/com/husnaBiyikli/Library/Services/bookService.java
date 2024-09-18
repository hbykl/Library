package com.husnaBiyikli.Library.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.husnaBiyikli.Library.Entitys.books;
import com.husnaBiyikli.Library.Repositorys.bookRepository;
import com.husnaBiyikli.Library.ServiceImpl.bookImpl;
import java.util.ArrayList;

import java.util.List;

@Service
public class bookService implements bookImpl {

    @Autowired
    bookRepository bookRepository;

    public bookService(bookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<books> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public void saveBook(books book) {
        bookRepository.save(book);
    }

    @Override
    public books getBook(Long id) {
        return bookRepository.findByIsbn(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);

    }

    @Override
    public List<Long> getAllISBN() {
        List<books> books = bookRepository.findAll();
        List<Long> isbnList = new ArrayList<>();
        for (books books2 : books) {
            isbnList.add(books2.getIsbn());
        }
        return isbnList;
    }

    @Override
    public List<books> getSearchBooks(String name) {
        List<books> books = new ArrayList<>();
        if (bookRepository.findByBookName(name).isEmpty() & bookRepository.findByAuthor(name).isEmpty()
                & bookRepository.findBySeriesName(name).isEmpty()) {
            books.clear();
        } else {
            books.addAll(bookRepository.findByBookName(name));
            books.addAll(bookRepository.findBySeriesName(name));
            books.addAll(bookRepository.findByAuthor(name));
        }
        return books;
    }
}
