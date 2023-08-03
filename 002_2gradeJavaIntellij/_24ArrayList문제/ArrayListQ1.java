package _24ArrayList문제;

import java.util.ArrayList;
public class ArrayListQ1 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        //일반적인 for문
        //인덱스 번호가 중요할 때
        for(int i=0;i<numbers.size();i++){
            System.out.println(numbers.get(i));
        }
        for(Integer i : numbers){
            System.out.println(i);
        }
    }


}
