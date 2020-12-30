package com.revature.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SuperSecretController {
	
	public static void superSecret(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("user") != null) {
			
			RequestDispatcher redis = req.getRequestDispatcher("/superSecret.html");
			redis.forward(req, resp);
			
		} else {
			
			resp.getWriter().write("Get a session!");				
			
			
		}
	}	

}
