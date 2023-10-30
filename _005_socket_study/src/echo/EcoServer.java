package echo;

import first.Config;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class EcoServer {
    public static void main(String[] args) throws IOException {
        //1. 서버 소켓 만들기
        ServerSocket server = new ServerSocket(Config.SERVER_PORT);
        Socket client = null;

        //2. accept : 요청 들어오기를 기다리는 메소드
        //
        while(true){
            try{
                client = server.accept();
                //서버에서 입력을 받겠다.
                InputStream in = client.getInputStream();
                //서버에서 출력을 하겠다.
                OutputStream out = client.getOutputStream();
                byte[] messageBuffer = new byte[65535];
                while(true){
                    int count = in.read(messageBuffer);
                    if(count == -1){
                        break;
                    }
                    String input = new String(messageBuffer,0,count, StandardCharsets.UTF_8);

                }
            }catch (SocketException e){
                System.out.println("socket closed : " + e.getMessage());
            }finally {
                if(client != null) client.close();
            }
        }
    }
}
