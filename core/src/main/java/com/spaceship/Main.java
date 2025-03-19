package com.spaceship;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture bgGroundImage;
    private Nave nave;
    public Shoot shoot;
    ArrayList<Shoot> arrayOfShoots;

    @Override
    public void create() {
        batch = new SpriteBatch();
        bgGroundImage = new Texture("Space-background600x360.png");
        nave = new Nave("Hor_strip_pulse.png", 33, 32, 10, 100, 100);
        arrayOfShoots = new ArrayList<>();
    }

    @Override
    public void render() {
    	nave.moveNave();
    	if(nave.ShootNave()) {
    		shoot = new Shoot("shootNaveMain.png", nave.getX(), nave.getY());
    		arrayOfShoots.add(shoot);
    		
    	};
    	
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(bgGroundImage, 0, 0);
        
        nave.renderAnimation(batch);
        
        renderShoots();
              
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
    
   
}
