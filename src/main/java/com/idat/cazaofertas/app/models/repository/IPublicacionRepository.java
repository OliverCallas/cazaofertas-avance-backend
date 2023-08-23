package com.idat.cazaofertas.app.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.idat.cazaofertas.app.models.entity.Publicacion;


public interface IPublicacionRepository extends JpaRepository<Publicacion, Long>{

	@Query("SELECT p FROM Publicacion p ORDER BY p.fecha DESC")
    List<Publicacion> findAllByFechaPublicacionDesc();
	
}
