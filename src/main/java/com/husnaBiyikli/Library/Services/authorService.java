package com.husnaBiyikli.Library.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.husnaBiyikli.Library.Entitys.authors;
import com.husnaBiyikli.Library.Repositorys.authorRepository;
import com.husnaBiyikli.Library.ServiceImpl.authorImpl;

import java.util.List;

@Service
public class authorService implements authorImpl {

    @Autowired
    authorRepository authorRepository;

    public authorService(authorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<authors> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public void saveAuthor(authors author) {
        authorRepository.save(author);
    }

    @Override
    public authors getAuthor(String name) {
        return authorRepository.findByAuthor(name).orElse(null);
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public authors getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

}
