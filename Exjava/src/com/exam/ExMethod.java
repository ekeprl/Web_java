package com.exam;

import javax.print.attribute.standard.PrinterMessageFromOperator;

public class ExMethod {

	public static void main(String[] args) {
		String s1 = "포로리";
		String s2 = "너부리";
		
		printWelcome(s1);
		printWelcome(s2);
				
		int a = add(15,5);
		System.out.println(a);
		//
		printAdd(3,4);
		printAdd(5,8);
		// 3 + 4 = 7
		// 이라고 출력되도록 함수 printAdd를 정의
//		********************
//		*  포로리 님 환영합니다  *
//      ********************
//      ********************
//		*  너부리 님 환영합니다  *
//      ********************
	}
	public static void printAdd(int a1, int a2){
        System.out.println(a1 + "+" + a2 + "=" + (a1+a2));
		
		
	}
	// 두 정수를 더해주는 함수

	public static int add(int x, int y) {
		int sum = x + y;
		return sum; // sum 변수의 값을 함수의 결과로 반환
		
	}
	
//	함수정의 : 반환값 함수이름(받을 값) { 함수내용}
	public static void printWelcome(String s) {
		System.out.println("********************");
		System.out.println("*  " + s + "님 환영합니다   *");
		System.out.println("********************");
		
	}
	

}
//src/main/java : 자바 소스코드 작성   webapp : html,css,js등 실행되는 프로젝트, 어플리케이션
//exweb에서 실행한다면 ->tomcat실행
//ctrl + f11로 실행을 한다면 서버(tomcat)설정 후 자동으로 이클립스가 실행.
