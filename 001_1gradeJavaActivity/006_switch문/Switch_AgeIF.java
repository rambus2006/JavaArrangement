import java.util.Scanner;
public class Switch_AgeIF{
	public static void main (String args[]){

		//나이를 입력받아 출력
		Scanner scan=new Scanner(System.in);
		
		System.out.print("나이를 입력하세요 : ");
		int age=scan.nextInt();
		if(age<100 && age>=60){			//연산자 공부 논리연산자 or쓰면 안됨,
			System.out.println("노인입니다.");
		}
		else if(age>=20){
				System.out.println("청년입니다.");
		}
		else if(age>=10){
				System.out.println("학생입니다.");
		}
		else if(age>=0){
				System.out.println("아이입니다.");
		}
		else{
				System.out.println("잘못된 입력입니다.");
		}
	}
}