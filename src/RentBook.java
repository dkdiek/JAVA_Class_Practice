import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.InputMismatchException;

import my_library2.DB_Connect;

public class RentBook {

	
	// 2. 도서 대출 [완료/]
		public void rentBook(int member_id) {
		    String bookID;
		    int userRental;
		    boolean retry = true;

		    while (retry) {
		        // DB 연결
		        DB_Connect.connectDB();

		        try {
		            // 1 - 대출 가능 수량 확인
		            // rental 테이블에서 member_id로 return_date가 null값이 몇 개인지 확인
		            String countRentedBooksQuery = "SELECT COUNT(*) FROM rental WHERE member_id = ? AND return_date IS NULL";
		            PreparedStatement countRentedBooksStatement = DB_Connect.getConnection().prepareStatement(countRentedBooksQuery);
		            countRentedBooksStatement.setInt(1, member_id);
		            ResultSet rentedBooksResult = countRentedBooksStatement.executeQuery();

		            if (rentedBooksResult.next()) {
		                int rentedBooksCount = rentedBooksResult.getInt(1);
		                // member_id로 return_date가 null인 컬럼이 5개 이상이면 대출 불가 안내
		                if (rentedBooksCount >= 5) {
		                    System.out.println("5권 이상 대출 중입니다. 더 이상 대출할 수 없습니다.");
		                } else {
		                    // 2 - 연체 유무 확인
		                    // return_due_date가 지났고 return_date가 null인 값이 있는지 확인
		                    String checkOverdueBooksQuery = "SELECT COUNT(*) FROM rental " +
		                            "WHERE member_id = ? AND return_date IS NULL AND rental_due_date < ?";
		                    PreparedStatement checkOverdueBooksStatement = DB_Connect.getConnection().prepareStatement(checkOverdueBooksQuery);
		                    checkOverdueBooksStatement.setInt(1, member_id);
		                    checkOverdueBooksStatement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
		                    ResultSet overdueBooksResult = checkOverdueBooksStatement.executeQuery();
		                    // 연체 유 - 대출 불가 안내
		                    if (overdueBooksResult.next()) {
		                        int overdueBooksCount = overdueBooksResult.getInt(1);
		                        if (overdueBooksCount > 0) {
		                            System.out.println("연체된 도서가 있어 대출이 불가합니다.");
		                        // 연체 무 - 대출 진행
		                        } else {
		                            System.out.println("대출하실 도서 번호를 입력하시오: ");
		                            bookID = scanner.nextLine();

		                            // 도서 대출 가능 여부 확인
		                            String checkBookAvailabilityQuery = "SELECT COUNT(*) FROM rental WHERE book_id = ? AND return_date IS NULL";
		                            PreparedStatement checkBookAvailabilityStatement = DB_Connect.getConnection().prepareStatement(checkBookAvailabilityQuery);
		                            checkBookAvailabilityStatement.setString(1, bookID);
		                            ResultSet bookAvailabilityResult = checkBookAvailabilityStatement.executeQuery();

		                            // 도서가 books 테이블에 존재하지 않는 경우
		                            String checkBookExistenceQuery = "SELECT COUNT(*) FROM books WHERE book_id = ?";
		                            PreparedStatement checkBookExistenceStatement = DB_Connect.getConnection().prepareStatement(checkBookExistenceQuery);
		                            checkBookExistenceStatement.setString(1, bookID);
		                            ResultSet bookExistenceResult = checkBookExistenceStatement.executeQuery();
		                            
		                            if (bookExistenceResult.next() && bookExistenceResult.getInt(1) == 0) {
		                                System.out.println("해당 도서가 존재하지 않습니다.");
		                            } else if (bookAvailabilityResult.next() && bookAvailabilityResult.getInt(1) > 0) {
		                                System.out.println("해당 도서는 이미 대출 중입니다.");
		                            } else {
		                                // 도서 대출 처리
		                                // rental_due_date를 현재 시각에서 7일 후로 설정
		                                LocalDateTime now = LocalDateTime.now();
		                                LocalDateTime dueDate = now.plusDays(7);

		                                // member_id 값을 이용하여 rental 테이블에 도서 대출 정보 삽입
		                                String insertRentalQuery = "INSERT INTO rental (member_id, book_id, rental_due_date) VALUES (?, ?, ?)";
		                                PreparedStatement insertRentalStatement = DB_Connect.getConnection().prepareStatement(insertRentalQuery);
		                                insertRentalStatement.setInt(1, member_id);
		                                insertRentalStatement.setString(2, bookID);
		                                insertRentalStatement.setTimestamp(3, Timestamp.valueOf(dueDate));

		                                // 인서트 후 추가 행 수를 rowsAffected에 담는다
		                                int rowsAffected = insertRentalStatement.executeUpdate();

		                                if (rowsAffected > 0) {
		                                    System.out.println("도서가 대출되었습니다.");
		                                } else {
		                                    System.out.println("대출 처리 중 오류가 발생했습니다.");
		                                }
		                            }
		                        }
		                    } else {
		                        System.out.println("연체 도서 확인 중 오류가 발생했습니다.");
		                    }
		                }
		            } else {
		                System.out.println("대출 가능 수량 확인 중 오류가 발생했습니다.");
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } catch (InputMismatchException e) {
		            System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
		            scanner.next(); // 버퍼 비우기
		        } finally {
		            DB_Connect.disconnectDB();
		        }

		        // 추가 대출 여부 확인
		        System.out.println();
		        System.out.println("1. 추가 대출");
		        System.out.println("2. 나가기");
		        System.out.printf("> 메뉴를 입력하시오: ");
		        userRental = scanner.nextInt();
		        scanner.nextLine();

		        if (userRental == 1) {
		            retry = true;
		        } else if (userRental == 2) {
		            retry = false;
		        } else {
		            System.out.println("잘못된 메뉴 번호입니다");
		        }
		    }
		}
	
	
	
	
	
	
	
	
	
	
	
}
