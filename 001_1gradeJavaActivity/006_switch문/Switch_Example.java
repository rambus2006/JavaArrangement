public class Switch_Example{
	public static void main(String args[]){
		int num=1;
		
		switch(num){
			case 1:
				System.out.println("1학년입니다.");
				break;
			case 2: 
				System.out.println("2학년입니다.");
				break;
			case 3:
				System.out.println("3학년입니다.");
				break;
			default:
				System.out.println("그 외의 숫자입니다.");
				break;
		}
	}
}