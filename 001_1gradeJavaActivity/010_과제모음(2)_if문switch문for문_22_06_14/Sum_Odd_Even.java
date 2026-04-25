import java.util.Scanner;
public class Sum_Odd_Even{
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);
		int odd_sum=0;	//홀수의 합
		int even_sum=0;	//짝수의 합
		
		//입력받기
		System.out.print("첫번째 수를 입력하세요 : ");
		int num1=scan.nextInt();
		System.out.print("두번째 수를 입력하세요 : ");
		int num2=scan.nextInt();

		//홀수,짝수의 합 구하기
		for(int i=num1;i<=num2;i++){
			if(i%2==0) even_sum+=i;
			else odd_sum+=i;
		}

		System.out.println("홀수의 합 : "+odd_sum);
		System.out.println("짝수의 합 : "+even_sum);
		
		
		
	}
}