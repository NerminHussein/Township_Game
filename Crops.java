/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Item;

/**
 *
 * @author micheal
 */
public abstract class Crops extends Item {

    public Crops(int posX, int posY, int numOfItems) {
        super(posX, posY, numOfItems);
    }

    
    public abstract void Collect();
    public abstract void drawCrop(SpriteBatch sb);
    public abstract void Time();
    public abstract void PutCrops();
    public abstract void dispose(); 
       
       
     
     
    
}
