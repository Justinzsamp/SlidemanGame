
package slidemangame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Level1 extends JPanel implements ActionListener{

    //----------[Import Imageg]---------------------///
    private final ImageIcon wallpaper = new ImageIcon(this.getClass().getResource("wallpaper.jpg"));
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
    //----------------------------------------------------------//
    
    //------------[Create Button]----------------------//
    public JButton NextLevel = new JButton(nextlevelimg);
    
    //----------------[Create Object]-----------------//
    Slideman charslideman = new Slideman();
    Srus sruschar = new Srus();
    Srus2 sruschar2 = new Srus2();
    Srus3 sruschar3 = new Srus3();
    SoundEffect sound = new SoundEffect();
    GameOver gameover = new GameOver();
    //---------------------------------------------------//
    
    //-----------[Attributes]----------------//
    public int checkbacktofront = 0;
    boolean checkpickupsword = false;
    public int checknearsrus = 0;
    public int times;
    public int score;
    public int alive;
    public int checkattack;
    boolean checknextlevel = false;
    boolean checkendgame = false;
    boolean timestart = true;
    boolean clockpickup = false;
    //----------------------------------------//
    
    
    //-----------------[Timer]---------------------//
    private final Timer timer = new Timer(40, new Listener());
    private final Timer timercount = new Timer(1000, new Listener());
    //--------------------------------------------//

    //--------------------[Thread Check Action Character]-------------------//
    Thread time = new Thread(new Runnable(){
        @Override
        public void run(){
            while(true){
                try{       
                    if(checkendgame == false){ //if game not end
                        
                        if(charslideman.walk == 400 && clockpickup == false && charslideman.checkfloor == 1){
                            if(times <= 90){
                                clockpickup = true;
                                times += 10;
                            }      
                        }
                        
                        if(charslideman.walk == 1100 && charslideman.checkfloor == 3 && sruschar.alive == false && sruschar2.alive == false && sruschar3.alive == false){
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
    //---------------------------------------------------------------------------//

    
    //-----------------[Constructor]------------------//
    Level1(){
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
    //-------------------------------------------------------//
    
    //----------[Class Listener Event of timer]----------------//
    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == timercount){
                if(checknextlevel == false)
                    times--;
            }
            repaint();
        }
    }
    //----------------------------------------------------------//
    
    //-----------[Implements from ActionListener]---------------//
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    //-------------------------------------------------------------//
    
    //-------------------[Draw Image, String, Other]-------------------//
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.drawImage(wallpaper.getImage(), 0, 0, 1200, 800, this); //Draw Wallpaper
        g.setColor(Color.ORANGE); // Change color pen
        g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE, 20)); //Change font and sizefont	
        g.drawImage(charslideman.IconClock.getImage(), 480, 15, 50, 50, this); //Draw Image Icon Time
        g.drawString("Time: "+times, 520, 50); // String Time
        g.drawImage(charslideman.IconCup.getImage(), 255, 20, 40, 40, this); //Draw Image Icon Cup
        g.drawString("Score: "+score, 300, 50); //String Score
        g.drawImage(charslideman.IconHeart.getImage(), 710, 27, 30, 30, this); //Draw Image Icon Heart
        g.drawString("Alive: "+alive, 750, 50);  // String Alive
        
        g.drawImage(floor1.getImage(), 300, 490, 889, 59, this); //Draw floor 1
        g.drawImage(floor1.getImage(), -200, 320, 889, 59, this); //Draw floor2
        g.drawImage(floor1.getImage(), 300, 150, 889, 59, this); //Draw floor3
        
        g.drawImage(door.getImage(), 1100, 66, 57, 84, this); //Draw Door
        
        if(clockpickup == false){
            g.drawImage(charslideman.IconClock.getImage(),400, 425, 80, 80, this);
        }
        
        //Srus1
        if(sruschar.alive == true) //if srus1 is alive
        {
            if(sruschar.back == true){ //if srus1 is walkback
                g.drawImage(sruschar.imb.getImage(), sruschar.x, sruschar.y, 50, 60, this); //Draw Srus1 walkback
            }
            else{ //if srus1 not is walkback
               g.drawImage(sruschar.im.getImage(), sruschar.x, sruschar.y, 50, 60, this); //Draw Srus1 walkfront
            }
        }
        //Srus2
        if(sruschar2.alive == true)//if srus2 is alive
        {
            if(sruschar2.back == true){//if srus2 is walkback
                g.drawImage(sruschar2.imb.getImage(), sruschar2.x, sruschar2.y, 50, 60, this); //Draw Srus2 walkback
            }
            else{ //if srus2 not is walkback
               g.drawImage(sruschar2.im.getImage(), sruschar2.x, sruschar2.y, 50, 60, this); //Draw Srus2 walkfront
            }
        }
        //Srus3
        if(sruschar3.alive == true)//if srus3 is alive
        {
            if(sruschar3.back == true){//if srus3 is walkback
                g.drawImage(sruschar3.imb.getImage(), sruschar3.x, sruschar3.y, 50, 60, this); //Draw Srus3 walkback
            }
            else{//if srus3 not is walkback
               g.drawImage(sruschar3.im.getImage(), sruschar3.x, sruschar3.y, 50, 60, this);//Draw Srus3 walkfront 
            }
        }
        
        
        if(checkbacktofront == 0){ //if slideman walkfront
            if(charslideman.count > 0){ //check count change action walk
                g.drawImage(charslideman.im.getImage(), charslideman.walk, charslideman.walky, 70, 70, this); // Draw slideman walkimage
            }
            else if(charslideman.count == 0){ //check cout change action walk == 0
                if(checkpickupsword == true){ //if pickup sword
                    g.drawImage(charslideman.picksword.getImage(), charslideman.walk, charslideman.walky, 70, 70, this); //Draw slideman take sword
                }
                else //if not pickup sword
                    g.drawImage(slideman.getImage(), charslideman.walk, charslideman.walky, 70, 70, this); //Draw slideman default
            }   
            
            if(checkpickupsword == true){ //if slide pickup sword
                if(checkattack == 1){ //if press space to attack
                    g.drawImage(swordslidemanat.getImage(), charslideman.walk+40, charslideman.walky+20, charslideman.swordwidth, charslideman.swordheight, this); //Draw sword slideman
                    if(checknearsrus == 1){ //check slideman near srus1
                        score+=50;
                        sruschar.alive = false;
                        checknearsrus = 0;
                        sound.FileName = "mydamage.wav";
                        sound.sound();
                    }
                    else if(checknearsrus == 2){ //check slideman near srus2
                        score+=50;
                        sruschar2.alive = false;
                        checknearsrus = 0;
                        sound.FileName = "mydamage.wav";
                        sound.sound();
                    }
                    else if(checknearsrus == 3){ //check slideman near srus3
                        score+=50;
                        sruschar3.alive = false;
                        checknearsrus = 0;
                        sound.FileName = "mydamage.wav";
                        sound.sound();
                    }
                    checkattack = 0; //Set check attack = 0
                }
                else if(checkattack == 0){ //if not attack
                    g.drawImage(swordslideman.getImage(), charslideman.walk+22, charslideman.walky+5, charslideman.swordwidth, charslideman.swordheight, this); //Draw sword slideman default
                }
            }
        }
        //Walkback
        else if(checkbacktofront == 1){ //if slideman walkback
            if(charslideman.count > 0){//check count change action walk
                g.drawImage(charslideman.imb.getImage(), charslideman.walk, charslideman.walky, 70, 70, this); //Draw slideman walkback
            }
            else if(charslideman.count == 0){//check cout change action walk == 0
                if(checkpickupsword == true){ //if slideman pickup sword
                    g.drawImage(charslideman.pickswordback.getImage(), charslideman.walk, charslideman.walky, 70, 70, this); //Draw slideman take sword back
                }
                else // if slideman not pickup sword
                    g.drawImage(slidemanbackstep.getImage(), charslideman.walk, charslideman.walky, 70, 70, this); //Draw slideman back default
            } 
            
            if(checkpickupsword == true){ //if slide pickup sword
                if(checkattack == 1){ //if press space to attack
                    g.drawImage(swordslidemanbackat.getImage(), charslideman.walk-40, charslideman.walky+20, charslideman.swordwidth, charslideman.swordheight, this); //Draw sword slideman
                    if(checknearsrus == 1){//check slideman near srus1
                        score+=50;
                        sruschar.alive = false;
                        checknearsrus = 0;
                        sound.FileName = "mydamage.wav";
                        sound.sound();
                    }
                    else if(checknearsrus == 2){//check slideman near srus2
                        score+=50;
                        sruschar2.alive = false;
                        checknearsrus = 0;
                        sound.FileName = "mydamage.wav";
                        sound.sound();
                    }
                    else if(checknearsrus == 3){//check slideman near srus3
                        score+=50;
                        sruschar3.alive = false;
                        checknearsrus = 0;
                        sound.FileName = "mydamage.wav";
                        sound.sound();
                    }
                    checkattack = 0;
                }
                else if(checkattack == 0){ //if not attack
                    g.drawImage(swordslidemanback.getImage(), charslideman.walk-22, charslideman.walky+5, charslideman.swordwidth, charslideman.swordheight, this); //Draw sword slideman default
                }
            }
        }
        
        if(checkpickupsword == false){ //if slideman not pickup sword
            g.drawImage(sword.getImage(), 900, 560, 70, 70, this); //Draw sword on floor

            if(charslideman.walk == 900 && charslideman.checkfloor == 0){ //if slideman is position sword can pickup sword
                checkpickupsword = true;
            }
        }
        
        g.drawImage(underfloor.getImage(), 0, 0, 1200, 665, this); //Draw floor0
        
        
        //Lose
        if(alive <= 0 || times <= 0){ //if alive <= 0 or times <=0
            this.setLayout(null);
            g.setColor(Color.RED);
            g.drawImage(wallpaperlose.getImage(), 0, 0, 1200, 700, this);
            g.setFont(new Font("Tahoma",Font.PLAIN,50));		
            g.drawString("Score: "+score,460,410);		     
            checkendgame = true;
            timer.stop();
            timercount.stop();
        }     
        
        //Win for this level
        if(checknextlevel == true){
            this.setLayout(null);
            g.setColor(Color.ORANGE);
            g.drawImage(wallpaperwin.getImage(), 0, 0, 1200, 700, this);
            g.setFont(new Font("Tahoma",Font.PLAIN,50));		
            g.drawString("Score: "+score,460,410);	     
            timer.stop();
            timercount.stop();
            //checknextlevel = false;
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
    //-------------------------------------------------------------------------------------//

}
