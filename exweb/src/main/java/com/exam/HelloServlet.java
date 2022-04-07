package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹애플리케이션서버(톰캣)을 통해 실행되는 자바 클래스
//를 작성하기 위해서는 일반적으로 HttpServlet 클래스를 상속(클래스 가져와 사용하는 것) HttpServlet의 코드가 보이진 않지만 작성되어져있다.

//서블릿 클래스와 요청 주소를 연결하는 방법 
//(1)web.xml(웹 애플리케이션 전체설정) 파일에 등록
//(2)@WebServlet를 클래스에 사용
public class HelloServlet extends HttpServlet {
	
	//현재 서블릿클래스에 맞는 요청이 올때마다 한번씩 실행, 이클립스 실행 = 서비스가 실행된다는 뜻
	//실행시키면서 요청객체와 응답객체를 인자로 전달
	//요청객체 : 클라이언트(웹브라우저)가 보낸 모든 정보룰 담고있다.
	//응답객체 : 클라이언트에게 (응답으로) 보낼 정보들을 저장할 수 있다.
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
				System.out.println("HelloServlet 실행!"); //현재 컴퓨터에 출력하는 것
				
				//출력스트림 가져오기 전에 응답객체의 문자인코딩을 미리 설정
				resp.setCharacterEncoding("UTF-8");
				//응답내용이 HTML 문서 텍스트임을 클라이언트에게 알려준다
				resp.setContentType("text/html");
				//응답객체에 응답내용을 쓸 수 있는 출력스트림을 가져오기
				PrintWriter out = resp.getWriter();
				//응답객체에 출력한 내용이 클라이언트(웹브라우저)에게 전송된다.
	//			out.println(" Hello Servlet!"); //응답객체에 출력하는것
				
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<meta charset='UTF-8'>");
				out.println("<title>Insert title here</title>");
				out.println("</head>");
				out.println("<body>");
				out.println(" <h1>Hello Servlet!</h1>"); 
				out.println(" <h2>안녕하세요</h2>"); 
				out.println("</body>");
				out.println("</html>");
				
				//웹브라우저에서(크롬)
				// http://localhost:8000/exweb/bye.do
				//로 요청을 보내면,
				//브라우저 화면에
				// Bye Bye
			    // 라고 출력되도록 구현
	}

	
	
}
