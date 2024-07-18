package com.jlc.BookStore.service;

import com.jlc.BookStore.DAO.DAOFactory; 


import com.jlc.BookStore.DAO.UserDAO;
import com.jlcindia.bookstore.to.UserTO;

public class UserServiceImpl implements UserService {

	@Override
	public int registerUser(UserTO userTo) {
	System.out.println("UserService -RegisterUser");
	UserDAO userDAO=DAOFactory.getUserDAO();
	
		return userDAO.registerUser(userTo);
	}

	@Override
	public UserTO verifyUser(String username, String password) {
		UserDAO userDAO=DAOFactory.getUserDAO();
		
		return userDAO.verifyUser(username, password);
	}

	@Override
	public String getPassword(String email) {
		UserDAO userDAO=DAOFactory.getUserDAO();
		return userDAO.getPassword(email);
	}

	@Override
	public int changePassword(int userId, String newPassword) {
		UserDAO userDAO=DAOFactory.getUserDAO();
		
		return userDAO.changePassword(userId, newPassword);
	}

	@Override
	public UserTO getUserByUserId(int userId) {
		UserDAO userDAO=DAOFactory.getUserDAO();
		return userDAO.getUserByUserId(userId);
	}

	@Override
	public int updateProfile(UserTO userTo) {
		UserDAO userDAO=DAOFactory.getUserDAO();
		return userDAO.updateProfile(userTo);
	}

}