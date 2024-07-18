package com.jlcindia.bookstore.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jlcindia.bookstore.to.UserTO;

public class UpdateProfileController extends JLCBaseController {

	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("UpdateProfile-Service()");

		String uri = req.getRequestURI();
		int updateStatus = 0;
		String page = "";

		if (uri.endsWith("editProfile.jlc")) {
			HttpSession session = req.getSession(false);
			if (session == null) {
				String msg = "Session Timed Out,Login again";
				req.setAttribute("LoginMsg", msg);
				page = "login.jsp";

			} else {
				UserTO userTo = (UserTO) session.getAttribute("MyUserInfo");
				int userId = userTo.getUserId();

				UserTO myuserTo = userService.getUserByUserId(userId);
				session.setAttribute("MyUserInfo", myuserTo);
				page = "updateProfile.jsp";
			}

		} else if (uri.endsWith("updateProfile.jlc")) {
			String userId = req.getParameter("userId");
			String full = req.getParameter("fullName");
			String email = req.getParameter("email");
			String ph = req.getParameter("phone");
			String user = req.getParameter("username");

			UserTO userTo = new UserTO();
			userTo.setUserId(Integer.parseInt(userId));
			userTo.setFullName(full);
			userTo.setEmail(email);
			userTo.setPhone(Long.parseLong(ph));
			userTo.setUsername(user);

			updateStatus = userService.updateProfile(userTo);
			if (updateStatus == 1) {
				page = "updateStatus.jsp";
				String msg = "Your Profile is Updated";
				req.setAttribute("UpdateMsg", msg);
			} else {
				page = "updateProfile.jsp";
				String msg = "Something Went Wrong.Try Again SomeOther Time";
				req.setAttribute("UpdateMsg", msg);
			}

		}

		return page;

	}
}