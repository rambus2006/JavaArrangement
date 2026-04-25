import java.util.Scanner;
public class Ex3_1409 {
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);
		
		//변수 선언
		int score=0;
		int num=0;
		int big=0;		//최댓값=최솟값으로 주고 시작.
		int small=100;	//최솟값=최댓값으로 주고 시작

		System.out.print("학생 수 입력 : ");
		int student=scan.nextInt();
		
		//학생수만큼 반복
		for(int i=1;i<=student;i++){
			System.out.print(i+"번 점수 입력 : ");
			score=scan.nextInt();	//점수를 입력받기
			
			//최댓값이면서 최솟값인 경우도 고려해야한다.else if 를 주면 안됨...ㅠㅠ
			if(score>big) big=score;	//4 
		                 if (score<small) small=score;
				
		}
		System.out.print("최대점수 : "+big+"\n");
		System.out.print("최소점수 : "+small);

		
	}
}