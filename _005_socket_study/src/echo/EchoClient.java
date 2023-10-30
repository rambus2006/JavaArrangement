package echo;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import first.Config;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(Config.SERVER_HOSTNAME, Config.SERVER_PORT);
        // 소켓 연결 완료, 이후
        // 접속한 서버로부터 메시지를 읽어와야 하므로 InputStream 얻어오기
        InputStream in = socket.getInputStream();
        // 접속한 서버로 메시지를 보내야 하므로 OutputStream 얻어오기
        OutputStream out = socket.getOutputStream();

        // 사용자 입력값을 받기위해서 Scanner가 아닌 Console 객체 활용, 밑의 명령어는 IDE에서 실행 할 경우 null을 반환함
        // https://stackoverflow.com/questions/40754284/read-and-write-utf-8-characters-from-system-in-stream
        Console console = System.console();
        byte[] messageBuffer = new byte[65535];
        while(true) {
            String line = console.readLine(" > ");
            // 입력받은 내용이 "/quit"이면 통신 종료
            if(line.trim().equals("/quit")) break;
            // 아니라면
            byte[] stringBytes = line.getBytes(StandardCharsets.UTF_8);
            System.out.println(line);
            System.out.println(Arrays.toString(stringBytes));
            // 입력받은 문자열 바이트로 변환 후 서버로 전달
            out.write(stringBytes);
            out.flush();
            // 이후 서버에서 되돌려 받은 문자열 읽어와서 출력
            int count = in.read(messageBuffer);
            String input = new String(messageBuffer, 0, count, "UTF-8");
            System.out.println("echo from server : " + input);
        }
        socket.close();
    }
}
