public class For_Test1{
	public static void main(String args[]){
		
	
		for(int i=1;i<=100;i++){
			    switch(i%10){
				case 0 : System.out.print("\n"); break;
				case 3 : case 6 :  case 9 : System.out.print("\t"+"X"); break;
				default :  System.out.print("\t"+i);	
			    }
		}
	}
}