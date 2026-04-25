import java.util.Scanner ;
public class If_Elseif_Else_Test{
	public static void main(String args[]){
	
          //if,else if ,else문
	Scanner scan=new Scanner(System.in);
	System.out. print("현금을 입력하세요 :");		//질문 : 현금을 입력하세요
	int money = scan.nextInt();		
	
						//중괄호를 생략하고 싶으면 안쪽으로 들여쓰기
	if(money>=30000)	{			//만약 money가 30000이상이라면
		System.out.print("택시를 탑니다.");      	//"택시를 탑니다"메세지 출력
	}
	
	else if(money>=10000){			//만약 30000원 미만이고, 10000이상이라면
		System.out.print("버스를 탑니다.");	//"버스를 탑니다" 메세지 출력
	}	
	else{					//10000미만이라면 
		System.out.print("걸어갑니다.");		//"걸어갑니다."메세지 출력
	}
	
	
	

	}
}
