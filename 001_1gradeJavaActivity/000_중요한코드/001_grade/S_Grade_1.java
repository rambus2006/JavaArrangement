import java.util.Scanner;
  public class S_Grade_1{
   	public static void main(String args[]){		//입력받아 출력하는 grade

      	Scanner scan=new Scanner(System.in);		//입력문

     	 System.out.print("이름을 입력하세요 : ");
      	 String name= scan.next();			//name에 입력받아 저장

     	 System.out.print("과제 점수를 입력하세요 : ");
      	int project= scan.nextInt();			//project에 입력받아 저장


      	System.out.print("보너스 점수를 입력하세요 : ");
      	int bonus= scan.nextInt();			//bonus에 입력받아 저장

            int sum=project+bonus;			//sum은 project랑 bonus 값 더한 값 저장

          	  System.out.println("----------자바실행----------");		
       	System.out.println("이름\t과제\t보너스\t합계");
	System.out.printf("%s\t%3d\t%3d\t%3d\n",name,project,bonus,sum);		//\t: 공백,%s 는 string 형 출력 , %앞의 숫자는 정렬


	}
}