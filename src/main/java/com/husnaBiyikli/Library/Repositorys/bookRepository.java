package com.husnaBiyikli.Library.Repositorys;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.husnaBiyikli.Library.Entitys.books;

public interface bookRepository extends JpaRepository<books, Long> {

    Optional<books> findByIsbn(Long isbn);

    List<books> findByBookName(String BookName);

    List<books> findByAuthor(String author);

    List<books> findBySeriesName(String seriesName);
}
