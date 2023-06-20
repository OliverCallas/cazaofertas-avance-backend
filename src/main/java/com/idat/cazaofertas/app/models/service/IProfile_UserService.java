package com.idat.cazaofertas.app.models.service;

import com.idat.cazaofertas.app.models.entity.Profile_User;

public interface IProfile_UserService {

	public Profile_User guardar(Profile_User profile_User);
	
	Profile_User findByUser_UsernameProfile_User();
}
