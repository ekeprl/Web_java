package com.exam.member;
//회원정보를 저장하는 것은 따로 저장.

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.exam.MemberVo; 잘못된 import문 제거



@WebServlet("/member/list.do") //주소
public class MemListServlet extends HttpServlet {   //클래스 이름
	
	MemberDao memberDao = new MemberDao();
	//실행할 때 한번만 실행되도록 메인메서드밖으로 빼내준다.
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		// "http://localhost:8000/exweb/member/list.do"로 요청을 보내면.
		// 웹브라우저에 회원목록이 출력되도록 구현
		
		
		ArrayList<MemberVo> list = memberDao.selectList();
		//요청올때마다 실행해야한다 : 테이블의 데이터가 계속 바뀌기때문이다.
		
/*		req.setCharacterEncoding("UTF-8");
		String aval = req.getParameter("a"); 
		String[] bvals = req.getParameterValues("b");	 파라미터를 보내지않아 필요가없다.	*/
		
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
		out.println("<h1> 회원목록 </h1>");
		out.println(" 회원아이디 : 회원 비밀번호 : 회원이름 : 회원포인트 <br>");
		
		for(int i=0; i<list.size(); i++) {
			MemberVo vo = list.get(i);
		out.println( vo.getMemId() + " : " + vo.getMemPass() + " : " + vo.getMemName() + " : " + vo.getMemPoint() + "<br>"); 
		} 
		
		
		
		out.println("</body>");
		out.println("</html>");
		
	}

	
		
}


