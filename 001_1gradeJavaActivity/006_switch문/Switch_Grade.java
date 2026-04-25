public class Switch_Grade{
	public static void main (String args[]){

		char grade='C';
		switch(grade){
			case'A':					//*아래 case와 동일하게 실행되기를 원하면 비워두면 된다.
			case 'B':
				System.out.println("잘했습니다.");
				break;
			case 'C': 
			case 'D':
				System.out.println("좀 더 노력하세요.");
				break;
			case 'F': 
				System.out.println("다시 수강하세요.");
				break;
			default:
				System.out.println("잘못입력하셨습니다");
				break;
		}
			
	}
}