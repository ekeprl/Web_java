package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/order.do")
public class OrderServlet extends HttpServlet{
 @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	 String a = req.getParameter("user");
	 
	 String[] foods = req.getParameterValues("menu");
	 
	 	resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println( "a" + "님은 총" + foods.length + "개의 음식을 주문하셨습니다.");	
		for (int c =0 ; c<=foods.length ; c++ ) {
			//String order = foods[c];
		switch (foods[c]) {
		case "p001" : 
			out.println("<ul>" + "<li>" + "피자" + "</li>" + "</ul>");
			break; 
		case "p002":	
			out.println("<ul>" + "<li>" + "햄버거" + "</li>" + "</ul>");
			break;
		case "p003":	
			out.println("<ul>" + "<li>" + "돈가스" + "</li>" + "</ul>");
			break;
		case "p101":	
			out.println("<ul>" + "<li>" + "키위쥬스" + "</li>" + "</ul>");
			break;
		case "p102":	
			out.println("<ul>" + "<li>" + "딸기쥬스" + "</li>" + "</ul>");
			break;
		
			
		}
		
		}
		
		out.println("</body>");
		out.println("</html>");
	 
	 
	 
	 
	 
}
}
