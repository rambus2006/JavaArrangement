package _00HouseHoldLedgerPJ.Gui;
/*
import java.awt.*;
import javax.swing.*;
import java.util.Scanner;
public class User {
    //필드
    private String id;
    private String pw;
    private String nickname;

    //기본 생성자
    User(){}
    User(String id,String pw,String nickname){
        this.id=id;
        this.pw=pw;
        this.nickname=nickname;
    }
    //getter,setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    protected Component UserMain() {
        return null;
    }
}

class LoginApplication {
    private static int usernum = 0;
    private static _00HouseHoldLedgerPJ.Gui.User user[] = new _00HouseHoldLedgerPJ.Gui.User[10];
    private static Scanner scanner = new Scanner(System.in);
    private static String inputId, inputPassword, inputNickname;
    static int loginSuccess = 0;
    public static void UserMain() {
        for (int i=0;i<10;i++)
        { user[i] = new _00HouseHoldLedgerPJ.Gui.User(); } //NullpointerException방지 배열 초기화

        boolean run = true;

        do {
            System.out.println("원하는 메뉴를 숫자로 입력하여 선택하세요: ");
            System.out.println("1.회원가입 2.로그인 3.사용자조회 4.탈퇴 5.종료");
            System.out.print("선택 > ");

            int select = scanner.nextInt();
            if (select == 1){ //회원가입 선택
                if (usernum == 10) {
                    System.out.println("용량 초과 회원가입 실패");
                    break;
                }
                else
                    createAccount();
            } else if (select == 2) {    //로그인 선택
                loginAccount();
            } else if (select == 3) {    //사용자조회 선택
                lookAccount();
            } else if (select == 4) {    //탈퇴 선택
                deleteAccount();
            } else {                     //종료 선택
                run = false;
            }
        }while (run);
        System.out.println("프로그램 종료");
    }

    private static void createAccount() {    //회원가입 선택
        System.out.print("아이디를 입력하세요 : ");
        inputId = scanner.next(); user[usernum].setId(inputId);
        System.out.print("비밀번호를 입력하세요 : ");
        inputPassword = scanner.next(); user[usernum].setPw(inputPassword);
        System.out.print("닉네임을 입력하세요 : ");
        inputNickname = scanner.next(); user[usernum].setNickname(inputNickname);

        usernum++;
    }

    private static void loginAccount() {    //로그인 선택
        System.out.print("아이디를 입력하세요 : ");
        inputId = scanner.next();
        System.out.print("비밀번호를 입력하세요 : ");
        inputPassword = scanner.next();


        for (int i=0;i < user.length;i++){
            if (inputId.equals(user[i].getId())&&inputPassword.equals(user[i].getPw()))
            {
                System.out.println("로그인 성공");
                System.out.println(user[i].getNickname() + "님 환영합니다. ");
                loginSuccess = 1;
                AccountTest();
                break;
            }
        }
        if (loginSuccess == 0)
            System.out.println("로그인 실패");
    }

    private static void lookAccount() {    //사용자조회 선택
        for (_00HouseHoldLedgerPJ.Gui.User users : user) {
            if (users.getNickname() != null)
                System.out.println(users.getNickname());
        }
    }

    private static void deleteAccount() {    //탈퇴 선택
        System.out.print("아이디를 입력하세요 : ");
        inputId = scanner.next();
        System.out.print("비밀번호를 입력하세요 : ");
        inputPassword = scanner.next();
        int deleteSuccess = 0;
        for (int i=0;i < user.length;i++){
            if (inputId.equals(user[i].getId())&&inputPassword.equals(user[i].getPw()))
            {
                System.out.println("탈퇴 성공");
                user[i].setId(null); user[i].setPw(null); user[i].setNickname(null);
                deleteSuccess = 1;
            }
        }
        if (deleteSuccess == 0)
            System.out.println("일치하는 정보 없음");
    }

    private static void AccountTest(){
        int select=0;
        Scanner scan = new Scanner(System.in);
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
}
*/

