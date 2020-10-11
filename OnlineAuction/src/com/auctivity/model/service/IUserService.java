package com.auctivity.model.service;

import com.auctivity.exceptions.UserNotFoundException;
import com.auctivity.model.beans.User;

public interface IUserService {
	int addUser(User user);
	User getUser(String username, String password) throws UserNotFoundException;
	int deleteUser();
	int updateUser();
//	/User getUserIfExist(String username,String email);
}
