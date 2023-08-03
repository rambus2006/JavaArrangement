package _19PerformTest._01Inheritance;

public class MyFriendInfoAn {
    private String name;
    int age;
    public MyFriendInfoAn(String name,int age){
        this.name = name;
        this.age=age;
    }
    public void ShowMyFriendInfo(){
        System.out.println("이름 : "+name );
        System.out.println("나이 : "+age);
    }
}
class MyFriendDetailInforAn extends MyFriendInfoAn
{
    private String addr;
    private String phone;

    public MyFriendDetailInforAn(String name, int age,String addr,String phone){
        super(name,age);
        this.addr=addr;
        this.phone=phone;
    }
    public void ShowMyFriendDetailInfroAn(){
        ShowMyFriendInfo();
        System.out.println("주소 : "+addr);
        System.out.println("전화 : "+phone);
    }
}
class QuMyFriendDetailInfo{
    public static void main(String[] args) {
        MyFriendDetailInforAn fr=new MyFriendDetailInforAn("이순신",100,"성균관","010-193-3442");
        fr.ShowMyFriendDetailInfroAn();
    }
}
