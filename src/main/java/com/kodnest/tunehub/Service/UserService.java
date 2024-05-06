package com.kodnest.tunehub.Service;

import com.kodnest.tunehub.entity.User;


public interface UserService {
	 void saveUser(User user);
	boolean emailExists(User user);
	boolean validUser(String email, String password);
	String getRole(String email);
	User getUser(String mail);
	void updateUser(User user);
	
}
