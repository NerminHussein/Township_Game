/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Item;

/**
 *
 * @author micheal
 */
public class RecordsBar implements  Disposable {
                 public Stage stage;
		 private Viewport viewport;
		 private OrthographicCamera camera;
		 
		 private static Label coinsRecord;
		 private final Label coinsLabel;
                 private final Label Wheat;
                 private final Label WheatLabel;
                 private final Label Tomatoes;
                 private final Label TomatoesLabel; 
                 private final Label Onions;
                 private final Label OnionsLabel;
                 private final Label Sauce;
                 private final Label SauceLabel;
                 private final Label Bread;
                 private final Label BreadLabel;
                 private final Label Level;
                 private final Label LevelLabel;
                         
                 public RecordsBar(SpriteBatch sb)
                 {
                      if(Item.ex%100==0&&Item.ex!=0)
                      {
                          Item.Level++;
                          Item.ex=0;
                      }
			 camera = new OrthographicCamera();
			 viewport = new FillViewport(1500,800,camera);
		        stage = new Stage(viewport, sb);
		        Table table = new Table();
		        table.top();
		        table.setFillParent(true);
		        coinsRecord =new Label(String.format("%06d", Item.TCash), new Label.LabelStyle(new BitmapFont(), Color.BLACK));
                        coinsLabel= new Label("TCash", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
                        Wheat=new Label(String.format("%06d", Item.numberOfWheat), new Label.LabelStyle(new BitmapFont(), Color.BLACK));
		        WheatLabel= new Label("Wheat", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
                        Tomatoes=new Label(String.format("%06d", Item.numberOfTomatoes), new Label.LabelStyle(new BitmapFont(), Color.BLACK));
                        TomatoesLabel=new Label("Tomatoes", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
                        Onions=new Label(String.format("%06d", Item.numberOfOnions), new Label.LabelStyle(new BitmapFont(), Color.BLACK));
                        OnionsLabel=new Label("Onions", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
                        Sauce=new Label(String.format("%06d", Item.numberOfSauce), new Label.LabelStyle(new BitmapFont(), Color.BLACK));
                        SauceLabel=new Label("Sauce", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
                        Bread=new Label(String.format("%06d", Item.numberOfBread), new Label.LabelStyle(new BitmapFont(), Color.BLACK));
                        BreadLabel=new Label("Bread", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
                        Level=new Label(String.format("%06d", Item.Level), new Label.LabelStyle(new BitmapFont(), Color.BLACK));
                        LevelLabel=new Label("Level", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
                        
                       
                       
		       table.add(coinsLabel).expandX().padTop(10).padLeft(-150);
                       table.add(WheatLabel).expandX().padTop(10).padLeft(-350);
                       table.add(TomatoesLabel).expandX().padTop(10).padLeft(-550);
                        table.add(OnionsLabel).expandX().padTop(10).padLeft(-750);
                        table.add(SauceLabel).expandX().padTop(10).padLeft(-950);
                         table.add(BreadLabel).expandX().padTop(10).padLeft(-1150);
                         table.add(LevelLabel).expandX().padTop(10).padLeft(-1350);
		       table.row();
		       table.add(coinsRecord).expandX().padLeft(-150);
                       table.add(Wheat).expandX().padLeft(-350);
                       table.add(Tomatoes).expandX().padLeft(-550);
                       table.add(Onions).expandX().padLeft(-750);
                        table.add(Sauce).expandX().padLeft(-950);
                         table.add(Bread).expandX().padLeft(-1150);
                         table.add(Level).expandX().padLeft(-1350);
                        
		  
                       
                       
                       coinsRecord.setText(String.format("%06d", Item.TCash));
                       Wheat.setText(String.format("%06d", Item.numberOfWheat));
                       Tomatoes.setText(String.format("%06d", Item.numberOfTomatoes));
                       Onions.setText(String.format("%06d", Item.numberOfOnions));
                       Sauce.setText(String.format("%06d", Item.numberOfSauce));
                       Bread.setText(String.format("%06d", Item.numberOfBread));
                       Level.setText(String.format("%06d", Item.Level));
                       
                      
                  
		       stage.addActor(table);
                       
                        
                 }
                
                 
        public void dispose()
        {
            stage.dispose();
           
        }
                 
}
