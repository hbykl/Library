package com.husnaBiyikli.Library.Entitys;

import com.husnaBiyikli.Library.EnumRole.enumRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Id;

@Entity
@Table(name = "Role")
public class role {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "Role")
    @NotNull
    @Enumerated(EnumType.STRING)
    private enumRole role;

    public role() {
    }

    public role(@NotNull Long id, enumRole role) {
        Id = id;
        this.role = role;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public enumRole getRole() {
        return role;
    }

    public void setRole(enumRole role) {
        this.role = role;
    }

}
