/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tile;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.gamepannel;

/**
 *
 * @author HARSH
 */
public class TileManager {
    gamepannel gp;
    public Tile[] tile;
    public int mapTileNum[][];
    
    public TileManager(gamepannel gp)
    {
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        
        getTileImage();
        loadMap();
        
    }
    public void getTileImage()
    {
        
   
   // public TileManager()
    //{
        
       try{
           tile[0] = new Tile();
           tile[0].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png" ));
           
           tile[1] = new Tile();
           tile[1].image= ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png" ));
           tile[1].collision = true;
   
           
           tile[2] = new Tile();
           tile[2].image= ImageIO.read(getClass().getResourceAsStream("/tiles/water.png" ));
           tile[2].collision = true;
           
           tile[3] = new Tile();
           tile[3].image= ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png" ));
          
           tile[4] = new Tile();
           tile[4].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png" ));
           tile[4].collision = true;
           
           tile[5] = new Tile();
           tile[5].image= ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png" ));
       }
       catch(IOException e)
       {
        
           e.printStackTrace();
       }

    }
    public void loadMap()
    {
        try{
            InputStream is = getClass().getResourceAsStream("/maps/world01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;
            
            while(col < gp.maxWorldCol && row < gp.maxWorldRow)
            {
                String line = br.readLine();
                
                while(col < gp.maxWorldCol )
                {
                    String numbers[] = line.split(" ");
                    
                    int num = Integer.parseInt(numbers[col]);
                    
                    mapTileNum[col][row] = num;
                    col++;
                    
                }
                if(col == gp.maxWorldCol)
                    {
                        col=0;
                        row++;
                    }
                
                }
            br.close();
            
            
        }
            catch(Exception e)
        {
        }
    }
    public void draw(Graphics2D g2)
    {
        int col = 0;
        int row =0;
       
        while(col < gp.maxWorldCol && row < gp.maxWorldRow )
        {
            int tileNum= mapTileNum[col][row];
            
            int worldX = col * gp.tileSize;
            int worldY = row * gp.tileSize;
            
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            
            if(worldX + gp.tileSize >gp.player.worldX - gp.player.screenX && 
               worldX - gp.tileSize< gp.player.worldX + gp.player.screenX &&
               worldY + gp.tileSize >gp.player.worldY - gp.player.screenY && 
               worldY - gp.tileSize< gp.player.worldY + gp.player.screenY)
            {
                g2.drawImage(tile[tileNum].image,screenX,screenY,gp.tileSize,gp.tileSize,null);
            }
            
            col++;
            
            if(col == gp.maxWorldCol)
            {
                col=0;
                row++;
            }
        }
    }
}
