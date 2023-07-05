package com.idat.cazaofertas.app.models.service;

import java.util.List;

import com.idat.cazaofertas.app.models.entity.Publicacion;

public interface IPublicacionService {
	
	public List<Publicacion> listar();
	
	Publicacion guardar (Publicacion publicacion);
}
