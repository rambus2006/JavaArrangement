package Test_code2;

// 패키지


// 필요한 기능들 import
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class SoundTechnical extends JFrame{
    // JFrame에 필요한 변수 선언
    static JFrame frame = new JFrame();
    static JButton go = new JButton("재생");
    static JButton stop = new JButton("취소");

    // 음악 실행에 필요한 변수 선언
    static InputStream IN;
    static AudioStream BGM;
    static AudioPlayer MGP = AudioPlayer.player;

    public static void main(String[] args) {

// 레이아웃 설정 및 이벤트 링크
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(go);
        frame.add(stop);
        frame.show(true);
        go.addActionListener(new AL());
        stop.addActionListener(new AL());

// 음악 설정
        try
        {
            IN = SoundTechnical.class.getResourceAsStream("/bgm/Night Market.wav");
            BGM = new AudioStream(IN);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    // 버튼 이벤트 처리
    public static class AL implements ActionListener{
        public final void actionPerformed(ActionEvent e) {
            if(e.getSource() == go)
                MGP.start(BGM);
            else if(e.getSource() == stop)
                MGP.stop(BGM);
        }
    }
}
