import java.util.Scanner;
public class Currency_1409_07{
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);

		System.out.print("금액을 입력하시오 >> ");
		int money=scan.nextInt();
		int Remainder;

		System.out.println("오만원권"+(money/50000)+" 매");
		Remainder=(money%50000);
		System.out.println("만원권"+(Remainder/10000)+" 매");
		Remainder=money%10000;
		System.out.println("오천원권"+(Remainder/5000)+" 매");
		Remainder=money%5000;
		System.out.println("천원권"+(Remainder/1000)+" 매");
		Remainder=money%1000;
		System.out.println("오백원권"+(Remainder/500)+" 매");
		Remainder=money%500;
		System.out.println("백원권"+(Remainder/100)+" 매");
		Remainder=money%100;
		System.out.println("오십원"+(Remainder/50)+" 매");
		Remainder=money%50;
		System.out.println("십원"+(Remainder/10)+" 매");
		Remainder=money%10;
		System.out.println("오원"+(Remainder/5)+" 매");
		Remainder=money%5;
		System.out.println("일원"+(Remainder/1)+" 매");
		
		
		
		

		
	}
}