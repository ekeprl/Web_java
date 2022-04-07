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

@WebServlet("/photo.do")
public class PhotoServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String s = req.getParameter("img"); //변수값은마음대로
		//String b = req.getParameter("y");
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
	//if문을 실행시키기 위한 명령문이 한개이기때문에 중괄호를 사용하지않음.(1번은 중괄호적용)
	if (s.equals("bear")) {
		out.println(" <img src='https://picsum.photos/id/1020/200/300' />");  //Ctrl +1 : 퀵픽스 , src : 그림파일의 위치를 src속성을 이용해 알려주는 것 + 조건에 맞게 달라져야 할 부분
	}
	else if (s.equals("eagle"))out.println(" <img src='https://picsum.photos/id/1024/200/300' />"); //바로 위에서 거짓이 나올 때만 작동하도록 else를 사용,더 효율적
	else if (s.equals("dog"))out.println(" <img src='https://picsum.photos/id/1025/200/300' />"); 
	else out.println("<h1>알 수 없는 동물입니다.</h1>");
	//if (s.equals("bear")== false && s.equals("eagle")==false && s.equals("dog")==false	)out.println("<h1>알 수 없는 동물입니다.</h1>"); //수가 많아지면 쓰기 어렵다. 복잡 
	
	out.println("</body>");
	out.println("</html>");
	//스위치문으로 한번 바꾸보자!
	}
	
	
	}


