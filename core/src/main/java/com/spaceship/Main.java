package com.spaceship;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;


/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture bgGroundImage;
    private Nave nave;
    public Shoot shoot;
    ArrayList<Shoot> arrayOfShoots;
    private ShapeRenderer sp;

    @Override
    public void create() {
        batch = new SpriteBatch();
        bgGroundImage = new Texture("Space-background600x360.png");
        nave = new Nave("Hor_strip_pulse.png", 33, 32, 10, 150, 150);
        arrayOfShoots = new ArrayList<>();
        
         sp =  new ShapeRenderer();
    }

    @Override
    public void render() {
    	nave.moveNave();

    	fetchIfShoot();
    	
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(bgGroundImage, 0, 0);
        
        nave.renderAnimation(batch);
        

//    	sp.begin(ShapeRenderer.ShapeType.Filled);
//    	sp.setColor(1,1,1,1);
//    	sp.circle(100, 100, 2);
//    	sp.end();
    	
    	System.out.println(nave.getWidth() +" "+ nave.getHeight());
    	
        renderShoots();
        filterActiveShoots();
        moveShootControler();
              
        nave.atualizarAnima(0.3f);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        bgGroundImage.dispose();
    }
    
   private void renderShoots() {	   
       if(shoot != null) {
    	   shoot.renderShoot(batch);	
       }
       for (Shoot shoot : arrayOfShoots) {
			shoot.renderShoot(batch);
		}
 
   }
   private void filterActiveShoots(){
	  
		arrayOfShoots.removeIf(shoot -> shoot.getY() > 360);
			
			
			
   }
   private void  moveShootControler() {
	   for (Shoot shoot : arrayOfShoots) {
		shoot.moveShoot();
	   }
   
   }
   
   private void fetchIfShoot() {
	   if(nave.ShootNave()) {
   		shoot = new Shoot("shootNaveMain.png", nave.getX(), nave.getY());
   		arrayOfShoots.add(shoot);
   		
   		} 	
	   
   }
   
   private void fetchColision() {
	
   }


}
    
   

