package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {

	//변수선언부터 메서드까지 전부 db관련 별도의 클래스로 작성을 한것이다.
	
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		String user = "web"; 
		String password = "web01";
		//main매서드 안에있던 접속메서드를 클래스안에서는 전부 사용할 수 있게끔 밖으로 빼줬다.
		//static이 없다면 new를 사용해야만 오류가 없어진다.
	    //변수선언
	   
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//생성자부분 or 초기화블럭 ({})에 넣어주면 시작할 때 한번만 실행이 되도록한다.
		}
	   //selectlist메소드 생성(우클릭 ->refactor ->extract method이용)
	public ArrayList<MemberVo> selectList() {
			ArrayList<MemberVo> list = new ArrayList<MemberVo>();
			//회원목록을 저장할 수 있는 목록 생성
			String selectSql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM member";
			try (
					Connection conn = DriverManager.getConnection(url, user, password); //데이터베이스 접속 연결
					PreparedStatement pstmt = conn.prepareStatement(selectSql);
					ResultSet rs = pstmt.executeQuery();
					//실행 후에
			) {
				while (rs.next()) {
					//반응
					MemberVo vo = new MemberVo();
					vo.setMemId(rs.getString("mem_id")); 
					vo.setMemPass(rs.getString("mem_pass"));
					vo.setMemName(rs.getString("mem_name"));
					vo.setMemPoint(rs.getInt("mem_point")); 
					list.add(vo);
				}//한번 돌릴때마다 MemberVO에 한 회원씩 저장
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
	   //insert선언문을 refactor작업 수행하게되면 독립된 메서드가 생성된다.
	public int insert(MemberVo vo) {
			        //정수 int num=0이라고 선언을 했기때문에 static void가 아닌 int형태로 바꿔줘야한다.
			int num = 0;
			//데이터베이스 member 테이블에 회원정보를 db에 insert하도록 insert sql문 작성.
			String insertSql = "INSERT INTO member"
					+ "(mem_id, mem_pass, mem_name, mem_point)"
					+ "VALUES(?, ?, ?, ?)";
			
			try (
					Connection conn = DriverManager.getConnection(url, user, password); //데이터베이스 접속 연결
					//해당 데이터베이스 연결을 통해서 실행할 SQL문 준비
					
					PreparedStatement pstmt = conn.prepareStatement(insertSql);
			) {
				pstmt.setString(1, vo.getMemId()); //pstmt에 담긴 SQL문의 첫번째 ?에 id 값을 주입
				pstmt.setString(2, vo.getMemPass()); //pstmt에 담긴 SQL문의 첫번째 ?에 pass 값을 주입
				pstmt.setString(3, vo.getMemName()); //pstmt에 담긴 SQL문의 첫번째 ?에 name 값을 주입
				pstmt.setInt(4, vo.getMemPoint()); //pstmt에 담긴 SQL문의 첫번째 ?에 point 값을 주입
				//values의 ?값에 작성한 값을 넣는다.
				 //SLQ문 실행결과 변경된 레코드 수를 반환
				//반환해주는 어떠한 명령도없어서 오류가난다.		
				num = pstmt.executeUpdate();
				//오류가 발생 (정의되지않은 num) ->변수분리를 이행 ctrl+1 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return num;
			//반환하는 명령어  +  접근을 위한 범위설정이 필요
			
		}
	public int delete(String memId) {
			int num = 0;
			String delSql = "DELETE FROM member WHERE  mem_id = ?";
			//	  											  ->?자리에 키보드로 입력받은 memId가 들어가야한다.
			try (
					Connection conn = DriverManager.getConnection(url, user, password); //데이터베이스 접속 연결
					PreparedStatement pstmt = conn.prepareStatement(delSql);
			) {
				
				// ?에 주이할 값의 타입에 따라서 setXXX() 메서드 사용
				pstmt.setString(1, memId); //pstmt에 담긴 SQL문의 첫번째 ?에 id 값을 주입
//					pstmt.setString(2, vo.getMemPass()); //pstmt에 담긴 SQL문의 첫번째 ?에 pass 값을 주입
//					pstmt.setString(3, vo.getMemName()); //pstmt에 담긴 SQL문의 첫번째 ?에 name 값을 주입
//					pstmt.setInt(4, vo.getMemPoint()); //pstmt에 담긴 SQL문의 첫번째 ?에 point 값을 주입			
				num = pstmt.executeUpdate(); //SLQ문 실행결과 변경된 레코드 수를 반환, 실행쿼리문을 업데이트
					
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return num;
		}
	
	
}
//DAO = DATA ACCESS OBJECT 자바오브젝트와 데이터베이스 연결
//VO = VALUE OBJECT 두객체안에있는 속성의값들이 모두동일하다면 같은객체라고 취급한다는뜻.
//일반적으로 테이블하나에 담을 수 있는 객체를 일컫는다.