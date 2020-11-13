package slidemangame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.geom.Rectangle2D;
public class Level3 extends JPanel implements ActionListener{

    private ImageIcon wallpaper = new ImageIcon(this.getClass().getResource("walllevelboss.jpg"));
    private final ImageIcon wallpaperwin = new ImageIcon(this.getClass().getResource("winboss.gif"));
    private final ImageIcon wallpaperlose = new ImageIcon(this.getClass().getResource("walllose.gif"));
    private ImageIcon slideman = new ImageIcon(this.getClass().getResource("c1.gif"));
    private ImageIcon slidemanbackstep = new ImageIcon(this.getClass().getResource("c1backstep.gif"));
    private ImageIcon underfloor = new ImageIcon(this.getClass().getResource("underfloor.png"));
    private ImageIcon sword = new ImageIcon(this.getClass().getResource("sword.png"));
    private ImageIcon swordslideman = new ImageIcon(this.getClass().getResource("swordslideman.png"));
    private ImageIcon swordslidemanat = new ImageIcon(this.getClass().getResource("swordslidemanattack.png"));
    private ImageIcon swordslidemanback = new ImageIcon(this.getClass().getResource("swordslidemanback.png"));
    private ImageIcon swordslidemanbackat = new ImageIcon(this.getClass().getResource("swordslidemanbackattack.png"));
    
    private ImageIcon floor1 = new ImageIcon(this.getClass().getResource("floor1.png"));
    private ImageIcon floor2 = new ImageIcon(this.getClass().getResource("floor1.png"));
    private ImageIcon floor3 = new ImageIcon(this.getClass().getResource("floor1.png"));
    
    private ImageIcon Girl = new ImageIcon(this.getClass().getResource("girl.png"));
    
    private ImageIcon heart = new ImageIcon(this.getClass().getResource("heart.png"));
    
    public boolean heartpickup = false;
    public int heartx = 1100;
    
    Slideman charslideman = new Slideman();
    Boss boss = new Boss();
    SoundEffect sound = new SoundEffect();
    
    boolean timestart = true;
    
    int checkbacktofront = 0;
    boolean checkpickupsword = false;
    public int checknearsrus = 0;
    public int times;
    public int score;
    public int alive;
    public int checkattack;
    boolean checknextlevel = false;
    boolean checkendgame = false;
    
    public int damage = 10;
    
    private Timer timer = new Timer(40, new Listener());
 
    private Timer timercount = new Timer(1000, new Listener());
    
    Thread time = new Thread(new Runnable(){
        public void run(){
            while(true){
                try{                          
      
                    if(checkendgame == false){
                    
                        if(charslideman.walk == 1100 && charslideman.checkfloor == 3 && boss.alive == false){
                            checknextlevel = true;
                        }

                        if(charslideman.walk == heartx && heartpickup == false && charslideman.checkfloor == 1 && alive < 3){
                            heartpickup = true;
                            alive += 1;
                        }

                        //Boss
                        if(boss.alive == true){
                            if(boss.back == false){
                                if(boss.x<=0) boss.x=1000;
                                else boss.x= boss.x-5;
                            }
                            else{
                                if(boss.x<=0) boss.x=1000;
                                else boss.x= boss.x+5;
                            }
                            boss.distanceP = (int)Math.sqrt((Math.pow(Math.abs(boss.x-charslideman.walk),2))+(Math.pow(Math.abs(boss.y-charslideman.walky),2)));

                            if(charslideman.checkfloor == 3){
                               if(boss.distanceP <= 70){
                                   if(checkbacktofront == 0 && charslideman.walk < boss.x)
                                        checknearsrus = 1;
                                   
                                   if(checkbacktofront == 1 && charslideman.walk > boss.x)
                                        checknearsrus = 1;
                                }
                                else{
                                    checknearsrus = 0;
                                } 
                            }   

                            if(checkbacktofront == 0){

                                if(boss.distanceP <= 30){
                                    boss.x = charslideman.walk+100;
                                    alive-=1;
                                    sound.FileName = "damage.wav";
                                    sound.sound();
                                }
                            }
                            else if(checkbacktofront == 1){

                                if(boss.distanceP <= 30){
                                    boss.x = charslideman.walk-100;
                                    alive-=1;
                                    sound.FileName = "damage.wav";
                                    sound.sound();
                                }
                            }


                            if(boss.x <= 500){
                                boss.back = true;
                            }
                            else if(boss.x >= 1000){
                                boss.back = false;
                            }

                        } 
                        Thread.sleep(100);
                    }
                    
                }catch(Exception e){
                 
                }
                
                if(timestart == false){
                    repaint();
                }
            }
        }
    });
    
