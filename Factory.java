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
public abstract class Factory extends Item {

 

    public Factory(int posX, int posY, int numOfItems) {
        super(posX, posY, numOfItems);
    }
    
   
    
    public abstract void PutCrops();
   public abstract void RunFactory();
   public abstract void Collect();
    public abstract void drawFactory(SpriteBatch Batch);
    public abstract void dispose();
   
    
}
