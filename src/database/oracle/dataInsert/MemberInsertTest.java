package database.oracle.dataInsert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MemberInsertTest {

	public static void main(String[] args) {

		Connection conn = null;

		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "newuser", "1234");
			String sql ="" 
						+ "INSERT INTO member ( ID,PW,NAME,AGE,GENDER,PHONE)"
						+ "values (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			System.out.printf("아이디를 입력하시오: ");
			pstmt.setString(1, sc.nextLine());
			System.out.printf("비밀번호를 입력하시오: ");
			pstmt.setString(2, sc.nextLine());
			System.out.printf("이름을 입력하시오: ");
			pstmt.setString(3, sc.nextLine());
			System.out.printf("나이를 입력하시오: ");
			pstmt.setInt(4, Integer.parseInt(sc.nextLine()));
			System.out.printf("성별을 입력하시오: ");
			pstmt.setString(5,  sc.nextLine());
			System.out.printf("전화번호를 입력하시오: ");
			pstmt.setString(6,  sc.nextLine());
			
						
			int rows = pstmt.executeUpdate();
			
			if(0 == rows) {
				System.out.println("실패");
			} else {
				System.out.println("회원 정보 입력 성공 : " + rows);
			}
			
			pstmt.close();

		} catch (ClassNotFoundException e) {
			System.out.println("oracle.jdbc.OracleDriver 찾을 수 없음");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != conn) {
				try {
					// 연결 끊기
					conn.close();
					sc.close();
				} catch (SQLException e) {
				}

			}
		} 
	}
}
