public class SwitchExam4{
	public static void main(String args[]){

		(2022.06.14(화))
		int number = Integer.parseInt(args[0]);
		int day;
		if(number > =1 &&number<=12){
			switch (number){
		  		 case 1 : case 3 : case 5 : case 7 : case 8: case 10: case 12:
					day = 31; break;
		  		 case 4 : case 6 : case 9: case 11:
				day =  30; break;
		   		default : day=28;
				}
		}
		else System.out.println("월은 1~12까지만 입력 가능합니다.");
		System.out.println( number + "월은 " + day + "일입니다");
	}
}