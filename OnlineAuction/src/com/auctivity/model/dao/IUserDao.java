package com.auctivity.model.dao;

import com.auctivity.exceptions.UserNotFoundException;
import com.auctivity.model.beans.User;

public interface IUserDao {
	int addUser(User user);
	User getUser(String username,String password) throws UserNotFoundException;
	int deleteUser();
	int updateUser();
	boolean getUserIfExist(String username,String email);
}
