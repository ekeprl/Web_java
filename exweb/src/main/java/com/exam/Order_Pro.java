package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/order.do")
public class Order_Pro extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	req.setCharacterEncoding("UTF-8");
	
	String uname = req.getParameter("user");
	//파라미터값이 1개
	String[] foods = req.getParameterValues("ord");
	//values: 파라미터값 여러개
	
	resp.setContentType("text/html;charset=UTF-8");
	
	PrintWriter out=resp.getWriter();
	out.println("<!DOCTYPE html>");
	out.println("<html>");
	out.println("<head>");
	out.println("<meta charset='UTF-8'>");
	out.println("<title>Insert title here</title>");
	out.println("</head>");
	out.println("<body>");
	out.println("<ul>");
	
	int foodCount=0;
	if(foods !=null) { //파라미터값이 존재하는 경우에
		foodCount=foods.length;
		//foodCountsms foods[]배열의 개수를 넘지 않는다.
		for(int i =0 ; i<foods.length; i++) {
			//for문쓰기위한 i변수 설정
			switch(foods[i]) {
			case "p001" :
				out.println("<li>피자</li>");
				break; //만족한다면 스위치문 탈출
			case "p002" :
				out.println("<li>햄버거</li>");
				break;
			case "p003" :
				out.println("<li>돈가스</li>");
				break;
			case "p004" :
				out.println("<li>딸기주스</li>");
				break;
			case "p005" :
				out.println("<li>키위주스</li>");
				break;
				
			
			}
			
		}
	}
	
	out.println("</ul>");
	out.println("<h1>"+uname+"님은 총"+foodCount+"개의 음식을 주문했스빈다.</h1>");
	out.println("</body>");
	out.println("</html>");
		
		
		
	}
	
	

	

}
