package slidemangame;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Srus2 {
    public ImageIcon imb = new ImageIcon(this.getClass().getResource("srus.png"));
    public ImageIcon im = new ImageIcon(this.getClass().getResource("srusback.png"));
    public int x = 0;
    public int y = 260;
    public int hp = 100;
    public boolean alive = true;
    public int distanceP;
    public boolean back = false;
    
    Srus2(){
        
    }
}
