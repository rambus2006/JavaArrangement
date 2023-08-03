package _24ArrayList문제;

import java.lang.reflect.Array;
import java.util.ArrayList;

/*
* 단어를 저장하고 있는 words 변수에 저장된 ArrayList에 임의의 단어를 넣고 findLongest 메서드로 해당 ArrayList를 전달하면 findLongest에서는
* 가장 긴 단어를 찾아서 반환하도록 구현
* static String findLongest1(ArrayList<String> words){...}
* - 만약 단어의 길이가 같은 단어가 2개 이상 있으면 처음 나온 것, 혹은 마지막에 찾은 것 아무거나 반환
* - 힌트) length로 문자열의 길이를 확인 가능 */

public class ArrayListQ4 {
//      ArrayList<String> words = new ArrayList<>();
//       words.add("World");
//       words.add("mirim");
//       words.add("goodbye");
//
//       public void findLongest(){
//           for(Integer i:word){
//               Stirng max = words.max(arr);
//               arr++;
//           }
//
//       }
       static String findLongest1(ArrayList<String>words){
           String result = " ";
           for(String word : words){
               if(word.length()>result.length()){
                   result = word;
               }
           }
           return result;
       }

       static ArrayList<String> findLongest2(ArrayList<String> words){
           int len=-1;
           for(String word: words){
               if(word.length()>len) len = word.length();
           }
           ArrayList<String> result = new ArrayList<>();
           for(String word : words){
               if(word.length() ==len) result.add(word);
           }
           return result;
       }
}
