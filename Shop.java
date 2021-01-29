package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Shop {

    public static final int Tex_Houses_WID = 260;
    public static final int Tex_Houses_HEIhGT = 230;
    //
    public static final int Tex_Farm_WID = 60;
    public static final int Tex_Farm_HEIhGT = 230;
    //
    public static final int Tex_Community_WID = 260;
    public static final int Tex_Community_HEIhGT = 35;
    //
    public static final int Tex_Crops_WID = 350;
    public static final int Tex_Crops_HEIhGT = 35;
    //
    public static final int Tex_Factories_WID = 450;
    public static final int Tex_Factories_HEIhGT = 230;

    public static final int Tex_close_WID = 650;
    public static final int Tex_close_HEIhGT = 460;

    private final int Menu_Pos_X = 400;
    private final int Menu_Pos_Y = 150;
    public static int clickNum = 0;

    public static boolean active = false;
    public static boolean activeButtons = true;
    

    Texture img, farming, houses, factories, crops, community_bulidings;
    Texture backgroundTexture;
    Texture returnbutton , closebutton;
    Farm farm;
    Houses house;
    Factories factory;
    CommunityBuildings communityBuildings;

    public Shop() {
        farming = new Texture("farming.png");
        //houses
        houses = new Texture("houses.png");
        //factories
        factories = new Texture("factories.png");
        //crops
        crops = new Texture("crops.png");
        //community
        community_bulidings = new Texture("communitybulidings.png");

        backgroundTexture = new Texture(Gdx.files.internal("background.png"));
        returnbutton = new Texture("returnbutton.png");
        closebutton=new Texture("close.png");
        
    }

    public void shopRenderer(SpriteBatch batch) {
        if (active) {

            if (clickNum == 0) {
                batch.draw(backgroundTexture, Menu_Pos_X, Menu_Pos_Y, 700, 500);
                batch.draw(farming, Tex_Farm_WID + Menu_Pos_X, Tex_Farm_HEIhGT + Menu_Pos_Y);
                batch.draw(houses, Tex_Houses_WID + Menu_Pos_X, Tex_Houses_HEIhGT + Menu_Pos_Y);
                // Factories menu
                batch.draw(factories, Tex_Factories_WID + Menu_Pos_X, Tex_Factories_HEIhGT + Menu_Pos_Y);
                // Community_Buliding Menu
                batch.draw(community_bulidings, Tex_Community_WID + Menu_Pos_X, Tex_Community_HEIhGT + Menu_Pos_Y);
                //Crops Menu
//        batch.draw(crops, Tex_Crops_WID + Menu_Pos_X, Tex_Crops_HEIhGT + Menu_Pos_Y);
            } else if (clickNum == 1) {
                farm = new Farm(batch);
            } else if (clickNum == 2) {
                house = new Houses(batch);
            } else if (clickNum == 3) {
                factory = new Factories(batch);
            } else if (clickNum == 4) {
                communityBuildings = new CommunityBuildings(batch);
            }
                batch.draw(closebutton, Tex_close_WID + 400, Tex_close_HEIhGT + 150,35,35);
            this.Click();
        }

    }

    public void Click() {
       if(activeButtons)
       {
            if (Mouse.MouseDetection(Tex_Farm_WID + Menu_Pos_X, Tex_Farm_HEIhGT + Menu_Pos_Y, farming,farming.getWidth(),farming.getHeight())) {
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                clickNum = 1;
                this.activeButtons=false;
            }
        }//Houses menu
        if (Mouse.MouseDetection(Tex_Houses_WID + Menu_Pos_X, Tex_Houses_HEIhGT + Menu_Pos_Y, houses,houses.getWidth(),houses.getHeight())) {
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                clickNum = 2;
                this.activeButtons=false;
            }
        }//Houses menu
        if (Mouse.MouseDetection(Tex_Factories_WID + Menu_Pos_X, Tex_Factories_HEIhGT + Menu_Pos_Y, factories,factories.getWidth(),factories.getHeight())) {
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                clickNum = 3;
                this.activeButtons=false;
                Factories.backActive=false;
            }
        }//Houses menu
        if (Mouse.MouseDetection(Tex_Community_WID + Menu_Pos_X, Tex_Community_HEIhGT + Menu_Pos_Y, community_bulidings,community_bulidings.getWidth(),community_bulidings.getHeight())) {
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                clickNum = 4;
                this.activeButtons=false;
            }
        }//Houses menu
       }
        if (Mouse.MouseDetection(Tex_close_WID + Menu_Pos_X, Tex_close_HEIhGT + Menu_Pos_Y, closebutton,35,35)) {
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                this.active=false;
                            }
        }//Houses menu
    }

}
