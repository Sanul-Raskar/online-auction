package com.auctivity.model.service;

import com.auctivity.exceptions.UserNotFoundException;
import com.auctivity.model.beans.User;
import com.auctivity.model.dao.IUserDao;
import com.auctivity.model.dao.UserDaoImpl;

public class UserServiceImpl implements IUserService{

	IUserDao userDao = new UserDaoImpl();
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	@Override
	public User getUser(String username, String password) throws UserNotFoundException{
		// TODO Auto-generated method stub
		return userDao.getUser(username, password);
	}


	@Override
	public int deleteUser() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser() {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
//	public User getUserIfExist(String username, String email) {
//		// TODO Auto-generated method stub
//		return userDao.getUserIfExist(username, email);
//	}

}
