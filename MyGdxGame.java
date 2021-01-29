package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {

    public SpriteBatch batch;
    TownHall townhall;
    Map map;
    Texture Startbackground;
    Texture Startbutton;
    static boolean started = false;
    ArrayList<Wheat> wheat = new ArrayList<Wheat>();
    ArrayList<Tomatoes> tomatoe = new ArrayList<Tomatoes>();
    ArrayList<Onions> onion = new ArrayList<Onions>();
    ArrayList<WheatFactory> wheatFactory = new ArrayList<WheatFactory>();
    ArrayList<Ketchup> ketchup = new ArrayList<Ketchup>();
    RecordsBar coins;
    public static int cropsx = 0;
    public static int cropsy = 0;
    public static int factoryx = 0;
    public static int WheatFactoryy = 12;
    public static int ketchupFactoryy = 12;
    public static int numofitem = 1;
    Sound gameSound;
    Shop shop;
    Listorder listorder;

    @Override
    public void create() {
        batch = new SpriteBatch();
        map = new Map();
        shop = new Shop();
        townhall = new TownHall(12, 5, 20);
        listorder = new Listorder();
        Startbackground = new Texture(Gdx.files.internal("start.jpg"));
        Startbutton = new Texture(Gdx.files.internal("playnow.png"));
        gameSound = Gdx.audio.newSound(Gdx.files.internal("soundGame.mp3"));
        gameSound.play();
        gameSound.loop();

    }

    @Override
    public void render() {
        if (Mouse.MouseDetection(550, 350, Startbutton, 400, 100) && Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            started = true;
        }

        if (!started) {
            batch.begin();
            batch.draw(Startbackground, 0, 0, 1500, 800);
            batch.draw(Startbutton, 550, 350, 400, 100);
            batch.end();
        }

        if(started)
        {
            Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        coins = new RecordsBar(batch);

        map.grassRenderer(batch);

        if (Map.wheatDraw()) {
            if (cropsx % 30 == 0 && cropsx != 0) {
                cropsy++;
                cropsx = 0;
            }
            wheat.add(new Wheat(cropsx++, cropsy, numofitem++));

        } else if (Map.tomatoeDraw()) {
            if (cropsx % 30 == 0 && cropsx != 0) {
                cropsy++;
                cropsx = 0;
            }
            tomatoe.add(new Tomatoes(cropsx++, cropsy, numofitem++));

        } else if (Map.onionDraw()) {
            if (cropsx % 30 == 0 && cropsx != 0) {
                cropsy++;
                cropsx = 0;
            }
            onion.add(new Onions(cropsx++, cropsy, numofitem++));

        }
        if (Factories.wheatDraw()) {
            wheatFactory.add(new WheatFactory(factoryx, WheatFactoryy, numofitem++));
            factoryx += 3;
        }
        if (Factories.ketchupDraw()) {
            ketchup.add(new Ketchup(factoryx, ketchupFactoryy, numofitem++));
            factoryx += 3;
        }
        for (int i = 0; i < wheat.size(); i++) {
            wheat.get(i).drawCrop(batch);
        }
        for (int i = 0; i < tomatoe.size(); i++) {
            tomatoe.get(i).drawCrop(batch);
        }
        for (int i = 0; i < onion.size(); i++) {
            onion.get(i).drawCrop(batch);
        }
        for (int i = 0; i < wheatFactory.size(); i++) {
            wheatFactory.get(i).drawFactory(batch);
        }
        for (int i = 0; i < ketchup.size(); i++) {
            ketchup.get(i).drawFactory(batch);
        }
        townhall.drawTownHall(batch);

        if (Shop.active) {
            shop.shopRenderer(batch);
        }
        if (Listorder.orderlistActive) {

            listorder.doneOrder();
            listorder.listorderRenderer(batch);
        }

        batch.end();
        coins.stage.draw();
        }

    }

    @Override
    public void dispose() {
        batch.dispose();
        coins.dispose();

    }
}
