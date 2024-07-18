package com.jlcindia.bookstore.servlet;

import javax.servlet.http.HttpServlet;

import com.jlcindia.bookstore.controllers.*;

public abstract class JLCBaseServlet extends HttpServlet {

	static LoginController loginController;
	static RegisterController registerController;
	static ChangePWController changePWController;
	static ForgotPWController forgotPWController;
	static UpdateProfileController updateProfileController;
	static LogoutController logoutController;

	static {
		loginController = new LoginController();
		registerController = new RegisterController();
		changePWController = new ChangePWController();
		forgotPWController = new ForgotPWController();
		updateProfileController = new UpdateProfileController();
		logoutController = new LogoutController();
	}
}
