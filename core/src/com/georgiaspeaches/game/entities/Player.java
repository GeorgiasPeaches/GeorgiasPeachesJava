package com.georgiaspeaches.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Player
{
	SpriteBatch sb;
	Texture texture;
	Sprite sprite;
	float myX = 58*16, myY = 97*16, speed = 80f;
	int x = (int)myX/16;
	int y = (int)myY/16;

	public Player()
	{
		super();
		sb = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("maps/piq.png"));
		sprite = new Sprite(texture);
		sprite.setPosition(myX, myY);
	}

	public void render(OrthographicCamera camera)
	{
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		sprite.draw(sb);
		sprite.setPosition(myX, myY);
		sb.end();
	}

	public void update(boolean mapArray[][]){
		int currentX = (int)myX/16;
		int currentY = (int)myY/16;
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
		{
			if(!mapArray[currentX-1][currentY])
				myX -= Gdx.graphics.getDeltaTime() * speed;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
		{
			if(!mapArray[currentX+1][currentY])
				myX += Gdx.graphics.getDeltaTime() * speed;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.UP))
		{
			if(!mapArray[currentX][currentY+1])
				myY += Gdx.graphics.getDeltaTime() * speed;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
		{
			if(!mapArray[currentX][currentY-1])
				myY -= Gdx.graphics.getDeltaTime() * speed;
		}
	}
	public void setPos(float x, float y)
	{
		x = this.myX;
		y = this.myY;
	}

	public float getX()
	{
		return myX;
	}
	public float getY()
	{
		return myY;
	}
}
