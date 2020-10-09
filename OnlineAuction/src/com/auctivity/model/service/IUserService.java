package com.auctivity.model.service;

import com.auctivity.model.beans.User;

public interface IUserService {
	int addUser(User user);
	User getUser();
	int deleteUser();
	int updateUser();
}
