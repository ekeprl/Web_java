package com.exam;

import java.util.ArrayList;

public class Exlist {
   public static void main(String[] args) {
	 //ArrayList:다수의 값을 저장할 수 있는 배열과 유사한 목록
	 //꺽쇠안에 타입을 지정
     //배열: 칸수를 지정해놓는다.(낭비가 될 수 있음) <-->개수를 정해줄 필요없이 넣는대로 들어간다.
	 ArrayList<String> list = new ArrayList<String>(); //문자열 여러개를 저장할 수 있는 목록 생성
	 
	 //위에서만든 어레이리스트(한글).add("고길동"); 라고 바로쓸 수 없으니 이름을 지정해줘서
	 //list.add("고길동")처럼 (.add)를 이용하여 목록의 마지막에 고길동을 저장(추가)할 수 있다.
	 list.add("고길동");  //첫번째 배열 위치
	 list.add("둘리");   //두번째 배열 위치
	 list.add("마이콜"); // 세번째 배열 위치
	 
	 System.out.println(list.size() ); //현재 list에 저장된 데이터의 수를 size를 이용해 확인할 수 있다.
	 
	 System.out.println( list.get(0) ); //list의 0번칸에 저장된 데이터 읽기
	 System.out.println( list.get(1) );
	 System.out.println( list.get(2) );
	 
	 list.remove(1);    // remove (int dex) : 몇번째 칸의 데이터를 지운다는 의미
	 System.out.println(list.size()); 
	 System.out.println( list.get(0) );
	 System.out.println( list.get(1) );
	 
}
}
