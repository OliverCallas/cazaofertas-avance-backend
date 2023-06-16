package com.idat.cazaofertas.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.cazaofertas.app.models.entity.Publicacion;
import com.idat.cazaofertas.app.models.repository.IPublicacionRepository;

@Service
public class PublicacionService implements IPublicacionService {

	@Autowired
	private IPublicacionRepository iPublicacionRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Publicacion> listar() {
		return iPublicacionRepository.findAll();
	}

	
}
