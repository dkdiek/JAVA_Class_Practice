/*
 * 학원 관리 프로그램을 만드려고 한다
 * 학생, 강의 정보를 관리하고 싶다
 */


public class Academy {
	
	/*
	 * String studentName; String studentNo; String programName; String
	 * programSchedule;
	 * 
	 * void identifyStudent(String studentName, String studentNO) { this.studentName
	 * = studentName; this.studentNo = studentNo; }
	 * 
	 * 
	 * String showSchedule(String studentName, String studentNo) { return
	 * programName + programSchedule; }
	 */

	int totalStudentCount;
	String[] subject;
	
	void addStudentCount(int count) {
		totalStudentCount = totalStudentCount + count;
	}
}
