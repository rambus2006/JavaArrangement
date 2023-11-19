//package Tetris;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.BorderLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import static java.awt.Font.BOLD;
//
//
//public class Screen extends JFrame{
//    JFrame f1 = new JFrame("score");
//    JPanel p1 = new JPanel();
//
//
//    JPanel btn_Pannel = new JPanel();
//    JLabel lb_title = new JLabel("Tetris");
//
//    JButton Howtoplaybtn = new JButton("How to play");
//    JButton playbtn = new JButton("PLAY");
//    JButton Rankbtn = new JButton("Rank");
//
//
//
//    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//    Dimension frameSize = f1.getSize();
//    Dimension panelSize = p1.getSize();
//    double width = screenSize.getWidth();
//    double height = screenSize.getHeight();
//
//
////    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
////    int width = gd.getDisplayMode().getWidth();
////    int height = gd.getDisplayMode().getHeight();
//
//    p(){
//        f1.setTitle("score");
//        //Location check!
//        f1.setLocation((int)(screenSize.width-frameSize.width)/2,(int)(screenSize.height-frameSize.height)/2);
//        f1.setSize(1200,1200);
//        f1.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        f1.setVisible(true);
//        f1.setLayout(null);
//        f1.add(p1);
//
//        p1.setBounds(0,0,1200,1200);
//        p1.setLayout(new BorderLayout());
//
//
//        //title
//        lb_title.setOpaque(true);
//        lb_title.setForeground(Color.cyan);
//        lb_title.setFont(new Font("serif", Font.BOLD,80));
//        lb_title.setHorizontalAlignment(JLabel.CENTER);
//        p1.add(lb_title,BorderLayout.NORTH);
//
//        //button pannel
//        btn_Pannel.setBounds(0,1000,(int)(panelSize.width+width)/2,(int)(panelSize.height+height)/2);
//        btn_Pannel.setLayout(new FlowLayout(FlowLayout.CENTER));
//
//        //button1 : how to play
//        Howtoplaybtn.setBounds(10,panelSize.height/2,40,40);
//
//        btn_Pannel.add(Howtoplaybtn);
//
//        //button2: play
//        playbtn.setBounds(panelSize.width/2,10,40,40);
//        btn_Pannel.add(playbtn);
//        playbtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new Tetris();
//            }
//        });
////        p1.add(selectbtn);
//
//        //button3 : Rank
//        Rankbtn.setSize(20,20);
//        btn_Pannel.add(Rankbtn);
//        Rankbtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                score score = new score();
//            }
//        });
//        p1.add(btn_Pannel,BorderLayout.CENTER);
//
//
//
//    }
//
//
//
//}
