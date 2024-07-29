/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import object.SuperObject;
import tile.TileManager;
/**
 *
 * @author HARSH
 */
public class gamepannel extends JPanel implements Runnable {
    //Screen  setings
    final int originalTileSize = 16;
    final int scale = 3;
    
    
   public final int tileSize= originalTileSize * scale;
   public final int maxScreenCol = 16;
   public final int maxScreenRow = 12;
   public final int screenWidth = tileSize*maxScreenCol;//768 pixel
   public final int screenHeight = tileSize*maxScreenRow;//576 pixel
   
   //world seting
   public final int maxWorldCol = 50;
   public final int maxWorldRow = 50;
   public final int worldWidth = tileSize * maxWorldCol;
   public final int worldHeight = tileSize * maxWorldRow;
   
    //FPS
    int FPS = 80;
    
    TileManager tileM= new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Sound sound = new Sound();
    Sound music  = new Sound();

    Thread gameThread;
    
    //
    public  CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    
    //
    public  Player player = new Player(this,keyH);
    public SuperObject obj[]= new SuperObject[10];
    
    public gamepannel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        
    }
    public void  setupGame()
    {
        aSetter.setObject();
        
        playMusic(0);
        
    }
    
    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
/*    public void run() {
                
            
                double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime()+drawInterval;
           
        while(gameThread != null)
        {
             
            //character pos
            update();
            
            //draw updated pos
            repaint();
            
            
            try
            {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime= remainingTime/1000000000;
                
                if(remainingTime <0){
                    remainingTime=0;
                }
                
                Thread.sleep((long)remainingTime);
                nextDrawTime += drawInterval;
            
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }*/
  
    public void run()
    {
        double drawInterval = 1000000000/FPS;
        double delta = 0 ;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        long drawCount = 0;
        
        while(gameThread != null)
        {
            currentTime = System.nanoTime();
            
            delta +=(currentTime - lastTime)/ drawInterval;
            
            lastTime = currentTime;
            
            if(delta >= 1 )
            {
                update();
                repaint();
                delta--;
                drawCount++;
            }
                if(timer >= 1000000000)
                {
                    System.out.println("FPS" + drawCount);
                    drawCount = 0;
                    timer = 0;
                    
                }
           
        }
    }
    public void update()
    {
       player.update();
    }
    public void paintComponent(Graphics g)
    {
    
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        tileM.draw(g2);
        
        for(int i = 0 ; i < obj.length; i++)
        {
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            if(obj[i] != null)
            {
                obj[i].draw(g2,this);
            }
        }
        
        player.draw(g2);
        g2.dispose();
        
        
        
    }
    public void playMusic(int i )
    {
        sound.setFile(i);
        sound.play();
        sound.loop();
        
    }
    public void stopMusic()
    {
        sound.stop();
        
    }
    public void playerSE(int i )
    {
        sound.setFile(i);
        sound.play();
        
    }
}
