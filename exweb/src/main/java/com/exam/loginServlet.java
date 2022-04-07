package com.exam;

import java.awt.Image;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.do")
public class loginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String s = req.getParameter("id"); //변수값은마음대로
		String c = req.getParameter("pw"); //파라미터값을 변수로 지정해놓는다.
		//int ab = Integer.parseInt(a); //string 값을 int값으로 변경
		//int ad = Integer.parseInt(b);
	
	
			
	resp.setCharacterEncoding("UTF-8");
	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();
	out.println("<!DOCTYPE html>");
	out.println("<html>");
	out.println("<head>");
	out.println("<meta charset='UTF-8'>");
	out.println("<title>Insert title here</title>");
	out.println("</head>");
	out.println("<body>");  // 조건을 만들어 순차적으로 프로그래밍되도록한다.
	
	/*
	 * if (s.equals("user") && c.equals("1234")) { // id = user pw = 1234 둘다 만족하는 경우
	 * 출력 out.println("<h1>사용자 화면</h1>") ; } else if (s.equals("user") ||
	 * c.equals("1234")) { // id = user 와 pw = 1234 둘중 하나만 맞을 경우 출력
	 * out.println("<h1>로그인 실패</h1>") ; } else if (s.equals("admin") &&
	 * c.equals("qwer")) { // id = admin pw = qwer 둘다 만족하는 경우 출력
	 * out.println("<h1>관리자 화면</h1>") ; } else if (s.equals("admin") ||
	 * c.equals("qwer")) { // id = admin pw = qwer 둘 중 하나만 맞을경우
	 * out.println("<h1>로그인 실패</h1>") ; } else out.println("<h2>등록되지 않은 사용자</h2>") ;  // id /pw 전부 틀릴경우
	 */	
	
	if ( s.equals("user")) {
		if(c.equals("1234")) {
			out.println(" 사용자 화면") ;
		}else {
			out.println("로그인 실패") ;
		}
			
	}else if ( s.equals("admin")) {
			if(c.equals("qwer")) {
				out.println("관리자 화면") ;
		}else {
			out.println("로그인 실패") ;
		}
	}else {
	    	out.println("등록되지 않은 사용자") ;
	    }
		
	
	out.println("</body>");
	out.println("</html>");
	//스위치문으로 한번 바꾸보자!
	
	
	
	}
		
		
		
		
	
}
