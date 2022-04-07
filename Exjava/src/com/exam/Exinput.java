package com.exam;

import java.util.Scanner;
     //1폴더 2폴더 안에있는 스캐너 (9번줄 자동완성 이 후 자동으로 삽입됨)
public class Exinput {

	public static void main(String[] args) {
		//현재 시스템(컴퓨터)의 입력(키보드)로부터
		//입력을 받을 수 있는 스캐너 생성 (스캐너 = 키보드 타이핑)
		Scanner  sc = new Scanner(System.in);
		//스캐너로부터 한줄의 문자열을 입력받아서 변수 s에 저장
		String s = sc.nextLine();
		//실행 후 콘솔창에 타이핑한 문장이 sc.nextline이라는 뜻
		System.out.println( s );

	}

}
