package first;

import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class FirstServer {
    public static void main(String[] args) throws IOException {
        //서버 프로그램 만들기
        System.out.println(Config.SERVER_PORT + "를 포트 번호로 사용하여 서버 소켓 생성");
        //1. (리스닝 소켓) : 자기 자신의 ip와
        ServerSocket server = new ServerSocket(Config.SERVER_PORT);

        System.out.println("accept 메서드 호출하고 동시에 blocking 상태로 진입");
        //2. accept 메소드 호출: 클라이언트의 요청을 받을 때만 메인스레드가 실행되면 되기 떄문에 blocking 상태(자신이 스레드를 쓰지 않을 때 다른 스레드에 양보)로 되어 있음
        Socket client = server.accept(); //Socket : 연결을 받아서 소켓을
        System.out.println("클라이언트와 연결 완료하여 소켓 생성, 이후 해당 소켓을 이용하여 통신 가능");
        OutputStream out = client.getOutputStream(); //직접적인 통신을 한다. (바이너리 데이터)
        System.out.println("클라이언트로 문자열 데이터 전송");
        out.write("Hello".getBytes(StandardCharsets.UTF_8)); //Hello를 바이트데이터로 바꾼다.
        out.flush();
        System.out.println("클라이언트 소켓, 서버 소켓 닫기");
        client.close(); //클라이언트의 연결을 먼저 닫음
        server.close(); //서버의 연결을 먼저 닫음 (24시간 편의점)

    }
}