    Level3(){
        this.setFocusable(true);
        this.setLayout(null);
        
        this.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                int a = e.getKeyCode();
                if(checknextlevel == false){
                    if(a == KeyEvent.VK_D){

                        checkbacktofront = 0;
                        if(checkbacktofront == 0){
                            if(charslideman.walk >= 1100){
                                charslideman.walk = 1100;
                            }
                            else{

                                if(charslideman.checkfloor == 2){
                                    if(charslideman.walk >= 630)
                                        charslideman.walk = 630;
                                }

                                charslideman.walk+=10;
                                charslideman.count++;

                                if(charslideman.count >= 2){
                                    charslideman.count = 0;
                                }
                            }
                        }
                    }
                    else if(a == KeyEvent.VK_A){
                        checkbacktofront = 1;
                        if(checkbacktofront == 1){
                            if(charslideman.walk <= 0){
                                charslideman.walk = 0;
                            }
                            else{

                                if(charslideman.checkfloor == 1){
                                    if(charslideman.walk <= 290)
                                        charslideman.walk = 290;
                                }
                                else if(charslideman.checkfloor == 3){
                                    if(charslideman.walk <= 290)
                                        charslideman.walk = 290;
                                }

                                charslideman.walk-=10;
                                charslideman.count++;

                                if(charslideman.count >= 2){
                                    charslideman.count = 0;
                                }
                            }
                        }
                    }
                    else if(a == KeyEvent.VK_W){
                        if(charslideman.checkfloor == 0){
                            if(charslideman.walk >= 290){
                                charslideman.checkfloor = 1;
                                charslideman.walky -= 136;
                            }
                        }
                        else if(charslideman.checkfloor == 1){
                            if(charslideman.walk <= 620){
                                charslideman.checkfloor = 2;
                                charslideman.walky -= 170;
                            }
                        }
                        else if(charslideman.checkfloor == 2){
                            if(charslideman.walk >= 290){
                                charslideman.checkfloor = 3;
                                charslideman.walky -= 170;
                            }
                        }
                    }
                    else if(a == KeyEvent.VK_S){
                        if(charslideman.checkfloor == 1){
                            if(charslideman.walk >= 290){
                                charslideman.checkfloor = 0;
                                charslideman.walky = 558;
                            }
                        }
                        else if(charslideman.checkfloor == 2){
                            if(charslideman.walk >= 290){
                                charslideman.checkfloor = 1;
                                charslideman.walky = 420;
                            }
                        }
                        else if(charslideman.checkfloor == 3){
                            if(charslideman.walk <= 630){
                                charslideman.checkfloor = 2;
                                charslideman.walky = 250;
                            }
                        }
                    }
                    else if(a == KeyEvent.VK_SPACE){
                        if(checkattack == 0 && checkpickupsword == true && checkendgame == false){
                            checkattack = 1;
                            sound.FileName = "attack.wav";
                            sound.sound();
                            
                            if(checknearsrus == 1 && checkbacktofront == 0){
                                boss.back = false;
                            }
                            if(checknearsrus == 1 && checkbacktofront == 1){
                                boss.back = true;
                            }
                        }
                    }
                }
            }
            public void keyReleased(KeyEvent e){
                charslideman.count = 0;
            }
        });
        
        timer.start();
        time.start();
        timercount.start();
    }
    
    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == timercount){
                if(checknextlevel == false)
                    times--;
            }
            repaint();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.drawImage(wallpaper.getImage(), 0, 0, 1200, 800, this);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Tahoma",Font.HANGING_BASELINE, 20));
        g.drawImage(charslideman.IconClock.getImage(), 480, 15, 50, 50, this);
        g.drawString("Time: "+times, 520, 50);
        g.drawImage(charslideman.IconCup.getImage(), 255, 20, 40, 40, this);
        g.drawString("Score: "+score, 300, 50);
        g.drawImage(charslideman.IconHeart.getImage(), 710, 27, 30, 30, this);
        g.drawString("Alive: "+alive, 750, 50);  
        
        g.drawImage(floor1.getImage(), 300, 490, 889, 59, this);
        g.drawImage(floor1.getImage(), -200, 320, 889, 59, this);
        g.drawImage(floor1.getImage(), 300, 150, 889, 59, this);
        
        
        if(heartpickup == false){
            g.drawImage(heart.getImage(), heartx, 440, 50, 50, this);
        }
            
        
        //Boss
        if(boss.alive == true)
        {
            g.setColor(Color.RED);
            g.setFont(new Font("Tahoma",Font.HANGING_BASELINE, 15));	
            g.drawString("BOSS HP: "+boss.health, boss.x-25, boss.y-10);  
            
            if(boss.back == true){
                g.drawImage(boss.imb.getImage(), boss.x, boss.y, 50, 60, this); 
            }
            else{
               g.drawImage(boss.im.getImage(), boss.x, boss.y, 50, 60, this); 
            }
        }
        
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Tahoma",Font.HANGING_BASELINE, 20));	
        g.drawString("Help me!", 1085, 70);
        g.drawImage(Girl.getImage(), 1100, 90, 45, 60, this);
        
        if(checkbacktofront == 0){
            if(charslideman.count > 0){
                g.drawImage(charslideman.im.getImage(), charslideman.walk, charslideman.walky, 70, 70, this);
            }
            else if(charslideman.count == 0){
                if(checkpickupsword == true){
                    g.drawImage(charslideman.picksword.getImage(), charslideman.walk, charslideman.walky, 70, 70, this);
                }
                else
                    g.drawImage(slideman.getImage(), charslideman.walk, charslideman.walky, 70, 70, this);
            }   
            
            if(checkpickupsword == true){
                if(checkattack == 1){
                    g.drawImage(swordslidemanat.getImage(), charslideman.walk+40, charslideman.walky+20, charslideman.swordwidth, charslideman.swordheight, this);
                    checkattack = 0;
                    if(checknearsrus == 1){
                        if(boss.health - damage <= 0){
                            score += 1000;
                            boss.alive = false;
                        }
                        else if(boss.health - damage != 0){
                            boss.health -= damage;
                        }
                        sound.FileName = "mydamage.wav";
                        sound.sound();
                        checknearsrus = 0;
                    }
                }
                else if(checkattack == 0){
                    g.drawImage(swordslideman.getImage(), charslideman.walk+22, charslideman.walky+5, charslideman.swordwidth, charslideman.swordheight, this);
                }
            }
        }
        else if(checkbacktofront == 1){
            if(charslideman.count > 0){
                g.drawImage(charslideman.imb.getImage(), charslideman.walk, charslideman.walky, 70, 70, this);
            }
            else if(charslideman.count == 0){
                if(checkpickupsword == true){
                    g.drawImage(charslideman.pickswordback.getImage(), charslideman.walk, charslideman.walky, 70, 70, this);
                }
                else
                    g.drawImage(slidemanbackstep.getImage(), charslideman.walk, charslideman.walky, 70, 70, this);
            } 
            
            if(checkpickupsword == true){
                if(checkattack == 1){
                    g.drawImage(swordslidemanbackat.getImage(), charslideman.walk-40, charslideman.walky+20, charslideman.swordwidth, charslideman.swordheight, this);
                    checkattack = 0;
                    if(checknearsrus == 1){
                        if(boss.health - damage <= 0){
                            score += 1000;
                            boss.alive = false;
                        }
                        if(boss.health - damage != 0){
                            boss.health -= damage;
                        }
                        sound.FileName = "mydamage.wav";
                        sound.sound();
                        checknearsrus = 0;
                    }
                }
                else if(checkattack == 0){
                    g.drawImage(swordslidemanback.getImage(), charslideman.walk-22, charslideman.walky+5, charslideman.swordwidth, charslideman.swordheight, this);
                }
            }
        }
        
        if(checkpickupsword == false){
            g.drawImage(sword.getImage(), 900, 560, 70, 70, this);

            if(charslideman.walk == 900 && charslideman.checkfloor == 0){
                checkpickupsword = true;
            }
        }
        
        g.drawImage(underfloor.getImage(), 0, 0, 1200, 665, this);
        
        
        if(alive <= 0 || times <= 0){
            this.setLayout(null);
            g.setColor(Color.RED);
            g.drawImage(wallpaperlose.getImage(), 0, 0, 1200, 700, this);
            g.setFont(new Font("Tahoma",Font.PLAIN,50));		
            g.drawString("Score: "+score,460,410);		     
            checkendgame = true;
            timer.stop();
            timercount.stop();
        }    
        
        if(checknextlevel == true){
            this.setLayout(null);
            g.setColor(Color.ORANGE);
            g.drawImage(wallpaperwin.getImage(), 0, 0, 1200, 700, this);
            g.setFont(new Font("Tahoma",Font.PLAIN,50));		
            g.drawString("Score: "+score,460,410);	     
            timer.stop();
            timercount.stop();
        }
    }
    
}
