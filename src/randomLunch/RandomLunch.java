package randomLunch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 컴퓨터 랜덤 기능 사용해서 메뉴를 정해주는 프로그램
 * 그 날의 날씨 (기온, 습도, 맑음/흐림)를 사용자로부터 입력 받아서 참고하도록 할 것.
 *  
 */
public class RandomLunch {
	
	int temperature;
	boolean rainOrSnow;
	
	public void setMenu() {

		// 기온별 리스트 - level1
		List temperatureLevel = new ArrayList();
		
		List hot = new ArrayList();
		List warm = new ArrayList();
		List cold = new ArrayList();
		
		temperatureLevel.add(hot);
		temperatureLevel.add(warm);
		temperatureLevel.add(cold);
		
		// 기온별 리스트 - hot 메뉴 - level2
		List hotMenu = new ArrayList();
		List hotMenuRS = new ArrayList();
		
		hot.add(hotMenu);
		hot.add(hotMenuRS);
		
		// 기온별 리스트 - warm 메뉴 - level2
		List warmMenu = new ArrayList();
		List warmMenuRS = new ArrayList();
		
		hot.add(warmMenu);
		hot.add(warmMenuRS);

		// 기온별 리스트 - cold 메뉴 - level2
		List coldMenu = new ArrayList();
		List coldMenuRS = new ArrayList();
		
		hot.add(coldMenu);
		hot.add(coldMenuRS);
		
		
		// 기온별 리스트 - hot 메뉴 - 비눈YesOrNot - level3
		hotMenu.add("냉명");
		hotMenu.add("냉모밀");
		
		hotMenuRS.add("파전");
		hotMenuRS.add("부추전");
		
		// 기온별 리스트 - warm 메뉴 - 비눈YesOrNot - level3
		warmMenu.add("삼겹살");
		warmMenu.add("스테이크");
		
		warmMenuRS.add("우동");
		warmMenuRS.add("오뎅탕");

		// 기온별 리스트 - cold 메뉴 - 비눈YesOrNot - level3
		coldMenu.add("삼겹살");
		coldMenu.add("스테이크");
		
		coldMenuRS.add("파전");
		coldMenuRS.add("백숙");
		
	}
	
	
	
	public void recommendMenu() {
		Scanner sc = new Scanner(System.in);
		
		setMenu();
		
		System.out.println("** 메뉴 추천 프로그램 **");
		System.out.println("현재 기온을 입력하세요 : ");
		int temperature = sc.nextInt();
		
		System.out.println("눈 비가 오면 입 ");
		System.out.println("눈 & 비 = 1, 아니면 2 ");
		temperature = sc.nextInt();
		
		
		if ( 15 > temperature ) {
			//뜨거운 음식
		} else if ( 15 < temperature && 23 > temperature ) {
			//따뜻한 음식
		}  else if ( temperature > 22 ) {
			//시원한 음식
		}
		
		if ( rainOrSnow ) {
			
			
			
		} else if ( ! rainOrSnow ) {
			
		}
		
	}

}
