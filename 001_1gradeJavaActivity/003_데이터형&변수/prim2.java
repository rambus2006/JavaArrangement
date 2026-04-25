public class prim2 {
  public static void main( String args[]) {
	
	char a='A' ;
	char b='\u0030';
	int c =0745;
	int d =0x4523;
						//int e = 0L; 을 옳게 바꾸면 long e = 0L;가 된다. //
	long e = 0L;				//long은 8바이트인데 4바이트방에 넣으면 잃어버린다.long형은 long에//
	double f =3.141592e1;
    	float g =3.141592e1f;
	double h =3.14f;		  		//float가 double방에 들어가서 에러가 나지 않는다.//
	                                                          
	System.out.println( a );
	System.out.println( b );
	System.out.println( c );
	System.out.println( d );
	System.out.println( e );
	System.out.println( f );
	System.out.println( g );
	System.out.println( h );

  }
}