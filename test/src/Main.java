public class Main {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fact(n));
    }
    public static int fact(int n ){
        if(n ==1)
            return 1;
//        System.out.println();
        return n * fact(n-1);
    }
}