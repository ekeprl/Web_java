package com.exam;

//Java는 클래스 단위로 프로그램을 작성하고 실행
public class ExOutput {
   //클래스를 실행하면, 클래스의 main 메서드를 실행하는 것
	//클래스 안에 작성하는 것 :변수(int등), 함수(명령의 집합체), 메서드 : 클래스 안에있는 함수)
	//1.클래스 정의 2.메서드 정의 3.실행
   public static void main(String[] args) {
		System.out.println("Hello JAVA");  //쓴 그래도 출력
		System.out.println(123123456);
		int a = 7; 
		//문자열 + 수식(값) => 두 값을 이어 붙인 문자열
		System.out.println(a+" * 2 = "+ (a*2) );
		System.out.println(a+" * 3 = "+ (a*3) );
		System.out.println(a+" * 4 = "+ (a*4) );
		
	}
}
