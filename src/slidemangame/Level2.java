
package slidemangame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Level2 extends JPanel implements ActionListener{

    private final ImageIcon wallpaper = new ImageIcon(this.getClass().getResource("walllevel2.jpg"));
    private final ImageIcon wallpaperwin = new ImageIcon(this.getClass().getResource("wallwin.gif"));
    private final ImageIcon wallpaperlose = new ImageIcon(this.getClass().getResource("walllose.gif"));
    private final ImageIcon slideman = new ImageIcon(this.getClass().getResource("c1.gif"));
    private final ImageIcon slidemanbackstep = new ImageIcon(this.getClass().getResource("c1backstep.gif"));
    private final ImageIcon underfloor = new ImageIcon(this.getClass().getResource("underfloor.png"));
    private final ImageIcon sword = new ImageIcon(this.getClass().getResource("sword.png"));
    private final ImageIcon swordslideman = new ImageIcon(this.getClass().getResource("swordslideman.png"));
    private final ImageIcon swordslidemanat = new ImageIcon(this.getClass().getResource("swordslidemanattack.png"));
    private final ImageIcon swordslidemanback = new ImageIcon(this.getClass().getResource("swordslidemanback.png"));
    private final ImageIcon swordslidemanbackat = new ImageIcon(this.getClass().getResource("swordslidemanbackattack.png"));
    
    private final ImageIcon floor1 = new ImageIcon(this.getClass().getResource("floor1.png"));
    private final ImageIcon floor2 = new ImageIcon(this.getClass().getResource("floor1.png"));
    private final ImageIcon floor3 = new ImageIcon(this.getClass().getResource("floor1.png"));
    
    private final ImageIcon door = new ImageIcon(this.getClass().getResource("door.png"));
    
    private final ImageIcon nextlevelimg = new ImageIcon(this.getClass().getResource("nextlevel.png"));
    
    public JButton NextLevel = new JButton(nextlevelimg);
    
    Slideman charslideman = new Slideman();
    Srus sruschar = new Srus();
    Srus2 sruschar2 = new Srus2();
    Srus3 sruschar3 = new Srus3();
    SoundEffect sound = new SoundEffect();
    
    int checkbacktofront = 0;
    boolean checkpickupsword = false;
    public int checknearsrus = 0;
    public int times;
    public int score;
    public int alive;
    public int checkattack;
    boolean checknextlevel = false;
    public int damage = 50;
    public boolean checkendgame = false;
    
    boolean timestart = true;
    
    private final Timer timer = new Timer(40, new Listener());
 
    private final Timer timercount = new Timer(1000, new Listener());
    
    GameOver gameover = new GameOver();
   
    Thread time = new Thread(new Runnable(){
        @Override
        public void run(){
            while(true){
                try{                          
                    if(checkendgame == false){
                        if(charslideman.walk == 10 && charslideman.checkfloor == 2 && sruschar.alive == false && sruschar2.alive == false && sruschar3.alive == false){
                            checknextlevel = true;
                        }

                        //Srus1
                        if(sruschar.alive == true){
                            if(sruschar.back == false){
                                if(sruschar.x<=0) sruschar.x=1000;
                                else sruschar.x= sruschar.x-5;
                            }
                            else{
                                if(sruschar.x<=0) sruschar.x=1000;
                                else sruschar.x= sruschar.x+5;
                            }
                            sruschar.distanceP = (int)Math.sqrt((Math.pow(Math.abs(sruschar.x-charslideman.walk),2))+(Math.pow(Math.abs(sruschar.y-charslideman.walky),2)));

                            if(charslideman.checkfloor == 1){
                               if(sruschar.distanceP <= 70){
                                    checknearsrus = 1;
                                }
                                else{
                                    checknearsrus = 0;
                                } 
                            }   

                            if(checkbacktofront == 0){

                                if(sruschar.distanceP <= 30){
                                    sruschar.x = charslideman.walk+100;
                                    alive-=1;
                                    sound.FileName = "damage.wav";
                                    sound.sound();
                                }
                            }
                            else if(checkbacktofront == 1){

                                if(sruschar.distanceP <= 30){
                                    sruschar.x = charslideman.walk-100;
                                    alive-=1;
                                    sound.FileName = "damage.wav";
                                    sound.sound();
                                }
                            }


                            if(sruschar.x <= 500){
                                sruschar.back = true;
                            }
                            else if(sruschar.x >= 1100){
                                sruschar.back = false;
                            }

                        } 

                        //Srus2
                        if(sruschar2.alive == true){
                            if(sruschar2.back == false){
                                if(sruschar2.x >= 0) 
                                    sruschar2.x= sruschar2.x+5;
                            }
                            else{
                                if(sruschar2.x <= 550)
                                    sruschar2.x= sruschar2.x-5;
                            }

                            sruschar2.distanceP = (int)Math.sqrt((Math.pow(Math.abs(sruschar2.x-charslideman.walk),2))+(Math.pow(Math.abs(sruschar2.y-charslideman.walky),2)));

                            if(charslideman.checkfloor == 2){
                                if(sruschar2.distanceP <= 70){
                                    checknearsrus = 2;
                                }
                                else{
                                    checknearsrus = 0;
                                }
                            }

                            if(checkbacktofront == 0){

                                if(sruschar2.distanceP <= 30){
                                    sruschar2.x = charslideman.walk+100;
                                    alive-=1;
                                    sound.FileName = "damage.wav";
                                    sound.sound();
                                }
                            }
                            else if(checkbacktofront == 1){

                                if(sruschar2.distanceP <= 30){
                                    sruschar2.x = charslideman.walk-100;
                                    alive-=1;
                                    sound.FileName = "damage.wav";
                                    sound.sound();
                                }
                            }


                            if(sruschar2.x >= 550){
                                sruschar2.back = true;
                            }
                            else if(sruschar2.x <= 0){
                                sruschar2.back = false;
                            }

                        } 

                        //Srus3
                        if(sruschar3.alive == true){
                            if(sruschar3.back == false){
                                if(sruschar3.x<=0) sruschar3.x=1000;
                                else sruschar3.x= sruschar3.x-5;
                            }
                            else{
                                if(sruschar3.x<=0) sruschar3.x=1000;
                                else sruschar3.x= sruschar3.x+5;
                            }
                            sruschar3.distanceP = (int)Math.sqrt((Math.pow(Math.abs(sruschar3.x-charslideman.walk),2))+(Math.pow(Math.abs(sruschar3.y-charslideman.walky),2)));

                            if(charslideman.checkfloor == 3){
                               if(sruschar3.distanceP <= 70){
                                    checknearsrus = 3;
                                }
                                else{
                                    checknearsrus = 0;
                                } 
                            }   

                            if(checkbacktofront == 0){

                                if(sruschar3.distanceP <= 30){
                                    sruschar3.x = charslideman.walk+100;
                                    alive-=1;
                                    sound.FileName = "damage.wav";
                                    sound.sound();
                                }
                            }
                            else if(checkbacktofront == 1){

                                if(sruschar3.distanceP <= 30){
                                    sruschar3.x = charslideman.walk-100;
                                    alive-=1;
                                    sound.FileName = "damage.wav";
                                    sound.sound();
                                }
                            }


                            if(sruschar3.x <= 300){
                                sruschar3.back = true;
                            }
                            else if(sruschar3.x >= 900){
                                sruschar3.back = false;
                            }

                        }

                        Thread.sleep(20);
                    }
                    
                }catch(Exception e){
                 
                }
                
                if(timestart == false){
                    repaint();
                }
            }
        }
    });

    
    Level2(){
        this.setFocusable(true);
        this.setLayout(null);
        
        this.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                int a = e.getKeyCode();
       
                if(checknextlevel == false){
                    switch (a) {
                        case KeyEvent.VK_D:
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
                            }   break;
                        case KeyEvent.VK_A:
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
                            }   break;
                        case KeyEvent.VK_W:
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
                            }   break;
                        case KeyEvent.VK_S:
                            if(charslideman.checkfloor == 1){
                                if(charslideman.walk >= 290){
                                    charslideman.checkfloor = 0;
                                    charslideman.walky = 556;
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
                            }   break;
                        case KeyEvent.VK_SPACE:
                            if(checkattack == 0 && checkpickupsword == true && checkendgame == false){
                                checkattack = 1;
                                sound.FileName = "attack.wav";
                                sound.sound();
                            }   break;
                        default:
                            break;
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
        repaint();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.drawImage(wallpaper.getImage(), 0, 0, 1200, 800, this);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE, 20));	
        g.drawImage(charslideman.IconClock.getImage(), 480, 15, 50, 50, this);
        g.drawString("Time: "+times, 520, 50);
        g.drawImage(charslideman.IconCup.getImage(), 255, 20, 40, 40, this);
        g.drawString("Score: "+score, 300, 50);
        g.drawImage(charslideman.IconHeart.getImage(), 710, 27, 30, 30, this);
        g.drawString("Alive: "+alive, 750, 50);  
        
        g.setColor(Color.RED);
        g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE, 16));	
        
        g.drawImage(floor1.getImage(), 300, 490, 889, 59, this);
        g.drawImage(floor1.getImage(), -200, 320, 889, 59, this);
        g.drawImage(floor1.getImage(), 300, 150, 889, 59, this);
        
        g.drawImage(door.getImage(), 10, 235, 57, 84, this);
        
        //Srus1
        if(sruschar.alive == true)
        {
            if(sruschar.back == true){
                g.drawImage(sruschar.imb.getImage(), sruschar.x, sruschar.y, 50, 60, this); 
            }
            else{
               g.drawImage(sruschar.im.getImage(), sruschar.x, sruschar.y, 50, 60, this); 
            }
            g.drawString("HP: "+sruschar.hp, sruschar.x, sruschar.y-10);  
        }
        //Srus2
        if(sruschar2.alive == true)
        {
            if(sruschar2.back == true){
                g.drawImage(sruschar2.imb.getImage(), sruschar2.x, sruschar2.y, 50, 60, this); 
            }
            else{
               g.drawImage(sruschar2.im.getImage(), sruschar2.x, sruschar2.y, 50, 60, this); 
            }
            g.drawString("HP: "+sruschar2.hp, sruschar2.x, sruschar2.y-10);
        }
        //Srus3
        if(sruschar3.alive == true)
        {
            if(sruschar3.back == true){
                g.drawImage(sruschar3.imb.getImage(), sruschar3.x, sruschar3.y, 50, 60, this); 
            }
            else{
               g.drawImage(sruschar3.im.getImage(), sruschar3.x, sruschar3.y, 50, 60, this); 
            }
            g.drawString("HP: "+sruschar3.hp, sruschar3.x, sruschar3.y-10);
        }

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
                        if(sruschar.hp - damage <= 0){
                            score+=50;
                            sruschar.alive = false;
                            checknearsrus = 0;
                        }
                        else if(sruschar.hp - damage != 0){
                            sruschar.hp -= damage;
                        }
                        sound.FileName = "mydamage.wav";
                        sound.sound();
                    }
                    else if(checknearsrus == 2){
                        if(sruschar2.hp - damage <= 0){
                            score+=50;
                            sruschar2.alive = false;
                            checknearsrus = 0;
                        }
                        else if(sruschar2.hp - damage != 0){
                            sruschar2.hp -= damage;
                        }
                        sound.FileName = "mydamage.wav";
                        sound.sound();
                    }
                    else if(checknearsrus == 3){
                        if(sruschar3.hp - damage <= 0){
                            score+=50;
                            sruschar3.alive = false;
                            checknearsrus = 0;
                        }
                        else if(sruschar3.hp - damage != 0){
                            sruschar3.hp -= damage;
                        }
                        sound.FileName = "mydamage.wav";
                        sound.sound();
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
                        if(sruschar.hp - damage <= 0){
                            score+=50;
                            sruschar.alive = false;
                            checknearsrus = 0;
                        }
                        else if(sruschar.hp - damage != 0){
                            sruschar.hp -= damage;
                        }
                        sound.FileName = "mydamage.wav";
                        sound.sound();
                    }
                    else if(checknearsrus == 2){ 
                        if(sruschar2.hp - damage <= 0){
                            score+=50;
                            sruschar2.alive = false;
                            checknearsrus = 0;
                        }
                        else if(sruschar2.hp - damage != 0){
                            sruschar2.hp -= damage;
                        }
                        sound.FileName = "mydamage.wav";
                        sound.sound();
                    }
                    else if(checknearsrus == 3){
                        if(sruschar3.hp - damage <= 0){
                            score+=50;
                            sruschar3.alive = false;
                            checknearsrus = 0;
                        }
                        else if(sruschar3.hp - damage != 0){
                            sruschar3.hp -= damage;
                        }
                        sound.FileName = "mydamage.wav";
                        sound.sound();
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
            
            NextLevel.setBounds(390, 480, 400, 100);
            NextLevel.setBorderPainted(false);
            NextLevel.setBorder(null);
            NextLevel.setOpaque(false);
            NextLevel.setContentAreaFilled(false);
            NextLevel.setForeground(Color.ORANGE);
            Font ButtonFont = new Font(NextLevel.getFont().getName(),NextLevel.getFont().getStyle(),30); 
            NextLevel.setFont(ButtonFont);
            add(NextLevel);
        }
    }

}
