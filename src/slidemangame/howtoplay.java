package slidemangame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class howtoplay extends JPanel implements ActionListener{

    private final ImageIcon wallpaper = new ImageIcon(this.getClass().getResource("wallpaper.jpg"));
    private final ImageIcon howtoplaywall = new ImageIcon(this.getClass().getResource("howtoplay.png"));
    
    JButton backtoentergame = new JButton("Back");
    
    howtoplay(){
        setLayout(null);
        backtoentergame.setBounds(430, 550, 300, 100);
        backtoentergame.setForeground(Color.ORANGE);
        Font Buttonback = new Font(backtoentergame.getFont().getName(),backtoentergame.getFont().getStyle(),20); 
        backtoentergame.setFont(Buttonback);
        backtoentergame.setBorderPainted(false);
        backtoentergame.setBorder(null);
        backtoentergame.setOpaque(false);
        backtoentergame.setContentAreaFilled(false);
        add(backtoentergame);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.drawImage(wallpaper.getImage(), 0, 0, 1200, 800, this);
        g.drawImage(howtoplaywall.getImage(), 180, 130, 800, 400, this);
    }
    
}
