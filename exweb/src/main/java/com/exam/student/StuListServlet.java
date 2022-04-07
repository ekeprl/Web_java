package com.exam.student;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹브라우저에서 "http://localhost:8000/exwev/student/list.do"로 접속하면
//학생목록이 출력되도록 구현



@WebServlet("/student/list.do") //주소
public class StuListServlet extends HttpServlet {   //클래스 이름
	
	
	StudentDao studentDao = new StudentDao();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		
		ArrayList<StudentVo> list = studentDao.selectList();
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
		out.println(" 학번   :   이름  :   학점 <br>");
		
		for(int i=0; i<list.size(); i++) {
			StudentVo vo = list.get(i);
		out.println( vo.getStuno() + " : " + vo.getStuname() + " : " + vo.getStuscore() +   "<br>"); 
		} 
		
		
		
		out.println("</body>");
		out.println("</html>");
		
	}

	
		
}


