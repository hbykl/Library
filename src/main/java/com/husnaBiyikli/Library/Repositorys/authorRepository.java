package com.husnaBiyikli.Library.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import com.husnaBiyikli.Library.Entitys.authors;

import java.util.Optional;

public interface authorRepository extends JpaRepository<authors, Long> {
    Optional<authors> findByAuthor(String author);
}