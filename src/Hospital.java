
public class Hospital {
	//남은 병상수
	int nowPatientCount;
	
	//남은 병상이 50자리인데 병원에 추가 환자 51명 들어갈 수 있니?
	boolean isPossible(int requestCount){
		return (nowPatientCount - requestCount) > 0;
	}
	
}