package com.exam;

import java.util.ArrayList;
import java.util.Scanner;

public class ExMemList {
   public static void main(String[] args) {
	 //ArrayList:다수의 값을 저장할 수 있는 배열과 유사한 목록
	 //프로그램 종료하고 다시 실행하면 없어진다.
	 ArrayList<MemberVo> list = new ArrayList<MemberVo>(); //문자열 여러개를 저장할 수 있는 목록 생성
	 //한 배열안에 id,pw,point,name전부다 집어넣을 수 있을 수 없다.
	 //새로운 class를 생성하여 문자열3개 + 정수열1개를 합쳐놓고 사용한다.
	 Scanner sc = new Scanner(System.in);
	 
	 
	 boolean flag = true;  //초기값을 true로 둬야 계속 반복하는 while문이 된다.
	while (flag ) {
		System.out.println("1.목록 2.추가 3.삭제 4.종료");
		String menu = sc.nextLine();
		switch (menu) {
		case "1":{  //변수의 범위 제한(변수의 이름이 같아도 충돌이되지 않도록 하기위해
			for(int i=0; i<list.size(); i++) {
			MemberVo vo = list.get(i);
			System.out.println( vo.getMemId() + ":" + vo.getMemPass() + ":" + vo.getMemName() + ":" + vo.getMemPoint()); 
			}                  //vo안에 하나의 문자열만 있는것이 아니기 때문에 전체를 출력할 수 있도록 작성.
			
//			for(String n : list) {
//				System.out.println(n);
//			} 이거 아니면 위에있는것 둘중 아무거나 사용
			break;
		}
		case "2": { 
			MemberVo vo = new MemberVo();
			System.out.println(" 회원아이디: ");
			//만들어놓은 MemberVo 객체의 memId변수에 저장을 하려고한다.  -->새로운 변수를 선언하고 저장한다.
			vo.setMemId(sc.nextLine());  
			//적어넣을 값을 괄호안에
			System.out.println(" 회원비밀번호: ");
			vo.setMemPass(sc.nextLine());
			System.out.println(" 회원이름: ");
			vo.setMemName(sc.nextLine());  
			System.out.println(" 회원포인트: ");
			vo.setMemPoint(Integer.parseInt(sc.nextLine()));  
			
			list.add( vo );
			break; }
		case "3": {
			System.out.println("삭제할 회원아이디: ");
			String memId = sc.nextLine();
			for ( int i =0 ; i < list.size(); i++) {
				MemberVo vo = list.get(i);
				//vo의 변수에 입력 후
				if (memId.equals(vo.getMemId())) {
					//vo에 있는 아이디와 비교 후,
					list.remove(i);
					//같다면 제거
					break;
					
				}
			}
			break; }
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
