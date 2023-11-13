package Test_code2;

import javax.sound.sampled.*;
import java.io.File;

public class BackgroundMusicPlayer {
    public static void main(String[] args) {
        try {

            // File file = new File("music/bgm.mp3");
            File file = new File("music/bgm_tetris.wav");
            System.out.println(file.getAbsolutePath());
            System.out.println(file.exists());

            // 음악 파일 로드
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();

            // 오디오 포맷 및 데이터 라인 설정
//            AudioFormat format = audioInputStream.getFormat();
//            DataLine.Info info = new DataLine.Info(Clip.class, format);

            // 데이터 라인을 열고 클립을 가져옴
//            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioInputStream);

            // 배경음악 반복 재생 (원하는 경우)
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            // 음악 재생 시작
            clip.start();

            // 프로그램 종료 전까지 음악 재생을 유지
            while (true) {
                // 루프가 끝나지 않도록 기다림
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
