import java.util.Scanner;
public class IfExam2_1{
	public static void main(String args[]){
		Scanner scan =new Scanner(System.in);
		
		
		int a =scan.nextInt();
		char op=scan.next().charAt(0);
		int b= scan.nextInt();
		
		
		if(op=='+'|| op=='-'||op=='*';op=='/'){
			System.out.print(a+""+op+""+b+"=");
			if(op=='+') System.out.println(a+"+"+b+"="+(a+b));
				else if(op == '-') System.out.println((a-b));
				else if(op == '*') System.out.println((a*b));
				else (op == '/') System.out.println((a/b));
		}
		else System.out.println("사칙연산자가 아닙니다. " );
		
		/*
		if(op=='+') System.out.println(a+"+"+b+"="+(a+b));
		else if(op == '-') System.out.println(a+"-"+b+"="+(a-b));
		else if(op == '*') System.out.println(a+"*"+b+"="+(a*b));
		else if(op == '/') System.out.println(a+"/"+b+"="+(a/b));
		else System.out.println("사칙연산자가 아닙니다. " );
		*/

		
	}
}