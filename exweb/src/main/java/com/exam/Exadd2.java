package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add.do")  //add.do를 달라고 요청이 오면 뒤 서비스 메소드가 실행됨
public class Exadd2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		String a = req.getParameter("x"); //변수값은마음대로
		String b = req.getParameter("y");
		
		
		int ab = Integer.parseInt(a); //string 값을 int값으로 변경
		int ad = Integer.parseInt(b);
		
		String opv = req.getParameter("op"); //새로운 연산자 변수 지정 (form.html)
		
		
		
		
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
		 switch (opv) {
		case "p": 
			out.println("<h1>" + a + " + " + b + " = " + (ab + ad) + "</h1>");
			break;
		case "m":
			out.println("<h1>" + a + " * " + b + " = " + (ab * ad) + "</h1>");
			break;
					
		}
		/*
		 * out.println("<h1>" + a + "+" + b + "=" + (ab + ad) + "</h1>");
		 */
		
		out.println("</body>");
		out.println("</html>");
	}

}
	//Ctrl +1 : 퀵픽스
	
//http://localhost:8000/exweb/photo.do?img=동물이름
// 동물이름이 "bear"이면
// 		화면에 https://picsum.photos/id/1020/200/300 이미지 출력
// 동물이름이 "eagle"이면
// 		화면에 https://picsum.photos/id/1024/200/300 이미지 출력
// 동물이름이 "dog"이면
// 		화면에 https://picsum.photos/id/1025/200/300 이미지 출력
// 그 밖에 다름 이름이면
// 		"알 수 없는 동물입니다." 라고 출력
//그림파일 : picsum (주소로 이미지 제공)




//http://localhost:8000/exweb/login.do?id=아이디&pw=비밀번호
//로 요청을 보내면,
// 아이디가 user 이고
//		비밀먼호가"1234" 이면, "사용자 화면" 출력
//		비밀먼호가"1234"가 아니면, "로그인 실패" 출력
// 아이디가 admin 이고
//		비밀번호가"qwer" 이면, "사용자 화면" 출력
//		비밀번호가"qwer"가 아니면, "로그인 실패" 출력
// 다른 아이디면, "등록되지 않은 사용자" 출력
