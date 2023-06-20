package com.idat.cazaofertas.app.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
/*import org.springframework.security.core.userdetails.UserDetails;*/
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
	
	@Override
	@Transactional(readOnly = true)
	public Profile_User findByUser_UsernameProfile_User() {
		/*UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String us = userDetails.getUsername();*/
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String us = authentication.getName();
		
		return iProfile_UserRepository.findByUser_UsernameProfile_User(us);
	}
}
