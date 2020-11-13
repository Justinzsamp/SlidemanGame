package slidemangame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Srus {
    public ImageIcon im = new ImageIcon(this.getClass().getResource("srus.png"));
    public ImageIcon imb = new ImageIcon(this.getClass().getResource("srusback.png"));
    public int x = 1100;
    public int y = 430;
    public int hp = 100;
    public boolean alive = true;
    public int distanceP;
    public boolean back = false;
    
    public Srus(){
        
    }
}
