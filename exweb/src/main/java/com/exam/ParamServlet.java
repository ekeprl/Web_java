package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//server에서 우클릭 후 clean + project에서 클린 (서버문제가있을때)

//웹브라우저에서 요청을 보낼 때, 추가적인 정보를 전송 가능
//요청주소?파라미터이름=파라미터값
//http://localhost:8000/exweb/param.do?a=123 ->요청 주소 + ? + 변수  브라우저가 보낸 모든 정보는 요청객체안에 들어있다.
//서블릿에서는 요청객체.getParameter("파라미터이름") 명령으로
//파라미터값을 읽어서 사용할 수 있다
//다수의 파라미터는 &를 사용하여 작성한다. ex파라미터이름=파라미터값&파라미터이름=파라미터값&파라미터이름=파라미터값

@WebServlet("/param.do") //주소
public class ParamServlet extends HttpServlet {   //클래스 이름
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //serv + ctrl + space : service자동완성)
		String aval = req.getParameter("a"); //a라는 값에 저장되어있는 것을 갖고오라는 명령 + 사용하기위해 저장해야함 (모두 문자 string형태)
		String[] bvals = req.getParameterValues("b");		//post방식으로 전송되는 한글 파라미터 인코딩
		//파라미터값이 여러개일때 req.getparametervalue's'
		// req.getparametername's' : 어떤 값이 왔을 때 이름을 알려준다. --> 무슨 파라미터가 와도 처리를 할 수 있다.
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
		out.println("<h1> 파라미터 테스트</h1>");
		out.println("<h2>" + aval + "</h2>");  //위의 새롭게 저장된 aval값을 넣는 작업
		
		/* bvals 배열에 들어있는 모든 값들을 하나씩 꺼내서 출력 */
		// bvals의 파라미터를 하나도 입력하지 않는다면 null값으로 출력된다(오류)
		if(bvals != null) {   //파라미터값이 1개 이상 존재하는 경우에만 실행하기위한 조건문, 
		for (int i =0 ; i < bvals.length ; i++) {  
			out.println("<h2>" + bvals[i] + "</h2>");
		}
		}
		/*out.println("<h2>" + bvals[0] + "</h2>");
		out.println("<h2>" + bvals[1] + "</h2>");*/
		
		out.println("</body>");
		out.println("</html>");
		//자바를 이용해 브라우저에 사용자가 입력한 값을 가지고 출력할 수 있도록 html을 이용함
	}

	
		
}

//http://localhost:8000/exweb/param.do?user=abc          
//로 요청을 보내면, 브라우저 화면에 큰 제목으로
//abc 님 환영합니다
//라고 출력 되도록 구현
//


