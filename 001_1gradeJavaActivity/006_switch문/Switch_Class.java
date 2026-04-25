public class Switch_Class{
	public static void main (String args[]){

		int Class=1;
		switch(Class){
			case 1:					
			case 2:
				System.out.println("뉴미디어소프트웨어과");
				break;
			case 3: 
			case 4:
				System.out.println("뉴미디어웹솔루션과");
				break;
			case 5: 
			case 6: 
				System.out.println("뉴미디어디자인과");
				break;
		
			default:
				System.out.println("잘못입력하셨습니다");
				break;
		}
		//case문의 값에는 정수형(int),문자형(char+ ' '),문자열 (String)가 올 수 있다.
			
	}
}