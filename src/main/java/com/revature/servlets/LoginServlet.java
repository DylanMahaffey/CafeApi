package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Cafe;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	static UserDAO dao = new UserDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookieList = req.getCookies();
		
		if(cookieList.length > 0) {
			for(Cookie c: cookieList) {
				System.out.println(c.getValue());
			}			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
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
				
				RequestDispatcher redis = req.getRequestDispatcher("success.html");
				redis.forward(req, resp);
			} else {
				System.out.println("login failed");
				RequestDispatcher redis = req.getRequestDispatcher("error.html");
				redis.forward(req, resp);
			}
		} else {
			System.out.println("login failed");
			RequestDispatcher redis = req.getRequestDispatcher("error.html");
			redis.forward(req, resp);
		}
		
	}
	
}
