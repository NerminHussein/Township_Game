package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import static com.mygdx.game.Farm.Tex_returnbutton_WID;

public class CommunityBuildings {

    Texture community1;
    Texture community2;
    Texture returnbutton , closebutton;
    Texture backgroundTexture;

    public CommunityBuildings(SpriteBatch batch) {
        backgroundTexture = new Texture(Gdx.files.internal("background.png"));
        community1 = new Texture("cafe.PNG");
        community2 = new Texture("stuffhome.png");
        closebutton=new Texture("close.png");
        returnbutton = new Texture("returnbutton.png");
        this.communityBuildingsRenderer(batch);
    }

    public void communityBuildingsRenderer(SpriteBatch batch) {
        batch.draw(backgroundTexture, 400, 150, 700, 500);
        batch.draw(returnbutton, 30+400, 40+150,35,35);
        if (Mouse.MouseDetection(30 + 400, 40 + 150, returnbutton,35,35)) {
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                Shop.clickNum = 0;
                Shop.activeButtons=true;
            }
        }
        batch.draw(community1, 60+400, 100+150);
          batch.draw(community2,360 + 400, 100 + 150);
    }
}
