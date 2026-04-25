import java.util.Scanner;
public class Switch_Age2{
	public static void main (String args[]){

		//나이를 입력받아 출력
		Scanner scan=new Scanner(System.in);
		
		System.out.println("나이를 입력하세요 : ");
		int age=scan.nextInt();

		switch(age/10){
			case 10:
				System.out.println("100살입니다.");
				break;
			case 9:				//기왕이면 높은 숫자부터 	
			case 8:
			case 7:
			case 6:
				System.out.println("노인입니다.");
				break;
			case 5:
			case 4:
			case 3:
			case 2:
				System.out.println("청년입니다.");
				break;
			case 1:
				System.out.println("학생입니다.");
				break;
			case 0:
				System.out.println("아이입니다.");
				break;
		
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			
		}
	}
}