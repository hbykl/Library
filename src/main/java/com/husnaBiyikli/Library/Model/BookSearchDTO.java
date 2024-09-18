package com.husnaBiyikli.Library.Model;

import java.util.List;
import com.husnaBiyikli.Library.Entitys.books;

public class BookSearchDTO {

    private List<books> books;

    public List<books> getBooks() {
        return books;
    }

    public void setBooks(List<books> books) {
        this.books = books;
    }
}
