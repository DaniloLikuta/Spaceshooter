package com.spaceship;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Shoot {
	final float SPEED = 6;
	
	private Texture sprite;
	float x, y;
	
	
	private boolean isOver =  false;
	
	public Shoot(String sprite, float posiX, float posiY) {
		this.sprite = new Texture(sprite);
		this.x = posiX;
		this.y = posiY;
	}

	public boolean isOver() {
		return isOver;
	}

	public void setOver(boolean isOver) {
		this.isOver = isOver;
	}
	
	public void renderShoot(SpriteBatch batch) {
		batch.draw(sprite, x, (y + 20));
		
	}
	

}
