package slidemangame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOver extends JPanel{
    
    private ImageIcon wallpaper = new ImageIcon(this.getClass().getResource("wallpaper.jpg"));
    public JButton ReGame = new JButton();
    
    
    GameOver(){
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(wallpaper.getImage(), 0, 0, 1200, 665, this);
    }
    
}
