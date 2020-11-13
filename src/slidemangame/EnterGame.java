package slidemangame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnterGame extends JPanel{
    private ImageIcon wallpaper = new ImageIcon(this.getClass().getResource("wallpaper.jpg"));
    private ImageIcon imageunder = new ImageIcon(this.getClass().getResource("underfloor.png"));
    private ImageIcon slideman = new ImageIcon(this.getClass().getResource("c1.gif"));
    private ImageIcon girl = new ImageIcon(this.getClass().getResource("girl.png"));
    private ImageIcon boss = new ImageIcon(this.getClass().getResource("boss.png"));
    private ImageIcon srus1 = new ImageIcon(this.getClass().getResource("srus.png"));
    private ImageIcon srus2 = new ImageIcon(this.getClass().getResource("srus.png"));
    private ImageIcon imagelogo = new ImageIcon(this.getClass().getResource("logointroplay.png"));
    private ImageIcon starts = new ImageIcon(this.getClass().getResource("playbutton.png"));
    private ImageIcon howtoplaybutton = new ImageIcon(this.getClass().getResource("howtoplaybutton.png"));
    private ImageIcon messageboss = new ImageIcon(this.getClass().getResource("messageboss.gif"));
    public JButton StartGame = new JButton(starts);
    public JButton Teachplay = new JButton(howtoplaybutton);
    
    EnterGame(){
        setLayout(null);
        StartGame.setBounds(450, 400, 284, 58);
        StartGame.setBorderPainted(false);
        StartGame.setBorder(null);
        StartGame.setOpaque(false);
        StartGame.setContentAreaFilled(false);
        add(StartGame);
        
        Teachplay.setBounds(450, 480, 284, 58); 
        Teachplay.setForeground(Color.ORANGE);
        Font ButtonHowtoplay = new Font(Teachplay.getFont().getName(),Teachplay.getFont().getStyle(),20); 
        Teachplay.setFont(ButtonHowtoplay);
        Teachplay.setBorderPainted(false);
        Teachplay.setBorder(null);
        Teachplay.setOpaque(false);
        Teachplay.setContentAreaFilled(false);
        add(Teachplay);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(wallpaper.getImage(), 0, 0, 1200, 665, this);
        g.drawImage(slideman.getImage(), 50, 558, 80, 80, this);
        g.drawImage(girl.getImage(), 1000, 578, 50, 60, this);
        g.drawImage(srus2.getImage(), 825, 572, 55, 65, this);
        g.drawImage(srus1.getImage(), 850, 572, 55, 65, this);
        g.drawImage(boss.getImage(), 800, 572, 55, 65, this);
        g.drawImage(messageboss.getImage(), 780, 450, 150, 150, this);
        g.drawImage(imageunder.getImage(), 0, -30, 1200, 710, this);
        g.drawImage(imagelogo.getImage(), 0, 0, 1200, 665, this);
    }
}
