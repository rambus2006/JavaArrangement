import java.util.Scanner;
public class Salary_Switch{
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);
		
		//변수선언
		double raise=0.0;
		double newSalary;

		//직원의 연봉과 근무평가등급 입력받기
		System.out.print("현 연봉을 입력하세요 : ");
		double currentSalary=scan.nextDouble();
		System.out.print("근무평가등급을 입력하세요 : ");
		String rating=scan.next();
		
		//연봉인상액
		switch(rating){
			case "우수":
			 	raise=( currentSalary*0.06);
				break;
			case "보통":
				raise=( currentSalary*0.04);
				break;
			case "불량":
				raise=( currentSalary*0.02);
				break;
			default :
		}
		newSalary = (currentSalary+raise);
		System.out.println("연봉인상액 : " + raise);
		System.out.println("새 연봉인상액 : "+newSalary);
		
		
		
		
	}
}