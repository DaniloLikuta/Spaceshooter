package com.spaceship;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

// import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Nave {
	private Texture sprite;
	private Animation<TextureRegion> animation;
	private float animationDelay;
	
	float x;
	float y;
	float speed = 6;
	float xBound;
	float yBound;
	float width;
	float height;
	
//	public Nave(String sprite,int x, int y) {
//		this.sprite = new Texture(sprite);
//		this.x = x;
//		this.y = y;
//			
//	}
	public Nave(String sprite, int width, int height, int numOfFrames, float x,  float y) {
		this.sprite = new Texture(Gdx.files.internal(sprite));
		TextureRegion[][] frames = TextureRegion.split(this.sprite, width, height);
		
		  TextureRegion[] arrayFrames = new TextureRegion[numOfFrames];
	        for (int i = 0; i < numOfFrames; i++) {
	            arrayFrames[i] = frames[0][i];
	        }
	        animation = new Animation<>(0.2f, arrayFrames); // Tempo entre frames = 0.1s
	        animationDelay = 0f;
	        
	        this.x = x;
	        this.y = y;    
	        this.width = width;
	        this.height = height;
	        this.xBound = x +this.width;
	        this.yBound = y +this.height;
	      
	}
	
	public void moveNave() {
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {							
			x -= speed;
			
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			x += speed;
		}	
		if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
			y += speed;	
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			y -= speed;	
		}
		
	}
	public boolean ShootNave(){
		if(Gdx.input.isKeyPressed(Input.Keys.S)) {
		return true;
		}
		return false;
	}
	
	
//	public void renderNave(SpriteBatch batch) {
//		batch.draw(sprite, x, y);
//		
//	}
	
	public void dispose() {
		sprite.dispose();
	
	}
	public void atualizarAnima(float delta) {
        animationDelay += delta;
        
        
        this.xBound = x + width;
        this.yBound = y + height;

    }
	
	public void renderAnimation(SpriteBatch batch) {
		  TextureRegion frameAtual = animation.getKeyFrame(animationDelay, true);
		 
		  
		  batch.draw(frameAtual, x , y );
		  
		
	}
	
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getWidth() {
		return width;
	
	}
	public float getHeight() {
		return height;
	
	}
	
	
	
	
	
	
}
