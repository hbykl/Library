package com.husnaBiyikli.Library.Repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.husnaBiyikli.Library.Entitys.publishingHouses;

public interface publishingHouseRepository extends JpaRepository<publishingHouses, Long> {

    Optional<publishingHouses> findByPublishingHouses(String name);

}
