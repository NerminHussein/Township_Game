package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Map {

    private Texture grass1Img;
    private Texture grass2Img;
    private Texture borderImg;
    Texture shopIcon;
    Texture orderListIcon;
    Texture alertIcon;
    static Texture wheatIcon;
    static Texture tomatoeIcon;
    static Texture onionIcon;
//    private Texture Item;
    public static int posI;
    public static int posJ;
    public final static int entityScaleX = 50;
    public final static int entityScaleY = 50;
    private final int shopX = 1450;
    private final int shopY = 750;
    private final int orderListX = 1400;
    private final int orderListY = 750;
    private final int alertX = 1400;
    private final int alertY = 785;
    private static final int wheatX = 1350;
    private static final int wheatY = 750;
    private static final int tomatoeX = 1300;
    private static final int tomatoeY = 750;
    private static final int onionX = 1250;
    private static final int onionY = 750;

    public Map() {
        grass1Img = new Texture(Gdx.files.internal("grass.jpg"));
        grass2Img = new Texture(Gdx.files.internal("grass4.jpg"));
        borderImg = new Texture(Gdx.files.internal("square.png"));
        shopIcon = new Texture(Gdx.files.internal("shop 2.png"));
        orderListIcon = new Texture(Gdx.files.internal("orderlist.png"));
        alertIcon = new Texture(Gdx.files.internal("alert2.png"));
        wheatIcon = new Texture(Gdx.files.internal("BigCrops1.png"));
        tomatoeIcon = new Texture(Gdx.files.internal("Tomatoes2.png"));
        onionIcon = new Texture(Gdx.files.internal("Onions1.png"));
//        Item=new Texture(Gdx.files.internal("item.png"));

    }

    public void grassRenderer(SpriteBatch batch) {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 30; j++) {
                if (i < 15) {
                    if ((j + i) % 2 == 0) {
                        batch.draw(grass1Img, (j * entityScaleX), (i * entityScaleY), entityScaleX, entityScaleY);
                    } else {
                        batch.draw(grass2Img, (j * entityScaleX), (i * entityScaleY), entityScaleX, entityScaleY);
                    }
                }
                if ((Gdx.input.getX() > j * entityScaleX && Gdx.input.getX() < (j * entityScaleX + entityScaleX)) && (Gdx.graphics.getHeight() - Gdx.input.getY() > i * entityScaleY && Gdx.graphics.getHeight() - Gdx.input.getY() < (i * entityScaleY + entityScaleY))) {
                    posI = i;
                    posJ = j;
                    batch.draw(borderImg, (j * entityScaleX), (i * entityScaleY), entityScaleX, entityScaleY);
                }
            }
        }
        batch.draw(shopIcon, shopX, shopY, 50, 50);
        batch.draw(orderListIcon, orderListX, orderListY, 50, 50);
        batch.draw(alertIcon, alertX, alertY, 10, 10);
        batch.draw(wheatIcon, wheatX, wheatY, 50, 50);
        batch.draw(tomatoeIcon, tomatoeX, tomatoeY, 50, 50);
        batch.draw(onionIcon, onionX, onionY, 50, 50);
        if (Mouse.MouseDetection(shopX, shopY, shopIcon, 50, 50) && Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            Shop.active = true;
            Shop.activeButtons = true;
        }
        if (Mouse.MouseDetection(orderListX, orderListY, orderListIcon, 50, 50) && Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            if (!Listorder.orderlistActive) {
//                Listorder.startTime= System.currentTimeMillis() / 1000;
                Listorder.orderlistActive = true;
            }else {
                Listorder.orderlistActive=false;
            }
        }
    }

    public static boolean wheatDraw() {
        if (Mouse.MouseDetection(wheatX, wheatY, wheatIcon, 50, 50) && Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {

            return true;
        } else {
            return false;
        }
    }

    public static boolean tomatoeDraw() {
        if (Mouse.MouseDetection(tomatoeX, tomatoeY, tomatoeIcon, 50, 50) && Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {

            return true;
        } else {
            return false;
        }
    }

    public static boolean onionDraw() {
        if (Mouse.MouseDetection(onionX, onionY, onionIcon, 50, 50) && Gdx.input.isButtonJustPressed(Input.Buttons.LEFT) && Item.Level > 1) {

            return true;
        } else {
            return false;
        }
    }

    public void grassDispose() {
        grass1Img.dispose();
        borderImg.dispose();
    }

}
