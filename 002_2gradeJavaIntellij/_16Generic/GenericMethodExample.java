package _16Generic;

public class GenericMethodExample {
    //T가 타입 매개 변수인 제네릭 메소드
    public static <T> GStack reverse(GStack<T>a){ //T타입 GStack을 받아옴(T타입 메소드)
        GStack<T>s=new GStack<T>(); //새로운 제네릭 객체생성
        while(true){
            T tmp; //T타입 변수 만들기
            tmp=a.pop(); //a를 temp에 하나씩 넣고 삭제시키기 (LIFO구조, 4.0,3.0,2.0,1.0,0.0)
            if(tmp==null) //null이면 while문 빠져나가기
                break;
            else
                s.push(tmp); //새 스택 s에 저장 (4.0,3.0,2.0,1.0,0.0)
        }
        return s; //새 스택을 반환
    }

    public static void main(String[] args) {
        //Double 타입의 GStack 생성
        GStack<Double> gs=new GStack<Double>();
        //5개의 요소를 스택에 넣기
        for(int i=0;i<5;i++){
            gs.push(new Double(i)); //0.0,1.0.2.0.3.0,4.0이 들어감
        }
        //메소드 호출
        gs=reverse(gs);
        //4번 넣었으니 for문으로 4번 반복
        for(int i=0;i<5;i++){
            System.out.println(gs.pop()); //0.0,1.0,2.0,3.0,4.0
        }
    }
}
