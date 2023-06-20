package com.idat.cazaofertas.app.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.idat.cazaofertas.app.models.entity.Profile_User;

public interface IProfile_UserRepository extends JpaRepository<Profile_User, Long>{

	@Query(value = "SELECT p.* FROM profiles_users p INNER JOIN users u ON u.id = p.user_id WHERE u.username = :username", nativeQuery = true)
    Profile_User findByUser_UsernameProfile_User(@Param("username") String username);
	
}
