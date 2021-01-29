package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Mouse {

    public static boolean mouse;

    public static boolean MouseDetection(int X, int Y, Texture img,int imgWid,int imgHeight) {
        if (Gdx.input.getX() > X && Gdx.input.getX() < X + imgWid&&Gdx.graphics.getHeight()-Gdx.input.getY()>Y&&Gdx.graphics.getHeight()-Gdx.input.getY()<Y+imgHeight) {
            mouse = true;
        }else{
            mouse=false;
        }
            return mouse;
    }
}
