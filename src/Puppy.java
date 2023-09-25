
/*
 * 이름(name)
 * 견종(dogType)
 * 출생일시(birthDate)
 
 * 처리:
 * 행동(String doActioin(String command)
 * */



public class Puppy {

	 String name;
	 String dogType;
	 String birthDate;
	 
	 void informMyDog(String name, String dogType, String birthDate) {
		 this.name = name;
		 this.dogType = dogType;
		 this.birthDate = birthDate;
	 }
	 
//	 String doAction(String command) {
//		 if ("엎드려".equals(command)) { //command가 엎드려라면
//			 return "강아지가 엎드리는 행동";
//		 }
//	 }
	 	
}
