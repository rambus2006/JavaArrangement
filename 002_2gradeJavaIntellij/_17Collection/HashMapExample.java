package _17Collection;

import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        //Map 컬렉션 생성
        Map<String,Integer> map = new HashMap<String,Integer>();

        //객체 저장
        map.put("신용권",85);
        map.put("홍길동",95);
        map.put("동장군",80);
        map.put("홍길동",95);
        System.out.println("총 Entry 수: " + map.size());

        //객체 찾기
        System.out.println("\t홍길동 : " + map.get("홍길동")); //이름 "홍길동"으로 점수(값)을 검색

        //객체를 하나씩 처리
        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while (keyIterator.hasNext()){
            String key = keyIterator.next();
            Integer value = map.get(key);
            System.out.println("\t" + key + " : " + value);
        }
        System.out.println();

        //객체 삭제
        map.remove("홍길동"); //키로 Map,Entry를 제거
        System.out.println("총 Entry 수 : " + map.size());

        //객체를 하나씩 처리
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String,Integer>> entryIterator = entrySet.iterator();

        while(entryIterator.hasNext()){
            Map.Entry<String,Integer> entry = entryIterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("\t" + key + " : " + value);
        }
        System.out.println();

//        객ㅊ[를 전체 삭제
        map.clear();
        System.out.println("총 Entry 수 : " + map.size());
    }
}
