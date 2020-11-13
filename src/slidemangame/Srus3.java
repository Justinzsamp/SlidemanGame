package slidemangame;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Srus3 {
    public ImageIcon im = new ImageIcon(this.getClass().getResource("srus.png"));
    public ImageIcon imb = new ImageIcon(this.getClass().getResource("srusback.png"));
    public int x = 0;
    public int y = 90;
    public int hp = 100;
    public boolean alive = true;
    public int distanceP;
    public boolean back = false;
    
    Srus3(){
        
    }
}
