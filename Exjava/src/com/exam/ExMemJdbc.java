package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExMemJdbc {

   public static void main(String[] args) {
	  MemberDao memberDao = new MemberDao();
	//안에있던 변수들을 모두 class밖으로(MemberDao)로 옮겨버렸기 때문에
	  //오류가 발생한다.
	  //오류제거를위해 새롭게 memberdao를 선언하고
	  //아래 selectlist변수를 memberdao.selectlist로 바꿔 오류를 제거한다.
		
	Scanner sc = new Scanner(System.in);
		 
	 boolean flag = true;  
	while (flag ) {
		System.out.println("1.목록 2.추가 3.삭제 4.종료");
		String menu = sc.nextLine();
		switch (menu) {
		case "1":{  
			//데이터베이스 member 테이블의 정보를 select하여 출력
			ArrayList<MemberVo> list = memberDao.selectList(); 
			//selectlist를 호출하는형태.
			for(int i=0; i<list.size(); i++) {
				MemberVo vo = list.get(i);
				System.out.println( vo.getMemId() + ":" + vo.getMemPass() + ":" + vo.getMemName() + ":" + vo.getMemPoint()); 
			} 
			break;
		}
		case "2": {
			MemberVo vo = new MemberVo();
			System.out.println(" 회원아이디: ");
			vo.setMemId(sc.nextLine());  
			System.out.println(" 회원비밀번호: ");
			vo.setMemPass(sc.nextLine());
			System.out.println(" 회원이름: ");
			vo.setMemName(sc.nextLine());  
			System.out.println(" 회원포인트: ");
			vo.setMemPoint(Integer.parseInt(sc.nextLine()));
			
			int num =  memberDao.insert(vo);
			//num을 정의해줘야 오류가 발생하지 않는다.
			//인서트 메소드를 호출하는 형식으로 변함.
			System.out.println( num + "개의 레코드 추가");	
			break; }
		
		case "3": {
			
			System.out.println("삭제할 회원아이디: ");
			String memId = sc.nextLine();
			int num = memberDao.delete(memId); 
			//밑에 delete메서드가 생성되었고 호출하는 형식으로 짧게 쓰여진다.
			System.out.println( num + "개의 레코드 삭제");		
			break; 
		}
		case "4":
			//종료 -> 반복문을 종료시키는 번호
			flag = false;
			break;

		default:
			System.out.println("알 수 없는 메뉴");
			break;
		}
	}
	 
	 sc.close();
	}
   
   
	
}
