package first;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class FirstClient {
    public static void main(String[] args) throws IOException {
        System.out.println(Config.SERVER_HOSTNAME + " 호스트와 " + Config.SERVER_PORT + " 포트 번호를 사용하는 서버 프로세스로 연결 요청");
        Socket socket = new Socket(Config.SERVER_HOSTNAME, Config.SERVER_PORT);
        System.out.println("서버와 연결 완료, 이후 소켓을 통해서 서버와 통신 가능");
        InputStream is = socket.getInputStream();
        byte[] buffer = new byte[8192];
        System.out.println("서버에서 보낸 데이터 수신받기 위해서 대기 (blocking 상태로 진입)");
        int count = is.read(buffer);
        // 받은 데이터(UTF-8 인코딩으로 저장된 문자열)을 출력
        String input = new String(buffer, 0, count, "UTF-8");
        System.out.println(input);
        System.out.println("클라이언트 소켓 닫기");
        socket.close();
    }
}
