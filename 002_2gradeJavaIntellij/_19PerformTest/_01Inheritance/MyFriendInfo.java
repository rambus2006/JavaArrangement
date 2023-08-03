package _19PerformTest._01Inheritance;


import java.util.Scanner;

public class MyFriendInfo {
    public String name;
    public int age;
   MyFriendInfo(String name, int age){
       name = this.name;
       age = this.age;
   }
}
class MyFriendDetailInfo extends MyFriendInfo{
    public String address;
    public String Phone;
    MyFriendDetailInfo(String name,int age,String address,String phone){
        super(name,age);
        name=this.name;
        age = this.age;
        address= this.address;
        phone = this.Phone;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String name=null;
        int age=0;
        String address=null;
        String phone=null;

        MyFriendDetailInfo mf = new MyFriendDetailInfo(name,age,address,phone);
        System.out.print("이름 : ");
         name= sc.next();

        System.out.print("나이 : ");
         age = sc.nextInt();

        System.out.print("주소 : ");
         address = sc.next();

        System.out.print("전화 : ");
         phone = sc.next();



    }
}