package com.exam;

import java.util.Scanner;
import java.util.concurrent.Delayed;

public class ExInOut {

	public static void main(String[] args) {
		
		// 1. "좋아하는 음식을 입력하세요" 라고 출력
		System.out.println("좋아하는 음식을 입력하세요");
		
	    Scanner sc = new Scanner(System.in);
	    // 입력한 음식을 변수에 저장
	    String s = sc.nextLine();
	    // "좋아하는 음식은 ooo입니다."하고 출력
	    System.out.println( "좋아하는 음식은 " + s + " 입니다." );
	    
	   	    
	    // 2. "누구세요?" 라고 출력
	    System.out.println("누구세요?");
	    // 키보드로 이름 입력
	   	   
	    String b = sc.nextLine();
	    // "ooo님 환영합니다." 라고 출력
	    // 굳이 스캐너를 추가하지 않아도 괜찮음, 변수 s를 다시 사용할 경우 덮어쓰기가 되버림.
	    System.out.println(b + "님 환영합니다.");
	    
	}

}
