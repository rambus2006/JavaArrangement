package Test_code2;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CategoriPanel extends JPanel {
    private JButton showAlbumListBtn;
    private JButton insertAlbumBtn;
    private JButton updateAlbumBtn;
    private JButton deleteAlbumBtn;
    private JButton startMusicBtn;

    public CategoriPanel() {
        setBackground(new Color(171,242,0));
        setSize(1900, 50);
        showAlbumListBtn = new JButton("음악 목록 보기");
        add(showAlbumListBtn);

        insertAlbumBtn = new JButton("음악 추가");
        add(insertAlbumBtn);

        updateAlbumBtn = new JButton("음악 수정");
        add(updateAlbumBtn);

        deleteAlbumBtn = new JButton("음악 삭제");
        add(deleteAlbumBtn);

        startMusicBtn = new JButton("음악 듣기");
        add(startMusicBtn);
    }

    public JButton getShowAlbumListBtn() {
        return showAlbumListBtn;
    }

    public JButton getInsertAlbumBtn() {
        return insertAlbumBtn;
    }

    public JButton getUpdateAlbumBtn() {
        return updateAlbumBtn;
    }

    public JButton getDeleteAlbumBtn() {
        return deleteAlbumBtn;
    }

    public JButton getStartMusicBtn(){
        return startMusicBtn;
    }

}