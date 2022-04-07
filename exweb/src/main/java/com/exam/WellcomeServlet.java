package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/wellcome.do")
public class WellcomeServlet extends HttpServlet {          //service메서드 생성 
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		GET 방식으로 전송된 한글 파라미터 값 인코딩 설정
//			톰캣 설정 파일 server.xml에서
//			<Connector port="8000"을 찾아 URIEncoding="UTF-8">(한글)를 설정해야한다
//			톰캣 8버전부터 "UTF-8"이 디폴트값이므로 생략가능
//		POST 방식으로 전송된 한글 파라미터 값 인코딩 설정
//		파라미터값을 읽기 전에 요청객체의 문자인코딩 방식을 설정
//		바로 아래 req.setCharacterEncoding("UTF-8");값 추가
		
		req.setCharacterEncoding("UTF-8");       //크롬이 보내온 정보를 어떻게 해석할꺼냐
		String aval = req.getParameter("user");  //파라미터를 꺼내오고 변수에 저장.  user -> aval -> 출력
				
		resp.setCharacterEncoding("UTF-8");		 //크롬한테 보낼 정보를 어떤 방식으로 보내느냐
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>" + aval + "님 환영합니다 " + "</h1>");
		//out.println("<h2>" + abc + "</h2>"); 
		out.println("</body>");
		out.println("</html>");
		
	}
	
	

}
