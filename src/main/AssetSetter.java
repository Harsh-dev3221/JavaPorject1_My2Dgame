   /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;

/**
 *
 * @author HARSH
 */
public class AssetSetter {
    
    gamepannel gp;
    public AssetSetter (gamepannel gp)
    {
        this.gp = gp;
        
    }
    
    public void setObject()
    {
        gp.obj[0]= new OBJ_Key(); 
        gp.obj[0].worldX= 23 * gp.tileSize;
        gp.obj[0].worldY = 7 * gp.tileSize;
        
        gp.obj[1]= new OBJ_Key();
        gp.obj[1].worldX= 23*gp.tileSize;
        gp.obj[1].worldY= 40 * gp.tileSize;
        
        gp.obj[2]= new OBJ_Door();
        gp.obj[2].worldX= 36*gp.tileSize;
        gp.obj[2].worldY= 15 * gp.tileSize;
        
        gp.obj[3]= new OBJ_Door();
        gp.obj[3].worldX= 10*gp.tileSize;
        gp.obj[3].worldY= 11 * gp.tileSize;
        
        gp.obj[4]= new OBJ_Door();
        gp.obj[4].worldX= 17*gp.tileSize;
        gp.obj[4].worldY= 27 * gp.tileSize;
        
        gp.obj[5]= new OBJ_Chest();
        gp.obj[5].worldX= 10*gp.tileSize;
        gp.obj[5].worldY= 8* gp.tileSize;
        
        
        
        gp.obj[6]= new OBJ_Chest();
        gp.obj[6].worldX= 17*gp.tileSize;
        gp.obj[6].worldY= 24* gp.tileSize;
        
        gp.obj[7]= new OBJ_Key(); 
        gp.obj[7].worldX= 37 * gp.tileSize;
        gp.obj[7].worldY = 41 * gp.tileSize;
     
        gp.obj[8]= new OBJ_Boots(); 
        gp.obj[8].worldX= 37 * gp.tileSize;
        gp.obj[8].worldY = 43 * gp.tileSize;
        
    }
}
