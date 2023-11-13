package testcode;
import jdk.jfr.internal.PlatformRecording;

import javax.sound.sampled.*;
import java.io.File;

public class Bgm {

    public static void main(String[] args) {
        try{

            File file = new File("music/bgm_tetris.wav");
            System.out.println(file.getAbsolutePath());
            System.out.println(file.exists());

            // 음악 파일 로드
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();

            clip.open(audioInputStream);

            // 배경음악 반복 재생 (원하는 경우)
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            // 음악 재생 시작
            clip.start();
            while (true) {
                // 루프가 끝나지 않도록 기다림
                Thread.sleep(1000);
            }

        }catch (Exception e){
            e.printStackTrace();

        }
    }

}
