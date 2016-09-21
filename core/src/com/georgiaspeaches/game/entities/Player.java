package com.georgiaspeaches.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Player
{
	SpriteBatch sb;
	Sprite sprite;
	Texture texture;
	float myX = 58*16, myY = 97*16, speed = 80f;
	int x = (int)myX/16;
	int y = (int)myY/16;
	SpriteBatch spriteBatch;
	BitmapFont font;
	CharSequence str = "Cheats Enabled [NOCLIP]";

	public Player()
	{
		super();
		sb = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("maps/piq.png"));
		sprite = new Sprite(texture);
		font = new BitmapFont();
		sprite.setPosition(myX, myY);
		spriteBatch = new SpriteBatch();
		font = new BitmapFont();

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
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A))
		{
			if(!mapArray[currentX-1][currentY] || Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT))
				myX -= Gdx.graphics.getDeltaTime() * speed;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D))
		{
			if(!mapArray[currentX+1][currentY] || Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT))
				myX += Gdx.graphics.getDeltaTime() * speed;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W))
		{
			if(!mapArray[currentX][currentY+1] || Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT))
				myY += Gdx.graphics.getDeltaTime() * speed;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S))
		{
			if(!mapArray[currentX][currentY-1] || Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT))
				myY -= Gdx.graphics.getDeltaTime() * speed;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT))
		{
			speed = 150f;
			spriteBatch.begin();
			font.draw(spriteBatch, str, 100, 500);
			spriteBatch.end();
		}
		else
		{
			speed = 80f;
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
