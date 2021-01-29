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

/**
 *
 * @author Omar Salah
 */
public class Farm {

    Texture cowbarn;
    Texture sheepfarm;
    Texture returnbutton , closebutton;
    public static final int Tex_returnbutton_WID = 30;
    public static final int Tex_returnbutton_HEIhGT = 40;
    Texture backgroundTexture;

    public Farm(SpriteBatch batch) {
        cowbarn = new Texture("cow barn.PNG");
        sheepfarm = new Texture("sheepfarm.png");
        closebutton=new Texture("close.png");
        returnbutton = new Texture("returnbutton.png");
        backgroundTexture = new Texture(Gdx.files.internal("background.png"));
        this.farmRenderer(batch);
    }

    public void farmRenderer(SpriteBatch batch) {
        batch.draw(backgroundTexture, 400, 150, 700, 500);
        batch.draw(returnbutton, 30 + 400, 40 + 150,35,35);
        if (Mouse.MouseDetection(30 + 400, 40 + 150, returnbutton,35,35)) {
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                Shop.clickNum = 0;
                Shop.activeButtons=true;
            }
        }
        batch.draw(cowbarn, 60 + 400, 140 + 150);
        batch.draw(sheepfarm, 360 + 400, 140 + 150);
    }
}
