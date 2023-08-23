package com.idat.cazaofertas.app.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.cazaofertas.app.models.entity.Publicacion;


public interface IPublicacionRepository extends JpaRepository<Publicacion, Long>{

}
