import java.util.Scanner;
public class Hakbonname_CharGrade{
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);
	
	
		//변수선언(학번,이름,국어,영어,수학,자바,합계,평균,등급)
		
		String hakbon;		
		String name;
		int kor;
		int eng;
		int mat;
		int jav;
		int tot;
		float avg;
		char grade;
		int student;
		

		System.out.print("인원수를 입력하세요 : ");
		student=scan.nextInt();

	// 3명의 데이터 반복해서 입력
	for( student=1;student<=3;student++){
		System.out.println("\n"+student+"번째 학생의 데이터 입력");
		
			//입력문
			System.out.print("학번 : ");
		 	hakbon=scan.next();
			System.out.print("이름 : ");
			name = scan.next();
			do{
				System.out.print("국어 : ");
		 		kor = scan.nextInt();
			}while(kor<0||kor>100);
			do{
				System.out.print("영어 : ");
				eng = scan.nextInt();
			}while (eng<0||eng>100);
			do{
				System.out.print("수학 : ");
				mat = scan.nextInt();
			}while (mat<0||mat>100);
			do{
				System.out.print("자바 : ");
		 		jav = scan.nextInt();
			}while (jav<0||jav>100);
		
			//합계계산, 평균게산
			tot =( kor + eng + mat + jav);
			avg = (float)tot/4;
		
			/*if 문으로 등급 나누기
			if(avg>=90){
				grade='A';
			}
			else if(avg>=80){
				grade='B';
			}
			else if(avg>=70){
				grade='C';
			}
			else if(avg>=60){
				grade='D';
			}
			else{
				grade='F';
			}
			*/

		//switch문으로 등급 나누기(2022.06.14)
		//switch 문의 괄호안에의 결괏값은 실수형이 올 수 없다.조건식의 값은 소수일수 없다.
		switch((int)(avg/10)){		
			case 10 : case 9 :
				grade ='A';
				break;
			case 8:
				grade ='B';
				break;
			case 7:
				grade ='C';
				break;
			case 6:
				grade ='D';
				break;
			default : grade ='F';
			
		}

		//출력문
		System.out.printf("%s %s %d %d %d %d %d %.2f %c",hakbon,name, kor, eng, mat, jav, tot, avg ,grade);
	}
		
		
		
	}
}