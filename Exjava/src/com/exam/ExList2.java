package com.exam;

import java.util.ArrayList;
import java.util.Scanner;

public class ExList2 {
   public static void main(String[] args) {
	 //ArrayList:다수의 값을 저장할 수 있는 배열과 유사한 목록
	 //꺽쇠안에 타입을 지정
     //배열: 칸수를 지정해놓는다.(낭비가 될 수 있음) <-->개수를 정해줄 필요없이 넣는대로 들어간다.
	 ArrayList<String> list = new ArrayList<String>(); //문자열 여러개를 저장할 수 있는 목록 생성
	 Scanner sc = new Scanner(System.in);
	 
	 
	 boolean flag = true;  //초기값을 true로 둬야 계속 반복하는 while문이 된다.
	while (flag ) {
		System.out.println("1.목록 2.추가 3.삭제 4.종료");
		String menu = sc.nextLine();
		switch (menu) {
		case "1":
			for(int i=0; i<list.size(); i++) {
			//list에 저장되어있는 회원이름들을 모두 출력
			System.out.println(list.get(i)); }
			
//			for(String n : list) {
//				System.out.println(n);
//			} 이거 아니면 위에있는것 둘중 아무거나 사용
			
			
			break;
		case "2": { //중괄호 이유 : case2, 3의 범위가 겹쳐 변수name을 연달아 사용할 수 없기때문에 범위를 제한하여 사용할 수 있게끔만들어준것.
			//변수의 이름을 다르게하는 것도 방법이다.
			//추가할 회원이름을 입력받아서 list에 저장
			System.out.println("추가할 회원이름: ");
			String name = sc.nextLine();
			list.add(name); //새롭게입력 : sc.nextline()
			break; }
		case "3": {
			//삭제할 회원이름을 입력받아서 list에서 삭제  
			System.out.println("삭제할 회원이름: ");
			String name = sc.nextLine();
			//삭제할 이름을 입력 받고
			for ( int i =0 ; i < list.size(); i++) {
				if (name.equals(list.get(i))) {
					//입력받은 이름이 존재하는지 확인하고
					list.remove(i);
					//삭제
					break;
					//비교작업을 그만두고 나감.
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
	 
	 
	}
}
