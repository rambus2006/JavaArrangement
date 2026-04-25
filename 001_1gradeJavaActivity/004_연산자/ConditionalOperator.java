import java.util.Scanner;
public class ConditionalOperator{
	public static void main(String args[]){
		
		

		//조건연산자
		/*int a=10;
		int b=5;
		int c=0;*/
		
		/*if(a>b) c=a;
		else if(a<b) c=b;
		
		System.out.println(c);*/

		Scanner scan=new Scanner(System.in);
		
		System.out.print("a를 입력하세요 : ");
		int a=scan.nextInt();
		System.out.print("b를 입력하세요 : ");
		int b=scan.nextInt();
		int c=0;
		
		
		
		c=(a>b)?a:b;
		System.out.print("더 큰수는 " + c +"입니다.");
		
			
	}
}