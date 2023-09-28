package _17Collection;

import java.util.*;

public class HashMapDicEx {
    public static void main(String[] args) {
        //영어단어와 한글 단어의 쌍을 저장하는 HashMap의 컬렉션 생성
        HashMap<String,String> dic = new HashMap<String,String>(); //뒤에 있는 <String,String>은 비워둬도 됨)
        //3개의 (key,value)쌍을 dic에 저장
        dic.put("baby","아기 ");
        dic.put("love","사랑");
        dic.put("apple","사과");

        //영어 단어를 입력받고 한글 단어 검색 "exit"입력받으면 종료
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("찾고 싶은 단어는?");
            String eng = scanner.next();
            if(eng.equals("exit")){
                System.out.println("장비를 종료합니다...");
                break;
            }
            //해시맵에서 키 eng값 kor 검색
            String kor = dic.get(eng);
            if(kor == null)
                System.out.println(eng + "는 없는 단어입니다. ");
            else
                System.out.println(kor);
        }
        scanner.close();
    }
}
