/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Harsh
 */
public class OBJ_Chest extends SuperObject {
    public OBJ_Chest()
    {
        name = "Chest";
        try{
            image =  ImageIO.read(getClass().getResourceAsStream("/Object/chest.png"));
        }
        catch(IOException e)
        {
            
            e.printStackTrace();
            
        }
    }
    
}
