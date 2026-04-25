import java.util.Scanner;
public class Group_1409_06{
	public static void main(String args[]){
		Scanner scan= new Scanner (System.in);
	
		System.out.print("숫자 입력 : ");
		int num=scan.nextInt();
		
		if(num>0) System.out.println("plus");
		else System.out.println("minus");
		if(num%2==0) System.out.println("even");
		else System.out.println("odd");
		
		
	}
}