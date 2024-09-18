package com.husnaBiyikli.Library.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.husnaBiyikli.Library.Entitys.role;

public interface roleRepository extends JpaRepository<role, Long> {
    role findByRole(String role);

}
