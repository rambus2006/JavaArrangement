import java.util.Scanner ;
public class If_Nested{
	public static void main(String args[]){
	
          //중첩된 if문
	Scanner scan=new Scanner(System.in);
	System.out. print("현금을 입력하세요 :");
	int money = scan.nextInt();		
	
	if(money>=30000)	{			//중괄호도 쓰고 들여쓰기도 해주는 것이 최상  
                 if(money>=50000){
			System.out.println("모범택시를 타고 갑니다.");
                 }
                 else{
			System.out.println("일반택시를 타고 갑니다.");
	     }
	}
	else if(money>=10000){			//else if 는 계속 붙여서 쓰기 가능
		System.out.print("버스를 탑니다.");
	}
	else{
		System.out.print("걸어갑니다.");
	}
	
	
	

	}
}



















