package com.idat.cazaofertas.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.cazaofertas.app.models.entity.Usuario;


public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{

}
