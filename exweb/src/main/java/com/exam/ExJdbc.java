package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExJdbc {

	public static void main(String[] args) {
	//오라클 jdbc 드라이버클래스를 메모리에 로드
	//데이터베이스 연결 전에 최초 1회만 실행

		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		//데이터베이스 서버 주소
		//구글에 oracle jdbc connection검색
		String user="web"; //데이터베이스 사용자 아이디
		String password="web01"; //데이터베이스 사용자 비밀번호
		
		try {
			Connection conn= DriverManager.getConnection(url,user,password);
			String sql="SELECT mem_id,mem_pass,mem_name,mem_point FROM MEMBER";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			//sql문 불러올 떄 뒤에 세미콜론은 삭제
			//명령문객체에 담겨있는 sql문을 실행
			//실행 후 결과 데이터를 받는 sqp(select)문은 executeQuery()사용
			//실행 후 결과 데이터가 없는 sql(insert, update, delete)문은 executeUpdate 사용
			ResultSet rs=pstmt.executeQuery();
			//select실행 결과 데이터가 저장되어있는 ResultSet은 
			//처음엔 첫 행 이전을 가리키고있고,
			//다은 레코드를 가리키도록 한 다름 해당 레코드의 컬럼값을 조회
			rs.next();//다음 레코드를 가리키도록
			//컬럼 값의 타입에 따라서 rs.getxxx(컬럼명)을 사용하여 
			//현재 ResultSet이 가리키는 레코드의 컬럼값을 읽기.
			String memId=rs.getString("mem_id");
			//현재 가리키는 레코드의 mem_id컬럼값 읽기
			String memPass = rs.getString("mem_pass");
			String memName = rs.getString("mem_name");
			int memPoint = rs.getInt("mem_point");
			
			
			
			System.out.println(memId+","+memPass+","+memName+","+memPoint);
		} catch(SQLException e) {
			e.printStackTrace();
		
		}
			//데이터베이스접속(연결)
			//마찬가지로 빨간줄에 ctrl+1해서 지역변수를 만들어준다.	
		
		
		
		
	}

}
