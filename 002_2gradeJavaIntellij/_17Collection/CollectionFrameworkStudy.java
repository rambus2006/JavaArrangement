package _17Collection;

import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

public class CollectionFrameworkStudy {

    //ArrayList보다는 Collection을 쓰자,순서가 있어야 할 때는 ArrayList가 아닌 List로 쓰자
    public static void method(Collection<Integer> list){

    }
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();//intialCapacity: 배열의 크기를 지정
        v.add(1);
        v.add(2); //콜렉션 안의 boolean.add()를 통해 구현됨
        System.out.println(v.size()); //2
        System.out.println(v.capacity()); //10
        System.out.println(v.get(0)); //1
        v.remove(0); //2밖에 없다.
        System.out.println(v.lastElement()); //2
        v.clear(); //다 지워지는 것
        System.out.println(v.size()); //0
        // System.out.println(v.elementAt(4)); //이거 대신 get 쓰는 게 낫다.
    }
}
