package _24ArrayList문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ArrayListQ7 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(
                Arrays.asList(1,3,3,5,7,7,7,2)
    );
        HashMap<Integer,Integer> result = new HashMap<>();
        for(Integer num:arr){
            if(!result.containsKey(num)){
                //num키를 1로 초기화
                result.put(num, 1);
            }else{
                //키가 이미 있으므로 num의 키의 값을 1 증가
                result.get(num+1);
            }
            //System.out.println(num);
        }

    }


}
