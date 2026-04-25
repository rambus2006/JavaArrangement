public class ForExam6{
	public static void main(String args[]){
		//for(int K=1;K<=L;K++)
		
		for(int i=1;i<=5;i++){		
		         for(int L=4; L>=i;L--)	//4 3 2 1
			    System.out.print("*"+"\t");
		        for( int j=1;j<=i;j++)
				System.out.print(j+"\t");
	  	        System.out.println("\n");
		}	
	}
}