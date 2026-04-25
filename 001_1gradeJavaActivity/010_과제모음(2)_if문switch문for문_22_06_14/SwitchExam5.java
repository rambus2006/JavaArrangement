import java.util.Scanner;
public class SwitchExam5{
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);
		System.out.print("입력 : ");
		int Class=scan.nextInt();
		
		if(Class>=1 && Class<=6){
			switch (Class){
		  		 case 1: case 2:
					System.out.println("뉴미디어 소프트웨어과");
		  			break;
				case 3: case 4:
					System.out.println("뉴미디어 웹솔루션과");
				    	break;
				default: 
					System.out.println("뉴미디어 디자인과");
		   	}
		}else System.out.println("반을 잘못 입력하셨습니다");
		
	}
}