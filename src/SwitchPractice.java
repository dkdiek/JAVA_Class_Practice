import java.util.Scanner;

public class SwitchPractice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("입력하세요");
		String input = sc.nextLine();
		
		switch(input) {
		case "eat":
		case "Eat":
		case "EAT":
			System.out.println("밥을 먹고 있습니다");
			break;
		case "exercise":
		case "Exercise":
		case "EXERCISE":
			System.out.println("운동을 하고 있습니다.");
			break;
		default:
			System.out.println("아무것도 안하고 있습니다.");
			
		}
	}

}
