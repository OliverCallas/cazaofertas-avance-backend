package com.idat.cazaofertas.app.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.cazaofertas.app.models.entity.Profile_User;
import com.idat.cazaofertas.app.models.repository.IProfile_UserRepository;

@Service
public class Profil_UserServiceImpl implements IProfile_UserService{

	@Autowired
    private IProfile_UserRepository iProfile_UserRepository;
	
	@Override
	@Transactional
	public Profile_User guardar(Profile_User profile_User) {
		return iProfile_UserRepository.save(profile_User);
	}
}
