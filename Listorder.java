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
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Omar Salah
 */
public class Listorder {

    Texture tomatom;
    Texture wheat;
    Texture onion;
    int wheatnum=0;
    int tomatoenum=0;
    int onionnum=0;
    int[] rand_num = new int[3];
    public static long  startTime = System.currentTimeMillis() / 1000;
    ArrayList<Texture> OrderList;
    ArrayList<Texture> OrderListActive;
    public static boolean orderlistActive=false;
        Random randomvariable = new Random();

    public Listorder() {
//        this.startTime = System.currentTimeMillis() / 1000;
        OrderList = new ArrayList<Texture>();
        OrderListActive = new ArrayList<Texture>();
        tomatom = new Texture("tomato.png");
        wheat = new Texture("wheat.png");
        onion = new Texture("onion.png");
        OrderList.add(wheat);
        OrderList.add(tomatom);
        OrderList.add(onion);
          for (int i = 0; i < 3; i++) 
        {
              rand_num[i] = randomvariable.nextInt(OrderList.size());
        }

    }

    public void listorderRenderer(SpriteBatch batch) {
       
        //long CurrentTime = System.currentTimeMillis() / 1000;
//           for (int i = 0; i < 3; i++) 
//        {
//              rand_num[i] = randomvariable.nextInt(OrderList.size());
//        }
      
        for (int i = 0; i < 3; i++) {
            //if (startTime - CurrentTime ==0) 
            if (i == 0) {
                batch.draw(OrderList.get(rand_num[2]), 1350, 620);
                if(rand_num[2]==0){wheatnum++;}
                if(rand_num[2]==1){tomatoenum++;}
                if(rand_num[2]==2){onionnum++;}
            } else if (i == 1) {
                batch.draw(OrderList.get(rand_num[1]), 1350, 660);
                if(rand_num[1]==0){wheatnum++;}
                if(rand_num[1]==1){tomatoenum++;}
                if(rand_num[1]==2){onionnum++;}
            } else if (i == 2) {
                batch.draw(OrderList.get(rand_num[0]), 1350, 700);
                if(rand_num[0]==0){wheatnum++;}
                if(rand_num[0]==1){tomatoenum++;}
                if(rand_num[0]==2){onionnum++;}
            }

        }
        
    }
    public void doneOrder()
    {
        if(Gdx.input.getX()>1350&&Gdx.input.getX()<1350+tomatom.getWidth()&&Gdx.graphics.getHeight()-Gdx.input.getY()>620&&Gdx.graphics.getHeight()-Gdx.input.getY()>620+tomatom.getHeight()&&
                Gdx.input.isButtonJustPressed(Input.Buttons.LEFT))
        {
            if(Item.numberOfWheat>=wheatnum&&Item.numberOfTomatoes>=tomatoenum&&Item.numberOfOnions>=onionnum){
            System.err.println("pressed");
                Item.numberOfWheat-=wheatnum;
                Item.numberOfTomatoes-=tomatoenum;
                Item.numberOfOnions-=onionnum;
                Item.TCash+=50;
                orderlistActive=false;
            }
        }
    }

}
