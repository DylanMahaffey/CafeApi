package com.revature.servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Cafe;
import com.revature.models.FoodItem;

@WebServlet("/cafe")
public class CafeServlet extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json"); // This is redundant, default type
		
		Set<String> menu = new HashSet<String>();
		
		
		if(req.getParameter("item") != null) {
			menu.add(req.getParameter("item"));
		} else {
			menu = Cafe.getCafe().getMenuItems();
		}
		
		ObjectMapper om = new ObjectMapper();
		
		
		
		resp.getWriter().write(om.writeValueAsString(menu));
    }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		
		ObjectMapper om = new ObjectMapper();
        FoodItem hs = om.readValue(req.getReader(), com.revature.models.FoodItem.class);
		
		Cafe.getCafe().addFood(hs);
		System.out.println(Cafe.getCafe().getMenuItems());
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		
		ObjectMapper om = new ObjectMapper();
        FoodItem hs = om.readValue(req.getReader(), com.revature.models.FoodItem.class);
		
		Cafe.getCafe().upgradeFood(hs);
		System.out.println(Cafe.getCafe().getMenuItems());
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		
		ObjectMapper om = new ObjectMapper();
        FoodItem hs = om.readValue(req.getReader(), com.revature.models.FoodItem.class);
		
		Cafe.getCafe().deleteFood(hs);
		System.out.println(Cafe.getCafe().getMenuItems());
	}

}
