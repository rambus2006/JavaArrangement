package _10ObjectClass;

/*
[Object클래스]
1. boolean equals(Object obj)사용하기(by crome자료)
*/

import javax.sound.midi.MetaMessage;

class Member {
    public String id;

    public Member(String id) {
        this.id = id;
    }

    @Override //Object의 equals()메소드 오버라이딩
    public boolean equals(Object obj) { //equals()메소드:객체 상관 없이 저장하고 있는 데이터가 동일함
        if (obj instanceof Member) { //매개값 obj가 Member타입인지 확인
            Member member = (Member) obj; //Member타입으로 강제 타입 변환
            if (id.equals(member.id)) { //id필드값이 동일한지 검사, 동일하다면 true 리턴
                return true;
            }
        }
        return false; //매개값 obj가 Member 타입이 아니거나 id 필드값이 다른 경우 false
    }

}
public class MemberEx {
    public static void main(String[] args) {
        Member obj1 = new Member("blue");
        Member obj2 = new Member("blue");
        Member obj3 = new Member("red");

        if(obj1.equals(obj2)){ //obj1과 obj2가 같은지 비교했을 때 같으면 true
            System.out.println("obj1과 obj2는 동등합니다.");//매개값이 Member타입이고, id필드값도 동일해서 true
        }else { //obj1과 obj2가 같은지 비교했을 떄 다르면 false
            System.out.println("obj1과 obj2는 동등하지 않습니다.");
        }
        if(obj1.equals(obj3)){
            System.out.println("obj1과 obj2는 동등합니다. "); //매개값이 Member타입이지만, id필드값이 동일하지 않아 false
        }else {
            System.out.println("obj1과 obj3은 동등하지 않습니다. ");
        }
    }
}
