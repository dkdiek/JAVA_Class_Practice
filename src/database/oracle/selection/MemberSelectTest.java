package database.oracle.selection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MemberSelectTest {

	public static void main(String[] args) {
		
		Connection conn = null;

		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "newuser", "1234");
			String sql ="SELECT SEQ"
					+ "        ,ID"
					+ "        ,PW"
					+ "        ,NAME"
					+ "        ,AGE"
					+ "        ,GENDER"
					+ "        ,PHONE"
					+ "        ,CREATE_DATE"
					+ " FROM MEMBER";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while ( rs.next() ) {
				System.out.print(rs.getString("SEQ") + " | ");
				System.out.print(rs.getString("ID") + " | ");
				System.out.print(rs.getString("PW") + " | ");
				System.out.print(rs.getString("NAME") + " | ");
				System.out.print(rs.getString("AGE") + " | ");
				System.out.print(rs.getString("GENDER") + " | ");
				System.out.print(rs.getString("PHONE") + " | ");
				System.out.print(rs.getString("CREATE_DATE"));
				System.out.println();
			}
			rs.close();

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
