package com.idat.cazaofertas.app.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.cazaofertas.app.models.entity.Publicacion;

@Repository
public interface IPublicacionRepository extends JpaRepository<Publicacion, Long>{

}
