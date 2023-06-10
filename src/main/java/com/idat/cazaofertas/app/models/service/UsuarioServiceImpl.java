package com.idat.cazaofertas.app.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.cazaofertas.app.models.dao.IUsuarioRepository;
import com.idat.cazaofertas.app.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	@Transactional
	public Usuario guardar(Usuario usu) {
		String encryptedPassword = passwordEncoder.encode(usu.getPassword());
		usu.setPassword(encryptedPassword);
        
		return usuarioRepository.save(usu);
	}
	
	
	

}
