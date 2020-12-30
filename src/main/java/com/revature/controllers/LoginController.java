package com.revature.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.User;

public class LoginController {
	
	static UserDAO dao = new UserDAOImpl();
	
	public static void loginPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher redis = req.getRequestDispatcher("/index.html");
		redis.forward(req, resp);
	}	
	public static void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
		
		User user = dao.getUserByUsername(username);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				
				System.out.println("login successful");
				
				Cookie uc = new Cookie("username", username);
				Cookie pc = new Cookie("password", password);
				
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
				
				uc.setMaxAge(20);
				pc.setMaxAge(20);
				
				resp.addCookie(uc);
				resp.addCookie(pc);
				
				RequestDispatcher redis = req.getRequestDispatcher("/success.html");
				redis.forward(req, resp);
			} else {
				System.out.println("login failed");
				RequestDispatcher redis = req.getRequestDispatcher("/error.html");
				redis.forward(req, resp);
			}
		} else {
			System.out.println("login failed");
			RequestDispatcher redis = req.getRequestDispatcher("/error.html");
			redis.forward(req, resp);
		}
		
	}
	
	public static void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("logging out");
		req.getSession().setAttribute("user", null);
		req.getSession().invalidate();
		
		resp.sendRedirect("login");
	}

}
