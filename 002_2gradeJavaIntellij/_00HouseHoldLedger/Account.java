package _00HouseHoldLedger;

import java.util.Scanner;
/*은행계좌를 정의하고 테스트하는 프로그램을 작성하라
 * 은행계좌번호의 잔액으로 게좌 객체를 생성
 * 입금하는 deposit()메서드
 * 출금하는 withdraw()메서드, 잔액이 부족하면 출금X -> 적당한 메세지 출력
 * 계좌의 현재 상태를 출력하는 메서드
 *  연간 이자를 2%로 설정하라      //모든 고객(인스턴스 객체)가 공유 -> static
 * 정기예탁 메서드(fixedDeposit)를 작성하고
 * 기간(년)과 금액을 입력하면 이자를 더한 입금을 계산하라
 * */
class Account extends Object {      //모든 클래스는 오브젝트를 상속받음
    private String number;
    private int balance;
    int annual;
    static double annual_interest = 0.02;

    public Account() {}

    public Account(String number, int balance) {
        this.number = number;
        this.balance = balance;
    }
    //getter, setter

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }


    public void deposit(int money) {
        balance += money;
    }
    public void withdraw(int money) {
        if (balance < money) {
            System.out.println("잔액이 부족합니다.");
        }else {
            balance -= money;
        }
    }
    public void printNow() {
        System.out.println("계좌의 현재 잔액은 : " + balance + " 입니다.");
    }

    public int fixedDeposit(int annual, int amount) {
        return (int) (annual * annual_interest * amount + balance);
    }
}
/*
class AccountTest {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int select=0;


        System.out.print("계좌번호를 입력하시오 : ");
        String number = scan.next();
        System.out.print("초기 잔액을 입력하시오 : ");
        int balance = scan.nextInt();
        Account a1 = new Account(number, balance);




        while(true) {

            System.out.println("-------메뉴-------");
            System.out.println("1. 입금" + "\n" + "2. 출금" + "\n" + "3. 계좌상태" + "\n" + "4. 정기예탁");
            System.out.print("번호를 입력하십시오 : ");
            select = scan.nextInt();

            switch (select) {
                case 1 :
                    System.out.print("입금 금액을 입력하시오 : ");
                    int money = scan.nextInt();
                    a1.deposit(money);
                    break;

                case 2 :
                    System.out.print("출금 금액을 입력하시오 : ");
                    money = scan.nextInt();
                    a1.withdraw(money);
                    break;

                case 3 :
                    a1.printNow();
                    break;

                case 4 :
                    System.out.print("기간과 금액을 입력하십시오");
                    int annual = scan.nextInt();
                    int amount = scan.nextInt();
                    System.out.println(annual + "년 이후의 돈 : " + a1.fixedDeposit(annual, amount));
            }
        }

    }

}*/
