import java.util.Scanner;
public class Tax_calculate{
	public static void main(String args[]){
		Scanner scan =new Scanner(System.in);

		int tax=0;		//tax로 바꾸기
		
		System.out.print("근로소득을 입력하세요(원) : ");
		int salary =scan.nextInt();
		
		if(salary<=20000000)  tot = (int)(salary * (0.05));
		else if(salary<=40000000) tax =(int)(salary * (0.15));
		else if(salary<=80000000) tax =(int)(salary * (0.25));
		else tax = (int)(salary*(0.4));
		System.out.println("연간 근로소득에 대한 소득세는 " + tot + "원 입니다.");
		
		/*
		int tot=0;
		
		System.out.print("근로소득을 입력하세요(원) : ");
		int salary =scan.nextInt();
		
		if(salary<=20000000)  tax = salary * 5/100;
		else if(salary<=40000000) tax =salary * 15/100);
		else if(salary<=80000000) tax =salary * 25/100);
		else tax = salary * 40/100;
		System.out.println("연간 근로소득에 대한 소득세는 " + tax + "원 입니다.");
		*/
		

		
	}
}