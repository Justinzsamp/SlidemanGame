package slidemangame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class Slideman {
    public ImageIcon im = new ImageIcon(this.getClass().getResource("1.png"));
    public ImageIcon imb = new ImageIcon(this.getClass().getResource("back1.png"));
    public ImageIcon picksword = new ImageIcon(this.getClass().getResource("c1picksword.png"));
    public ImageIcon pickswordback = new ImageIcon(this.getClass().getResource("c1pickswordback.png"));
    public ImageIcon IconHeart = new ImageIcon(this.getClass(). getResource("heart.png"));
    public ImageIcon IconClock = new ImageIcon(this.getClass(). getResource("clock.png"));
    public ImageIcon IconCup = new ImageIcon(this.getClass(). getResource("cup.png"));
    public int swordwidth = 65;
    public int swordheight = 65;
    public int walk = 0;
    public int walky = 556;
    public int count = 0;
    public int swordx = 100;
    public int swordy = 100;
    public int checkfloor = 0;
    Slideman(){
      
    }
}
