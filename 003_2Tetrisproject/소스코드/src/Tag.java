import java.io.File;

import javax.sound.sampled.UnsupportedAudioFileException;

import javazoom.jlgui.player.amp.tag.MpegInfo;

//<--태그 매니저-->

/**
 * 음악파일의 태그정보(가수명, 제목, 장르...)를 가져오는 기능을 합니다.
 * <br> 우리의 프로그램은 제목과 가수이름만을 가져오면 됩니다.
 * <br> wav 파일은 tag를 지원하지 않기 때문에 제목은 파일명에서 포맷을 뗀 것이고 
 * <br> 가수의 이름은 Various Artists 로 출력하도록 만들었습니다.
 * 
 * @author changhee, yunki
 */
public class Tag {
	//태그 매니저를 초기화 합니다.
	MpegInfo tags;
	//재생할 파일의 경로를 가져와서 태그 매니저에게 건내줄 예정입니다.
	File audioFile;

	public Tag(File audioFile) {
		this.audioFile = audioFile;
	}

	// mp3 파일의 경우 태그 매니저(tag_info)가 태그 정보를 가져와서 제목과 가수명을 갱신합니다.
	public void getTags() {
		MpegInfo tags = new MpegInfo();
		try {
			tags.load(audioFile);
			String title = new String(tags.getTitle());
			String artist = new String(tags.getArtist());
			MainFrame.updateTag(title, artist);
		}

		// 태그는 mp3 만 됩니다. 따라서 wav 파일의 경우에는 String 객체의 메소드를 사용하여 제목과 가수명을 갱신합니다. 
		catch( UnsupportedAudioFileException e ) {
			String title = audioFile.getName().split(".wav")[0];
			MainFrame.updateTag(title, "Various Artists");
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
}