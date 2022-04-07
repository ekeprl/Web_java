package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ExJdbc2 {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		String url = "jdbc:oracle:thin@localhost:1521:xe";
		
		String user = "web";
		String password = "web01";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디:");
		String id = sc.nextLine();
		System.out.println("비밀번호:");
		String pass = sc.nextLine();
		System.out.println("이름:");
		String name = sc.nextLine();
		System.out.println("포인트:");
		int point = Integer.parseInt(sc.nextLine());
		
		String insertSql = "INSERT into MEMBER" + "(mem_id,mem_pass,mem_name,mem_point)" + "VALUES(?,?,?,?)";
		
		try (
		
			Connection conn= DriverManager.getConnection(url,user,password);
			PreparedStatement pstmt = conn.prepareStatement(insertSql);
			)
		{
			
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			pstmt.setString(3, name);
			pstmt.setInt(4, point);
			int num = pstmt.executeUpdate();
			System.out.println(num + "개의 레코드 추가");
			
		} catch (SQLException e) {
			e.printStackTrace();
	}
		
		String selectSql = "SELECT mem_id, mem_pass,mem_name, mem_point FROM MEMBER";
		try (Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = conn.prepareStatement(selectSql);
				ResultSet rs = pstmt.executeQuery();){
			
			rs.next();
			
			String memId= rs.getString("mem_id");
			String memPass= rs.getString("mem_pass");
			String memName= rs.getString("mem_name");
			String memPoint= rs.getString("mem_point");
			
			System.out.println(memId+ "," + memPass + ","+ memName + "," + memPoint);
			
			while (rs.next()) {
				memId= rs.getString("mem_id");
				memPass= rs.getString("mem_pass");
				memName= rs.getString("mem_name");
				memPoint= rs.getString("mem_point");
				System.out.println(memId+","+memPass+","+memName + "," + memPoint);
			}
				
				
			} catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
	


