package my_library2.sub;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import my_library2.DB_Connect;

public class insertRandomData_admin {
	// 테이블 데이터 삭제 후 AI 1로 변경, ALTER TABLE your_table_name AUTO_INCREMENT = 1;

	public void generateAndInsertAdmin() {
	
		// DB 연결
		DB_Connect.connectDB();

		// DB 삽입
		String member = "INSERT INTO admin (id, pw) VALUES (?, ?)";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = DB_Connect.getConnection().prepareStatement(member);

			preparedStatement.setString(1, "admin");
			preparedStatement.setString(2, "1234");

			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Connect.disconnectDB();
		}
	}

	public static void main(String[] args) {
		insertRandomData_admin gen = new insertRandomData_admin();
		gen.generateAndInsertAdmin();
	}
}
