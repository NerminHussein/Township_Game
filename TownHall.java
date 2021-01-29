/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author Omar Salah
 */
public class TownHall extends Item{
    Texture townhall;
    Texture TownhallMove;
    
    public TownHall(int posX, int posY, int numOfItems) {
        super(posX, posY, numOfItems);
        townhall=new Texture(Gdx.files.internal("house 3.png"));
        TownhallMove = new Texture(Gdx.files.internal("Move.png"));
    }
    public void drawTownHall(SpriteBatch batch){
        batch.draw(townhall, super.ItemPosX*50, super.ItemPosY*50,250,250);
        batch.draw(TownhallMove, super.ItemPosX*50, super.ItemPosY*50,50,50);
        super.move();
    }
    
}
