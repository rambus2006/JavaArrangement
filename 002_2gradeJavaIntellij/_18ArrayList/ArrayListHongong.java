package _18ArrayList;

import java.util.*;
public class ArrayListHongong {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(); //리스트에 String 객체 저장
        list.add("java"); //인덱스 0에 간접참조 해서 객체 저장
        list.add("JDBC"); //인덱스 1에 간접 참조 객체 저장
        list.add("Servlet/JSP"); //인덱스 2에 간접 참조  객체 저장
        list.add(2,"Database"); //인덱스 2에 "Database" 객체 저장
        list.add("iBATIS");

        //저장된 총 객체수 리턴
        int size = list.size(); //list 인터페이스 > size 메소드 : 저장되어 있는 전체 객체 수를 리턴합니다.
        System.out.println("총 객체수 : " + size);
        System.out.println();

        //2번 인덱스객체 얻기
        String skill = list.get(2);
        System.out.println("2 : " + skill);
        System.out.println();

        //저장된 객체수만큼 루프 돌기
        for(int i=0;i<list.size();i++){
            String str = list.get(i);
            System.out.println(i + ":" + str);
        }
        System.out.println();

        list.remove(2); //2번 인덱스 객체 삭제됨 (Database)
        list.remove(2); //2번 인덱스 객체 삭제됨(Servlet/JSP) 삭제됨 -> 인덱스 3을 해야 없어지는 것 아닌가? 앞에꺼 삭제시 인덱스가 당겨짐

        for(int i=0;i<list.size();i++){
            String str = list.get(i);
            System.out.println(i + ":" + str);
        }
    }
}
