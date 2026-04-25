import java.util.Scanner;
public class Hakbonname_original{
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);

		//자주 수정하게될 코드
		//학번,이름,과목 입력받음(국어,영어,수학,자바) 
		//합계와 평균 일자로 출력
		String hakbon;
		String name;
		int kor;
		int eng;
		int mat;
		int jav;
		int tot;
		float avg;

		System.out.print("학번 : ");
		 hakbon=scan.next();
		System.out.print("이름 : ");
		 name = scan.next();
		
		System.out.print("국어 : ");
		 kor = scan.nextInt();
		System.out.print("영어 : ");
		eng = scan.nextInt();
		System.out.print("수학 : ");
		mat = scan.nextInt();
		System.out.print("자바 : ");
		 jav = scan.nextInt();

		tot =( kor + eng + mat + jav);
		avg = (float)tot/4;
		
		System.out.printf("%s %s %d %d %d %d %d %.2f",hakbon,name, kor, eng, mat, jav, tot, avg);
		
		
		
	}
}