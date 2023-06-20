package com.idat.cazaofertas.app.models.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.idat.cazaofertas.app.models.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
}
