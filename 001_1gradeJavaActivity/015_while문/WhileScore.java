import java.util.Scanner;
public class WhileScore{
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);

		
		//변수 선언(count == 반복횟수)
		int count=0,sum=0;
		double avg=0;
		
		while(true){
			System.out.print("score를 입력하세요 : ");
			int score=scan.nextInt();
			sum = (sum+score);
			count++;

			//만약 score==0 으로 입력받았을 때 탈출
			//처음에 0을 입력하면 NaN이 출력
			if(score==0) break;	
	
		}
		
		//평균 구하기 
		avg=(double)sum/(double)(count-1);
	
		//합계와 평균 출력
		System.out.println("합계 : " + sum);

		//NaN이 출력되지 않게 하기 위한 조건문
		if(count==1) System.out.println(" 평균이 0입니다.");
		else System.out.print("평균 : " + avg);
		
	}
}

/*방법2 -(주석은 간결하고 단순하게 의미전달이 잘 되게)
import java.util.Scanner;
public class WhileScore{
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);

		
		//변수 선언(count 반복횟수)
		int count=0,sum=0;
		double avg=0;
		
		while(true){
			System.out.print("score를 입력하세요 : ");
			int score=scan.nextInt();
			if(score==0) break;		//if문 을 여기다가 씀
			sum = (sum+score);
			count++;
	
		}
		
		//평균 구하기 
		avg=(double)sum/count; 
	
		//합계와 평균 출력
		System.out.println("합계 : " + sum);

		//NaN이 출력되지 않게 하기 위한 조건문
		if(count==0) System.out.println(" 평균이 0입니다.");
		else System.out.print("평균 : " + avg);
		
	}
}
*/
