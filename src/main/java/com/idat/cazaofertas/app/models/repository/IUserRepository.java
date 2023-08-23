package com.idat.cazaofertas.app.models.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.idat.cazaofertas.app.models.entity.User;


public interface IUserRepository extends JpaRepository<User, Long> {
}
