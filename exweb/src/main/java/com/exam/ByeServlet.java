package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//자동완성을 해야 import가 정확한 위치에 가게된다.
//이 서블릿클래스를 요청 받았을 때 실행되는 서블릿으로 등록하고,
//"/bye.do" 주소로 요청이 오면 실행
@WebServlet("/bye.do")
public class ByeServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ByeServlet 실행!");
	
		resp.setCharacterEncoding("UTF-8");
		
		resp.setContentType("text/html");
		//resp.setContentType("text/html;charset=UTF-8");  = 위의 두줄을 한줄로 합친것 / ctrl + art + 아래방향키 : 한줄복사,  
	
		PrintWriter out = resp.getWriter();
		//out.println("Bye Bye");
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8;'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(" <h1>Bye Bye</h1>"); 
		out.println(" <h2>안녕히 가세요</h2>"); 
		out.println("</body>");
		out.println("</html>");
		
		//http://localhost:8000/exweb/param.do
		//로 요청을 보내면, 브라우저 화면에 큰 제목으로
		//파라미터 테스트
		//라고 출력 되도록 구현
		
	}
	

	
}
