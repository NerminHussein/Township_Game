package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import static com.mygdx.game.Farm.Tex_returnbutton_WID;

public class Houses {

    Texture houses1;
    Texture houses2;
    Texture returnbutton , closebutton;
    Texture backgroundTexture;

    public Houses(SpriteBatch batch) {
        houses1 = new Texture("house1.PNG");
        houses2 = new Texture("house2.png");
        closebutton=new Texture("close.png");
        returnbutton = new Texture("returnbutton.png");
        backgroundTexture = new Texture(Gdx.files.internal("background.png"));
        this.housesRenderer(batch);
    }

    public void housesRenderer(SpriteBatch batch) {
        batch.draw(backgroundTexture, 400, 150, 700, 500);
        
        batch.draw(returnbutton, 30 + 400, 40 + 150,35,35);
        if (Mouse.MouseDetection(Tex_returnbutton_WID + 400, Tex_returnbutton_WID + 150, returnbutton,35,35)) {
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                 Shop.clickNum=0;
                 Shop.activeButtons=true;
            }
        }
        batch.draw(houses1, 60 + 400, 140 + 150);
        batch.draw(houses2, 360 + 400, 140 + 150);
    }
}
