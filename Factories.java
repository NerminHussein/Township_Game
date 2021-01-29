package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import static com.mygdx.game.Farm.Tex_returnbutton_WID;

public class Factories {

    static Texture factory1;
    static Texture factory2;
    static Texture returnbutton, closebutton;
    Texture backgroundTexture;
    static boolean factoriesActive = false;
    public static boolean backActive = false;

    public Factories(SpriteBatch batch) {
        factory1 = new Texture("Bakery.png");
        factory2 = new Texture("ketchup.png");
        closebutton = new Texture("close.png");
        returnbutton = new Texture("returnbutton.png");
        backgroundTexture = new Texture(Gdx.files.internal("background.png"));
        this.factoriesRenderer(batch);
        if (!backActive) {
            factoriesActive = true;
        }

    }

    public void factoriesRenderer(SpriteBatch batch) {
        batch.draw(backgroundTexture, 400, 150, 700, 500);
        batch.draw(returnbutton, 30 + 400, 40 + 150, 35, 35);
        if (Mouse.MouseDetection(30 + 400, 40 + 150, returnbutton, 35, 35)) {
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                Shop.clickNum = 0;
                Shop.activeButtons = true;
                factoriesActive = false;
                backActive = true;
            }
        }
        batch.draw(factory1, 60 + 400, 100 + 150);
        batch.draw(factory2, 360 + 400, 100 + 150);
    }

    public static boolean wheatDraw() {
        factory1 = new Texture("Bakery1.png");
        if (Mouse.MouseDetection(60 + 400, 100 + 150, factory1, factory1.getWidth(), factory1.getHeight()) && Shop.active && Gdx.input.isButtonJustPressed(Input.Buttons.LEFT) && factoriesActive && Item.TCash >= 50) {
            Shop.clickNum = 0;
            Shop.active = false;
            factoriesActive = false;
            Item.TCash = Item.TCash - 50;

            Item.ex = Item.ex + 20;
            return true;
        } else {
            return false;
        }
    }

    public static boolean ketchupDraw() {
        factory2 = new Texture("feedMill.png");
        if (Mouse.MouseDetection(360 + 400, 100 + 150, factory2, factory2.getWidth(), factory2.getHeight()) && Shop.active && Gdx.input.isButtonJustPressed(Input.Buttons.LEFT) && factoriesActive && Item.TCash >= 50 && Item.Level>1 ) {
            Shop.clickNum = 0;
            Shop.active = false;
            factoriesActive = false;
            Item.ex = Item.ex + 20;
            Item.TCash = Item.TCash - 50;

            return true;
        } else {
            return false;
        }
    }
}
