import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * 메인 프레임에 있는 파일열기 버튼(JButton)에 FileChooser 핸들러를 추가하는 클래스로
 * <br>파일을 하나만 선택하거나 또는 여러개를 선택하여 PlayList(.java) 클래스에 경로를 전달하는 기능을 합니다. 
 * 
 * @author yunki, jihun
 * @version 1.0.0
 * @since JDK 1.6
 */

public class OpenAction implements ActionListener {
	/**
	 * JFileChooser를 이용하여 파일을 받습니다.
	 */
	public void actionPerformed(ActionEvent e) {
		JFileChooser CHOOSER = new JFileChooser();
		// 1. 필터 생성
		FileNameExtensionFilter filter = new FileNameExtensionFilter ("WAV, MP3", "wav", "mp3" );
		// 2. 필터 장착
		CHOOSER.setFileFilter(filter);
		CHOOSER.setMultiSelectionEnabled(true);

		int ret = CHOOSER.showOpenDialog(null);		// 다이얼로그를 화면에 띄웁니다.
		// 3. 선택을 안 했거나 오류가 발생했을 때
		if ( ret != JFileChooser.APPROVE_OPTION ) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", 
					"경고", JOptionPane.WARNING_MESSAGE);
			return;
		}

		// 4. 선택한 파일들을 PlayList 의 벡터들에게 전달합니다.
		for (File file : CHOOSER.getSelectedFiles()) {
			PlayList.add(file.getPath());
		}
	}
}
