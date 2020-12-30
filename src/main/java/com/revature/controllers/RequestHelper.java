package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	public static void process(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
			System.out.println(req.getRequestURI());
			
			String endpoint = req.getRequestURI();
			
			switch(endpoint) {
				case "/CafeApi/api/login" :
					switch(req.getMethod()) {
						case "GET":
							LoginController.loginPage(req, resp);
							break;
						case "POST":
							LoginController.login(req, resp);
							break;
						default:
							resp.setStatus(405);
					
					}
					break;
				case "/CafeApi/api/logout" :
					switch(req.getMethod()) {
					case "GET":
						LoginController.logout(req, resp);
						break;
					default:
						resp.setStatus(405);
					}
					break;
				case "/CafeApi/api/SuperSecret" :
					switch(req.getMethod()) {
					case "GET":
						SuperSecretController.superSecret(req, resp);
						break;
					default:
						resp.setStatus(405);
					}
					break;
				default:
					System.out.println("default");
					resp.setStatus(404);
				
			}
		}
}
