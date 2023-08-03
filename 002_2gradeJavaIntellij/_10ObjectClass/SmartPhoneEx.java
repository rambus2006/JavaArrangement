package _10ObjectClass;
/*[toString()]
* ● String toString()
* - 객체를 문자열로 반환
* - Object클래스에 구현된 toString()이 반환하는 문자열
* - 객체 + 문자열 -> 객체.toString()+문자열로 자동 반환
* - 형식 : p + "점" => p.toString()+"점"을 이용해 바꿨다.
* */
class SmartPhone{
    private String company;
    private String os;

    public SmartPhone(String company,String os){
        this.company = company;
        this.os = os;
    }

    @Override
    public String toString() { //이부분
        return "SmartPhone{" +
                "company='" + company + '\'' +
                ", os='" + os + '\'' +
                '}';
    }
}
public class SmartPhoneEx {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("구글","안드로이드");
        String strObj = myPhone.toString();
        System.out.println(strObj);
        System.out.println(myPhone);
    }
}
