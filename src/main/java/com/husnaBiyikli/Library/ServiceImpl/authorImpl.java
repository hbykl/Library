package com.husnaBiyikli.Library.ServiceImpl;

import com.husnaBiyikli.Library.Entitys.authors;

import java.util.List;

public interface authorImpl {

    List<authors> getAllAuthors();

    void saveAuthor(authors author);

    authors getAuthor(String name);

    void delete(Long id);

    authors getAuthorById(Long id);
}
