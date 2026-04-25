public class Switch_Score2{
	public static void main (String args[]){

		int score=85;
		switch(score/10){
			case 10:	
				System.out.println("만점입니다.");	
				break;				//break 주의
			case 9:
				System.out.println("A입니다.");
				break;
			case 8:
				System.out.println("B입니다.");
				break;
			case 7:
				System.out.println("C입니다.");
				break;
		
			default:
				System.out.println("D입니다.");
				break;
		}		
	}
}