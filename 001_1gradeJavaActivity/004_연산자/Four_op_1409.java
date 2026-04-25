import java.util.Scanner;
public class Four_op_1409{
	public static void main( String args[])	{
		Scanner scan = new Scanner(System.in);
		
		//산술연산자(+,-,*,/)
		System.out.print(" 첫번째 실수를 입력하세요 : ");
		double a = scan.nextDouble( );
		System.out.print(" 두번째 실수를 입력하세요 : ");
		double b = scan.nextDouble( );
		 
		
		
		System.out.println (a + "+" + b + "=" + (a+b) );
		System.out.println(b + "-" + a + "=" + (-a+b) );
		System.out.println(a + "*" + b + "=" + (a*b) );
		System.out.println(a + "/" + b + "=" + (a/b) );
		
 	}
}
		
		