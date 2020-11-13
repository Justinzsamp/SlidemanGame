package slidemangame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SlidemanGame extends JFrame implements ActionListener{
        
    EnterGame entergame = new EnterGame();
    Level1 levelone = new Level1();
    Level2 leveltwo = new Level2();
    Level3 levelthree = new Level3();
    howtoplay htp = new howtoplay();
    SoundEffect sound = new SoundEffect();
    
    public int score;
    
    public SlidemanGame(){
        this.setSize(1200,700);
        this.add(entergame);
        sound.FileName = "musiclobby.wav";
        sound.sound();
        entergame.requestFocusInWindow();
        entergame.StartGame.addActionListener(this);
        entergame.Teachplay.addActionListener(this);
        levelone.NextLevel.addActionListener(this);
        leveltwo.NextLevel.addActionListener(this);
        htp.backtoentergame.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == entergame.StartGame){
            this.setLocationRelativeTo(null);
            this.remove(entergame);
            sound.stop();
            this.setSize(1200,700);
            this.setTitle("Slide Man Level 1");
            this.add(levelone);
            levelone.times = 100;
            levelone.alive = 3;
            levelone.score = 0;
            levelone.requestFocusInWindow();
        }
        else if(e.getSource() == htp.backtoentergame){
            this.setLocationRelativeTo(null);
            this.remove(htp);
            this.setSize(1200,700);
            this.setTitle("Slideman Game");
            this.add(entergame);
            entergame.requestFocusInWindow();
        }
        else if(e.getSource() == entergame.Teachplay){
            this.setLocationRelativeTo(null);
            this.remove(entergame);
            this.setSize(1200,700);
            this.setTitle("How to play for Slide man Game");
            this.add(htp);
            htp.requestFocusInWindow();
        }
        else if(e.getSource() == levelone.NextLevel){
            this.setLocationRelativeTo(null);
            this.remove(levelone);
            this.setSize(1200,700);
            this.setTitle("Slide Man Level 2");
            this.add(leveltwo);
            leveltwo.times = 100;
            leveltwo.alive = 3;
            leveltwo.score = levelone.score;
            leveltwo.requestFocusInWindow();
        }
        else if(e.getSource() == leveltwo.NextLevel){
            this.setLocationRelativeTo(null);
            this.remove(leveltwo);
            this.setSize(1200,700);
            this.setTitle("Slide Man Boss");
            this.add(levelthree);
            levelthree.times = 100;
            levelthree.alive = 3;
            levelthree.score = leveltwo.score;
            levelthree.requestFocusInWindow();
        }
        this.validate();
        this.repaint();
    }
    
    public static void main(String[] args) {
        JFrame jf = new SlidemanGame();
        jf.setSize(1200, 700);
        jf.setTitle("Slideman Game");
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
    }  
}

