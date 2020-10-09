package com.auctivity.model.dao;

import com.auctivity.model.beans.User;

public interface IUserDao {
	int addUser(User user);
	User getUser();
	int deleteUser();
	int updateUser();
}
