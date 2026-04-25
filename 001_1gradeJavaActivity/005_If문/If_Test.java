import java.util.Scanner ;			//입력문
public class If_Test{
	public static void main(String args[]){

	//if 문 
	Scanner scan=new Scanner(System.in);	//입력문
	System.out. print("점수를 입력하세요 :");	//질문: "점수를 입력하세요"
	int score = scan.nextInt();		//score에 사용자가 입력한 숫자 저장
	
	if(score>=80){			//만약 score가 80 이상일 때 "합격입니다."메세지 출력
	System.out.print("합격입니다.");		
	}
	

	}
}
