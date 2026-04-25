import java.util.Scanner;
public class WhileExam2{
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);

		//변수 선언
		int num=scan.nextInt();		//몇번 반복할지 입력
		int i=1 ;				// +1이 출력되지 않도록 1을 따로 빼기
		int sum=1 ;			//결괏값에도 1을 더함

		//1일때 수행하는 부분(1을 처리하고 while문 실행)
		System.out.print(i);
		i +=1;
		
		//연산식 계산 및 출력
		while(i<=num){
			//짝수인 경우
			if(i%2==0){
				 sum -=i;
				System.out.print("-"+i);
			}
			//홀수인 경우
			else{
				
				sum +=i;
				System.out.print("+"+i);
			}
			i++;			 // i 증감
		}
		//결과값 출력(1에서 결과 더함)
		System.out.print("="+sum);
		/*방법2
			System.out.print((i==1)?i;("+"+i));
		*/
	}
}