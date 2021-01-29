/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Map;

/**
 *
 * @author micheal
 */

public class Tomatoes extends Crops{
     private Texture Ttomatoes;
    private  int CropStatus=1;
    
    private boolean clickCollect = false;
     long beginTime;
     
     public Tomatoes(int posX, int posY ,int numOfItems)
     {
          super(posX,posY,numOfItems);   
         
     }

      @Override
      public void drawCrop(SpriteBatch Batch)
    {
        if(this.CropStatus==1)
        {
             Ttomatoes=new Texture(Gdx.files.internal("crop1.PNG"));
             Batch.draw( Ttomatoes, super.getItemposX() * Map.entityScaleX, super.getItemPosY()* Map.entityScaleY, Map.entityScaleX, Map.entityScaleY);
        }
        else if(this.CropStatus==2)
        {
               Ttomatoes=new Texture(Gdx.files.internal("Tomatoes1.PNG"));
             Batch.draw( Ttomatoes, super.getItemposX() * Map.entityScaleX, super.getItemPosY()* Map.entityScaleY, Map.entityScaleX, Map.entityScaleY);
        Time();
        }
        else if(this.CropStatus==3)
        {
             Ttomatoes=new Texture(Gdx.files.internal("Tomatoes2.PNG"));
             Batch.draw( Ttomatoes, super.getItemposX() * Map.entityScaleX, super.getItemPosY() * Map.entityScaleY, Map.entityScaleX, Map.entityScaleY);;
        }
       super.move();
        this.PutCrops();
        this.Collect();
    }
      
      
       @Override
    public void PutCrops() {
         if(Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)&&this.clickCollect && CropStatus==1)
        {
            if(super.TCash>=1)
            {
            CropStatus=2;
            beginTime= System.currentTimeMillis() / 1000; 
                super.TCash=super.TCash-5;
            Item.ex=Item.ex+5;
            
            
            }
         
        }
        else if (super.getItemposX() == Map.posJ && super.getItemPosY()== Map.posI)
        {
            this.clickCollect=true;
        }
        else
        {
            this.clickCollect=false;
        }
        
    }
     @Override
       public void Time()
    {
        long CurrentTime = System.currentTimeMillis() / 1000;
        
        if(CurrentTime-beginTime==20)
        {
            this.CropStatus=3;
           
        }
    }
       
    @Override
    public void Collect() {
        
        if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT) && this.clickCollect && CropStatus==3)
        {
            this.CropStatus=1;
             beginTime= System.currentTimeMillis() / 1000;
            super.numberOfTomatoes++;
            
        } else if (super.getItemposX() == Map.posJ && super.getItemPosY()== Map.posI)
        {
            this.clickCollect=true;
        }
        else
        {
            this.clickCollect=false;
        }
        
        
    }

    @Override
    public void dispose() {
        this.Ttomatoes.dispose();
    }

   
}
