package com.spaceship;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Shoot {
	final float SPEED = 2;
	
	private Texture sprite;
	float x, y;
	float xBound, yBound;
	
	
	
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
		
		atualizeBounds();
		
	}
	public void atualizeBounds() {
		this.xBound = this.x + 10;
		this.yBound = this.y + 10;
		
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	public void moveShoot() {
		this.y += SPEED;
	}
	
	
	

}
