package slidemangame;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Boss {
    public ImageIcon im = new ImageIcon(this.getClass().getResource("boss.png"));
    public ImageIcon imb = new ImageIcon(this.getClass().getResource("bossback.png"));
    public int x = 0;
    public int y = 90;
    public int count = 0;
    public boolean alive = true;
    int distanceP;
    public boolean back = false;
    public int health = 200;
    Boss(){
        
    }
}
