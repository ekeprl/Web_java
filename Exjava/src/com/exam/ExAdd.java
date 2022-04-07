package com.exam;

import java.util.Scanner;

public class ExAdd {

	public static void main(String[] args) {
		
		System.out.println(" x 값을 입력하세요 ");
		// " x 값을 입력하세요"라고 출력
		
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		// 키보드로 숫자를 입력받기
		
		int ab = Integer.parseInt(a);				
		// 문자열을 정수로 변환
						
		System.out.println(" y 값을 입력하세요");
		// " y 값을 입력하세요"라고 출력
				
		String b = sc.nextLine();
		// " 키보드로 숫자를 입력받아 변수 y에 저장
		
		int ad = Integer.parseInt(b);
		// 문자열을 정수로 변환
		
		System.out.println( a + "+" + b + "=" + (ab + ad));
		// " x + y = oo" 라고 입력받은 두 수의 합을 출력
		// x와 y의 위치에는 입력한 숫자를 출력
		//webapp = 최상위 폴더
		//http://localhost:8000/exweb/add.do?x=123&y=456
		//로 요청을 보내면,
		// 123+456=579
		//라고 출력이 되도록 서블릿을 구현
		
}
}
