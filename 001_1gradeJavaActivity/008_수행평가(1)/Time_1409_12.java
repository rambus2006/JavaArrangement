import java.util.Scanner;
public class Time_1409_12{
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);
		
		System.out.print("정수(초)를 입력하세요 : ");
		int second=scan.nextInt();
		int hour=0,minute=0,Remainder=0;

		hour=(second/3600);
		Remainder=(hour%3600);
		minute=(Remainder/60);
		Remainder=(minute%60);

		System.out.print(second+"초는 " + hour+"시간 " + minute+"분"+Remainder+"초"+" 입니다.");
	}
}