import java.util.Scanner;
public class FlagSum{
	public static void main(String args[]){	
		Scanner scan=new Scanner(System.in);

		//220621
		//n을 입력받아 For문을 이용하여 1-2+3-4+5....-n의 결과를 출력하는 프로그램
		//*방법 2 수정하기!!!!!!!!!!!!

		//방법1
		//n입력,변수 선언
		System.out.print("n을 입력하세요 : ");
		int n=scan.nextInt();
		
		/*
		int even_num=0, odd_num=0;
		int i =1;
		
		System.out.print(i);
		for( i=2;i<=n;i++){
			//n을 입력받아 계산
		   
			if(i%2==0){
				even_num+=i;
				System.out.print("-"+i);
			}
			else {
				odd_num +=i;
				System.out.print("+"+i);
			}
		}
	
		//결과 출력
		System.out.print(" = ");
		System.out.println(1+odd_num-even_num); //홀수의 합에서 짝수의 합을 빼도 결과는 똑같다.
		*/
		
		//방법2
		
		/*
		int sum=0;
		for( int i=2;i<=n;i++){
			//n을 입력받아 계산
		   
			if(i%2==0){
				 sum-=i;
				System.out.print("-"+i);
			}
			else {
				sum+=i;  
				System.out.print("+"+i);
			}
		}
	
		//결과 출력
		System.out.println(" = "+sum); 
		*/
		
		
		
	}
}