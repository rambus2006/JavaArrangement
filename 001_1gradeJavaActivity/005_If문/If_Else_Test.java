import java.util.Scanner ;
public class If_Else_Test{
	public static void main(String args[]){
	
	//java에서의 if 랑 else문
	Scanner scan=new Scanner(System.in);
	System.out. print("점수를 입력하세요 :");
	int score = scan.nextInt();		
	
	if(score>=80)			//코드가 한줄일 때는 중괄호 쓰지 않는다.(대신 들여쓰기 해야함)
		System.out.print("합격입니다.");		//만약 score가 80 점이상이면 "합격입니다."메세지 출력
	
	else					//만약 아니라면(score가 79점 이하이면 ) "불합격입니다."메세지 출력
		System.out.print("불합격입니다.");
	
	
	

	}
}
