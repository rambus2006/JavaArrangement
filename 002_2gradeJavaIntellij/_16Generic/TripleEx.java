package _16Generic;
import _16Generic.Triple;

public class TripleEx {
    public static void main(String[] args) {
        Triple<String,Double,Integer> triple = new Triple<>("r",3.4,6);
        System.out.println(triple.getFirst()); //출력하는 방법꼭 알고 넘어가기
        System.out.println(triple.getSecond()); //출력하는 방법꼭 알고 넘어가기
        System.out.println(triple.getThird()); //출력하는 방법꼭 알고 넘어가기
    }
}
