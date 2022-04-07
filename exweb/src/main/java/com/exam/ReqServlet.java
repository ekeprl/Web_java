package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/req.do")

public class ReqServlet extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//클라이언트가 보낸 모든 정보는 
		//요청객체 HttpServletRequest에 저장되어있으므로
		//요청객체.getxxx()메서드를 사용하여 필요한 정보를 읽어서 사용할 수 있다.
	
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
		out.println("<h1>요청주소:"+req.getRequestURI()+"</h1>");
		out.println("<h1>요청주소:"+req.getRequestURL()+"</h1>");
		out.println("<h1>요청방식:"+req.getMethod()+"</h1>");
		out.println("<h1>프로토콜:"+req.getProtocol()+"</h1>");
		out.println("<h1>User-Agent헤더 :"+req.getHeader("User-Agent")+"</h1>");
		
		String agent = req.getHeader("User-Agent");
		
		if(agent.contains("Edg/")||agent.contains("Edge/"))
		{
			out.println("<h1> Ms Edge 사용자</h1>");
		}
		else if(agent.contains("OPR/")) {
			out.println("<h1> OPR 사용자</h1>");
		}
		else if(agent.contains("Chorme/")) {
			out.println("<h1> Google Chrome 사용자</h1>");
		}	
		else if(agent.contains("Firefox/")) {
			out.println("<h1> Firefox 사용자</h1>");
		}
		else
		{
			out.println("<h1>알 수 없음</h1>");
			
		}
	    out.println("</body>");
	    out.println("</html>");
}
}
