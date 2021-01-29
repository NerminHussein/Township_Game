package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Item {

    private Texture img;
    public int ItemPosX;
    public int ItemPosY;
    public static int numOfItems;
    boolean clickDetection = false;
    private static boolean moving = false;
    public static int numberOfWheat = 0;
    public static int numberOfBread = 0;
    public static int numberOfTomatoes = 0;
    public static int numberOfSauce = 0;
    public static int numberOfOnions = 0;
    private static int trust;
    private static boolean test = false;
    private static int itemEnumeration;
    public static int TCash = 500;
    public static int Level = 1;
    public static int ex = 0;

    public Item(int posX, int posY, int numOfItems) {
        ItemPosX = posX;
        ItemPosY = posY;
        this.numOfItems = numOfItems;
        itemEnumeration++;

    }

    public void move() {
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT) && !test) {
            test = true;
        }
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && clickDetection) {
            ItemPosX = Map.posJ;
            ItemPosY = Map.posI;
        } else if (ItemPosX == Map.posJ && ItemPosY == Map.posI && test) {
            clickDetection = true;
        } else {
            clickDetection = false;
            moving = false;
            test = false;
        }

    }

    public int getItemposX() {
        return ItemPosX;
    }

    public void setItemposX(int ItemposX) {
        this.ItemPosX = ItemposX;
    }

    public int getItemPosY() {
        return ItemPosY;
    }

    public void setItemPosY(int ItemPosY) {
        this.ItemPosY = ItemPosY;
    }

    public void itemDispose() {
        this.img.dispose();
        itemEnumeration--;

    }

}
