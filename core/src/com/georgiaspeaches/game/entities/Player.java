package com.georgiaspeaches.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


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
	ShapeRenderer mShapeRenderer;
	CharSequence str = "Cheats Enabled [NOCLIP + SPEED]";
	public int classYear;
	public int myGPA;

	public Player()
	{
		super();
		sb = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("maps/piq.png"));
		sprite = new Sprite(texture);
		font = new BitmapFont(Gdx.files.internal("maps/font.otf"));
		sprite.setPosition(myX, myY);
		spriteBatch = new SpriteBatch();
		mShapeRenderer = new ShapeRenderer();
		font = new BitmapFont();
		classYear = 9;
		myGPA = 1;
	}
	public Player(int classYear, int myGPA)
	{
		super();
		sb = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("maps/piq.png"));
		sprite = new Sprite(texture);
		font = new BitmapFont();
		sprite.setPosition(myX, myY);
		spriteBatch = new SpriteBatch();
		mShapeRenderer = new ShapeRenderer();
		font = new BitmapFont();
		this.classYear = classYear;
		this.myGPA = myGPA;
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
		if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))
		{
			classYear++;
		}
		drawHUD();
		spriteBatch.begin();
		font.draw(spriteBatch, "GPA: "+myGPA, 1280/2-20, 880-100-5);
		font.draw(spriteBatch, "Class Year: "+classYear, 1280-300+50, 880-100-100-50);
		spriteBatch.end();
	}
	public void setPos(float x, float y)
	{
		x = this.myX;
		y = this.myY;
	}

	public void drawHUD()
	{
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		//progress bar gpa
		mShapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		mShapeRenderer.setColor(new Color(1, 1, 1, 0.5f));
		mShapeRenderer.rect(400, 880-130, 500, 30);
		mShapeRenderer.setColor(new Color(1, 0, 1, 0.5f));
		mShapeRenderer.rect(400+2, 880-130+2, myGPA, 30-4);
		mShapeRenderer.end();
		//right top bar
		mShapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		mShapeRenderer.setColor(new Color(50, 50, 50, 0.5f));
		mShapeRenderer.rect(1280-300, 880-100-100, 300-20, 100);
		mShapeRenderer.end();
		Gdx.gl.glDisable(GL20.GL_BLEND);
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
