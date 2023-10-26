package my_library2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
	Scanner scanner = new Scanner(System.in);

	// 로그인
	public int login() {
		String membershipID;
		String membershipPW;
		int member_id = -1;

		DB_Connect.connectDB();

		System.out.println();
		System.out.printf("> ID를 입력하시오 : ");
		membershipID = scanner.nextLine();
		System.out.printf("> PW를 입력하시오 : ");
		membershipPW = scanner.nextLine();

		try {
			// SQL 쿼리: 회원 정보 확인
			String query = "SELECT * FROM member WHERE id = ? AND pw = ?";
			PreparedStatement preparedStatement = DB_Connect.getConnection().prepareStatement(query);
			preparedStatement.setString(1, membershipID);
			preparedStatement.setString(2, membershipPW);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				System.out.println();
				System.out.println("로그인 되었습니다.");

				member_id = resultSet.getInt("member_id");

			} else {
				System.out.println();
				System.out.println("회원 인증 실패. 메인 메뉴로 돌아갑니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Connect.disconnectDB();
		}

		// 로그인 성공시 member_id return / 실패시 null
		return member_id;
	}

	// 로그인 메뉴
	public void loginMenu() {

		int member_id = login();
		int menu;

		while (-1 != member_id) {

			System.out.println();
			System.out.println("*** 일산 도서관 로그인 메뉴 ***");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 조회 & 대출");
			System.out.println("3. 대출 조회 & 반납");
			System.out.println("4. 로그아웃");
			System.out.printf("> 메뉴를 입력하시오 : ");
			menu = scanner.nextInt();
			scanner.nextLine();

			if (menu == 1) {
				mypage(member_id);
			} else if (menu == 2) {
				new Menu().searchBook(member_id);
			} else if (menu == 3) {
				rentalManage(member_id);
			} else if (menu == 4) {
				System.out.println();
				System.out.println("로그아웃 되었습니다.");
				break;
			} else {
				System.out.println();
				System.out.println("잘못된 메뉴 번호입니다.");
			}

		}

	}

	// 로그인 메뉴(member_id)
	public void loginMenu(int member_id) {

		int menu;

		while (-1 != member_id) {

			System.out.println();
			System.out.println("*** 일산 도서관 로그인 메뉴 ***");
			System.out.println("1. 마이 페이지");
			System.out.println("2. 도서 조회 & 대출");
			System.out.println("3. 대출 조회 & 반납");
			System.out.println("4. 로그아웃");
			System.out.printf("> 메뉴를 입력하시오 : ");
			menu = scanner.nextInt();
			scanner.nextLine();

			if (menu == 1) {
				mypage(member_id);
			} else if (menu == 2) {
				new Menu().searchBook(member_id);
			} else if (menu == 3) {
				rentalManage(member_id);
			} else if (menu == 4) {
				System.out.println();
				System.out.println("로그아웃 되었습니다.");
				break;
			} else {
				System.out.println();
				System.out.println("잘못된 메뉴 번호입니다.");
			}

		}

	}

	// 마이 페이지
	public void mypage(int member_id) {

		int menu;
		boolean returnFlag = false;
		String userPW;
		String newPw;
		String newPw2;
		String newPhone;
		String newPhone2;

		while (!returnFlag) {
			System.out.println();
			System.out.println("*** 일산 도서관 마이 페이지 메뉴 ***");
			System.out.println("1. 비밀번호 변경");
			System.out.println("2. 연락처 변경");
			System.out.println("3. 회원 탈퇴");
			System.out.println("0. 이전 페이지");
			System.out.printf("> 메뉴를 입력하시오 : ");
			menu = scanner.nextInt();
			scanner.nextLine();

			if (menu == 0) {
				break;
			} else if (menu == 1) {
				// 비밀번호 변경
				System.out.println();
				System.out.print("> 현재 비밀번호를 다시 입력하세요 : ");
				userPW = scanner.nextLine();

				// DB 연결
				DB_Connect.connectDB();

				// SQL 쿼리: 회원 정보 확인
				String getPW = "SELECT pw FROM member WHERE member_id = ?";

				try {
					PreparedStatement preparedStatement = DB_Connect.getConnection().prepareStatement(getPW);
					preparedStatement.setInt(1, member_id);
					ResultSet resultSet = preparedStatement.executeQuery();

					if (resultSet.next()) {
						if (resultSet.getString("pw").equals(userPW)) {

							System.out.print("> 변경 비밀번호 입력하세요 : ");
							newPw = scanner.nextLine();
							System.out.print("> 변경 비밀번호 재입력하세요 : ");
							newPw2 = scanner.nextLine();

							if (newPw.equals(newPw2)) {
								String pwChangeQuery = "UPDATE member set pw = ? where member_id = ?";

								PreparedStatement changePwStatement = DB_Connect.getConnection()
										.prepareStatement(pwChangeQuery);
								changePwStatement.setString(1, newPw);
								changePwStatement.setInt(2, member_id);

								int rowsAffected = changePwStatement.executeUpdate();

								if (rowsAffected > 0) {
									System.out.println();
									System.out.println("비밀번호가 변경되었습니다.");
								} else {
									System.out.println();
									System.out.println("오류가 발생했습니다. 다시 시도해주세요.");
								}
							} else {
								System.out.println();
								System.out.println("비밀번호가 일치하지 않습니다. 다시 시도해주세요.");
							}

						}

					} else {
						System.out.println("잘못 입력하셨습니다. 다시 시도해주세요.");
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					DB_Connect.disconnectDB();
				}

			} else if (menu == 2) {
				// 연락처 변경
				System.out.println();
				System.out.print("> 현재 비밀번호를 다시 입력하세요 : ");
				userPW = scanner.nextLine();

				// DB 연결
				DB_Connect.connectDB();

				// SQL 쿼리: 회원 정보 확인
				String getPW = "SELECT pw FROM member WHERE member_id = ?";

				try {
					PreparedStatement preparedStatement = DB_Connect.getConnection().prepareStatement(getPW);
					preparedStatement.setInt(1, member_id);
					ResultSet resultSet = preparedStatement.executeQuery();

					if (resultSet.next()) {
						if (resultSet.getString("pw").equals(userPW)) {

							System.out.print("> 변경 연락처를 입력하세요 : ");
							newPhone = scanner.nextLine();
							System.out.print("> 변경 연락처를 재입력하세요 : ");
							newPhone2 = scanner.nextLine();

							if (newPhone.equals(newPhone2)) {
								String phoneChangeQuery = "UPDATE member set phone = ? where member_id = ?";

								PreparedStatement changePwStatement = DB_Connect.getConnection()
										.prepareStatement(phoneChangeQuery);
								changePwStatement.setString(1, newPhone);
								changePwStatement.setInt(2, member_id);

								int rowsAffected = changePwStatement.executeUpdate();

								if (rowsAffected > 0) {
									System.out.println();
									System.out.println("연락처가 변경되었습니다.");
								} else {
									System.out.println();
									System.out.println("오류가 발생했습니다. 다시 시도해주세요.");
								}
							} else {
								System.out.println();
								System.out.println("연락처가 일치하지 않습니다. 다시 시도해주세요.");
							}

						}

					} else {
						System.out.println();
						System.out.println("잘못 입력하셨습니다. 다시 시도해주세요.");
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					DB_Connect.disconnectDB();
				}

			} else if (menu == 3) {
				// 회원 탈퇴
				System.out.println();
				System.out.println("정말 탈퇴하시겠습니까?");
				System.out.println("1. 탈퇴 진행");
				System.out.println("0. 이전 페이지");
				System.out.printf("> 메뉴를 입력하시오 : ");
				int leave = scanner.nextInt();
				scanner.nextLine();

				if (leave == 1) {
					System.out.println();
					System.out.printf("> 현재 비밀번호를 다시 입력하세요 : ");
					userPW = scanner.nextLine();

					// DB 연결
					DB_Connect.connectDB();

					// SQL 쿼리: 회원 정보 확인
					String getPW = "SELECT pw FROM member WHERE member_id = ?";

					try {
						PreparedStatement preparedStatement = DB_Connect.getConnection().prepareStatement(getPW);
						preparedStatement.setInt(1, member_id);
						ResultSet resultSet = preparedStatement.executeQuery();

						if (resultSet.next()) {
							if (resultSet.getString("pw").equals(userPW)) {

								String memberRemoveQuery = "DELETE FROM member where member_id = ?";

								PreparedStatement changePwStatement = DB_Connect.getConnection()
										.prepareStatement(memberRemoveQuery);
								changePwStatement.setInt(1, member_id);

								int rowsAffected = changePwStatement.executeUpdate();

								if (rowsAffected > 0) {
									System.out.println();
									System.out.println("회원 탈퇴가 완료되었습니다.");
									System.out.println("시스템을 다시 시작해주세요.");
									System.exit(0);
								} else {
									System.out.println();
									System.out.println("오류가 발생했습니다. 다시 시도해주세요.");
								}
							}

						} else {
							System.out.println();
							System.out.println("잘못 입력하셨습니다. 다시 시도해주세요.");
						}

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						DB_Connect.disconnectDB();
					}
				} else if (leave == 0) {
					break;
				} else {
					System.out.println();
					System.out.println("잘못된 메뉴 번호입니다.");
				}
				

			} else {
				System.out.println();
				System.out.println("잘못된 메뉴 번호입니다.");
			}
		}

	}

	// 대출 관리
	public void rentalManage(int member_id) {
		int menu;

		System.out.println();
		System.out.println("*** 일산 도서관 대출 관리 메뉴 ***");
		System.out.println("1. 대출 목록 조회 ");
		System.out.println("2. 도서 반납 ");
		System.out.println("0. 이전 페이지");
		System.out.println("메뉴를 선택하세요 : ");
		menu = scanner.nextInt();
		scanner.nextLine();

		if (menu == 0) {
			return;
		} else if (menu == 1) {

			try {

				// DB 연결
				DB_Connect.connectDB();

				// 대출 목록 출력
				String getRentalListQuery = "SELECT books.*, rental.member_id, rental.rental_id, rental.book_id, rental.rental_date, rental.rental_due_date "
						+ "FROM books " + "LEFT JOIN rental ON books.book_id = rental.book_id "
						+ "WHERE rental.member_id = ? AND rental.return_date IS NULL";

				PreparedStatement getRentalListStatement = DB_Connect.getConnection()
						.prepareStatement(getRentalListQuery);
				getRentalListStatement.setInt(1, member_id);

				ResultSet rentalList = getRentalListStatement.executeQuery();
				
				System.out.println();
				while (rentalList.next()) {
					System.out.println("대여 번호: " + rentalList.getInt("rental_id") + " | 책 번호: "
							+ rentalList.getInt("book_id") + " | 책 제목: " + rentalList.getString("title") + " | 대출일 : "
							+ rentalList.getString("rental_date") + " | 반납 기한 : "
							+ rentalList.getString("rental_due_date"));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DB_Connect.disconnectDB();
			}

		} else if (menu == 2) {
			int bookNum;

			boolean repeat = true;
			while (repeat) {
				try {

					// DB 연결
					DB_Connect.connectDB();

					// 대출 목록 출력
					String getRentalListQuery = "SELECT books.*, rental.member_id, rental.rental_id, rental.book_id, rental.rental_date, rental.rental_due_date "
							+ "FROM books " + "LEFT JOIN rental ON books.book_id = rental.book_id "
							+ "WHERE rental.member_id = ? AND rental.return_date IS NULL";
					PreparedStatement getRentalListStatement = DB_Connect.getConnection()
							.prepareStatement(getRentalListQuery);
					getRentalListStatement.setInt(1, member_id);

					ResultSet rentalList = getRentalListStatement.executeQuery();

					while (rentalList.next()) {
						System.out.println("대여 번호: " + rentalList.getInt("rental_id") + " | 책 번호: "
								+ rentalList.getInt("book_id") + " | 책 제목: " + rentalList.getString("title")
								+ " | 대출일 : " + rentalList.getString("rental_date") + " | 반납예정일 : "
								+ rentalList.getString("rental_due_date"));
					}
					System.out.println();
					System.out.print("반납을 위해 대여 번호를 입력하세요. : ");
					bookNum = scanner.nextInt();
					scanner.nextLine();

					// rental 테이블에서 해당 member_id(회원 id로 불러옴)과 입력한 book_id를 가지는 row 삭제
					String returnBookQuery = "UPDATE rental SET return_date=now() WHERE member_id = ? AND rental_id = ?";
					PreparedStatement returnBookStatement = DB_Connect.getConnection()
							.prepareStatement(returnBookQuery);
					returnBookStatement.setInt(1, member_id);
					returnBookStatement.setInt(2, bookNum);

					int rowsAffected = returnBookStatement.executeUpdate();

					if (rowsAffected > 0) {
						System.out.println();
						System.out.println("도서가 반납되었습니다.");
					} else {
						System.out.println();
						System.out.println("반납 처리 중 오류가 발생했습니다. 입력한 정보를 확인하세요.");
					}

					System.out.println();
					System.out.println("1. 추가 반납");
					System.out.println("0. 이전 페이지");
					System.out.print("메뉴를 선택해주세요. : ");
					int isDone = scanner.nextInt();

					if (isDone == 0) {
						repeat = false;
					} else {
						System.out.println("잘못된 메뉴 번호입니다.");
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					DB_Connect.disconnectDB();
				}
			}

		} else {
			System.out.println();
			System.out.println("잘못된 메뉴 번호입니다.");
		}

	}

}