package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Map;
import javax.lang.model.SourceVersion;

public class WheatFactory extends Factory {
    
 private Texture TFactory;
 private Texture TMark;
 private Texture TMove;
  private boolean clickCollect = false;
  private int factoryStatus=1;
  long beginTime;

    public WheatFactory(int posX, int posY, int numOfItems) {
        super(posX, posY, numOfItems);
    }
    
 @Override
    public void drawFactory(SpriteBatch Batch)
    {
        if(this.factoryStatus==1)
        {
            TFactory=new Texture(Gdx.files.internal("house 4.png"));
            TMove=new Texture(Gdx.files.internal("Move.png"));
             Batch.draw(TFactory, super.getItemposX() * Map.entityScaleX, super.getItemPosY()* Map.entityScaleY, Map.entityScaleX*3, Map.entityScaleY*3);
             Batch.draw(TMove, super.getItemposX() * Map.entityScaleX, super.getItemPosY()* Map.entityScaleY, Map.entityScaleX, Map.entityScaleY);

        }
        else if(this.factoryStatus==2)
        {
            
              TFactory=new Texture(Gdx.files.internal("house 4.png"));
               TMove=new Texture(Gdx.files.internal("Move.png"));
              TMark=new Texture(Gdx.files.internal("loading.png"));
             Batch.draw(TFactory, super.getItemposX() * Map.entityScaleX, super.getItemPosY()* Map.entityScaleY, Map.entityScaleX*3, Map.entityScaleY*3);
             Batch.draw(TMark,( super.ItemPosX+1)*Map.entityScaleX,((super.getItemPosY()+3)* Map.entityScaleY)+20, Map.entityScaleX, Map.entityScaleY );
             Batch.draw(TMove, super.getItemposX() * Map.entityScaleX, super.getItemPosY()* Map.entityScaleY, Map.entityScaleX, Map.entityScaleY);
             this.RunFactory();

        }
        else if(this.factoryStatus==3)
        {
            TFactory=new Texture(Gdx.files.internal("house 4.png"));
            TMark=new Texture(Gdx.files.internal("RightMark.png"));
             TMove=new Texture(Gdx.files.internal("Move.png"));
             Batch.draw(TFactory, super.getItemposX() * Map.entityScaleX, super.getItemPosY() * Map.entityScaleY, Map.entityScaleX*3, Map.entityScaleY*3);
             Batch.draw(TMark, (super.ItemPosX+1)*Map.entityScaleX,((super.getItemPosY())* Map.entityScaleY+3)+20, Map.entityScaleX, Map.entityScaleY );
             Batch.draw(TMove, super.getItemposX() * Map.entityScaleX, super.getItemPosY()* Map.entityScaleY, Map.entityScaleX, Map.entityScaleY);

        }
        this.move();
        this.PutCrops();
        this.Collect();
    }
 
    
 @Override
    public void PutCrops()
    {
        if(Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)&&this.clickCollect && factoryStatus==1)
        {
            if(Factory.numberOfWheat>=1)
            {
            factoryStatus=2;
            beginTime= System.currentTimeMillis() / 1000; 
            super.numberOfWheat--;
            }
         
        }
        else if (super.getItemposX() == Map.posJ && super.getItemPosY()== Map.posI)
        {
            this.clickCollect=true;
        }
        else
        {
            this.clickCollect=false;
        }
        
       
        
    }
 @Override
    public void RunFactory()
    {
        long CurrentTime=System.currentTimeMillis()/1000;
        
        if(CurrentTime-beginTime==10)
        {
            this.factoryStatus=3;
        }
    }

 
 @Override
    public void Collect() {
        if(factoryStatus==3 && Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)&&this.clickCollect  )
        {
            factoryStatus=1;
         Factory.numberOfBread++;
              
        }else if (super.getItemposX() == Map.posJ && super.getItemPosY()== Map.posI)
        {
            this.clickCollect=true;
        }
        else
        {
            this.clickCollect=false;
        }

        
    }

 
    @Override
    public void dispose() {
        this.TFactory.dispose();
        this.TMark.dispose();
        this.TMove.dispose();
    }   
    
}
