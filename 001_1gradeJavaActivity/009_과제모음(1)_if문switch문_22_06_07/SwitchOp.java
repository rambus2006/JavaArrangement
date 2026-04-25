import java.util.Scanner;
public class SwitchOp{
	public static void main(String args[]){
	 	Scanner scan=new Scanner(System.in);
		
		//(2022.06.14(화))
		System.out.print("수식 입력(수와 연산자 사이는 공백을 둘 것) : ");
		int a = scan.nextInt();
		char op=scan.next().charAt(0);
		int b= scan.nextInt();
		
		switch(op){
			case '+':System.out.println(a+" " + "+" + " " +b+"="+ " " +(a+b));
				break;
			case '-':System.out.println(a+" " + "-"+" " + b+"="+ " " +(a-b));
				break;
			case '*':System.out.println(a+" " + "*"+ " "+ b+"="+" " +(a*b));
				break;
			case '/':System.out.println(a+" " + "/"+" " +b+"="+" " +(a/b));
				break;
			default : System.out.println("사칙연산자가 아닙니다.");
			
		}
	}
}