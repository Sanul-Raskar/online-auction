package com.auctivity.model.dao;

import com.auctivity.model.beans.User;

public interface IUserDao {
	int addUser(User user);
	User getUser(String username,String password);
	int deleteUser();
	int updateUser();
}
