package com.husnaBiyikli.Library.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.husnaBiyikli.Library.Entitys.user;

public interface userRepository extends JpaRepository<user, Long> {
    user findByUserName(String userName);
}
