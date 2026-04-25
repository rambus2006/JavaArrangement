import java.util.Scanner;
public class Multiple_if {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("수 입력 : ");
		int a = scan.nextInt();
		
		//응용 문제 풀기 (3,5,8 의 배수 구하기)
		if(a%3==0) System.out.println(a + "은 3의 배수이다.");
		else if(a%5==0) System.out.println(a + "은 5의 배수이다.");
		else if(a %8==0) System.out.println(a + "은 8의 배수이다.");
		else System.out.println("어느 배수도 아니다.");
		
		//1.공배수를 구하려면 
		/*
		if(a%3==0 || a%5==0|| a%8==0{
			
			if(a%3==0) System.out.println(a + "은 3의 배수이다.");
			else if(a%5==0) System.out.println(a + "은 5의 배수이다.");
			else if(a %8==0) System.out.println(a + "은 8의 배수이다.");
		}else System.out.println("어느 배수도 아니다.");
		
	
	}
}