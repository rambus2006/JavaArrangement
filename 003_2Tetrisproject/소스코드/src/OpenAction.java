import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * ���� �����ӿ� �ִ� ���Ͽ��� ��ư(JButton)�� FileChooser �ڵ鷯�� �߰��ϴ� Ŭ������
 * <br>������ �ϳ��� �����ϰų� �Ǵ� �������� �����Ͽ� PlayList(.java) Ŭ������ ��θ� �����ϴ� ����� �մϴ�. 
 * 
 * @author yunki, jihun
 * @version 1.0.0
 * @since JDK 1.6
 */

public class OpenAction implements ActionListener {
	/**
	 * JFileChooser�� �̿��Ͽ� ������ �޽��ϴ�.
	 */
	public void actionPerformed(ActionEvent e) {
		JFileChooser CHOOSER = new JFileChooser();
		// 1. ���� ����
		FileNameExtensionFilter filter = new FileNameExtensionFilter ("WAV, MP3", "wav", "mp3" );
		// 2. ���� ����
		CHOOSER.setFileFilter(filter);
		CHOOSER.setMultiSelectionEnabled(true);

		int ret = CHOOSER.showOpenDialog(null);		// ���̾�α׸� ȭ�鿡 ���ϴ�.
		// 3. ������ �� �߰ų� ������ �߻����� ��
		if ( ret != JFileChooser.APPROVE_OPTION ) {
			JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�.", 
					"���", JOptionPane.WARNING_MESSAGE);
			return;
		}

		// 4. ������ ���ϵ��� PlayList �� ���͵鿡�� �����մϴ�.
		for (File file : CHOOSER.getSelectedFiles()) {
			PlayList.add(file.getPath());
		}
	}
}
