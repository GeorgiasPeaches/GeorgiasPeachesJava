package com.georgiaspeaches.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.georgiaspeaches.game.MainHalls;
import com.georgiaspeaches.game.screens.rooms.ClassRoom;
import com.georgiaspeaches.game.utilities.DoorLoader;


public class Player
{
	SpriteBatch sb;
	Sprite sprite;
	Texture texture;
	float myX = 58*16, myY = 97*16, speed = 80f;
	int x = (int)myX/16;
	int y = (int)myY/16;
	SpriteBatch spriteBatch;
	BitmapFont font, fontsmall, fontsmaller;
	ShapeRenderer mShapeRenderer;
	CharSequence str = "Cheats Enabled [NOCLIP + SPEED]";
	public int classYear;
	public double myGPA;
	public Door[][] myDoors;
	final MainHalls game;

	public Player(MainHalls game)
	{
		initialize();
		classYear = 9;
		myGPA = 1;
		this.game = game;
	}
	public Player(int classYear, double myGPA, MainHalls game)
	{
		initialize();
		this.classYear = classYear;
		this.myGPA = myGPA;
		this.game = game;
	}

	public void initialize()
	{
		sb = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("maps/piq.png"));
		sprite = new Sprite(texture);
		font = new BitmapFont(Gdx.files.internal("maps/ugh.fnt"));
		fontsmall = new BitmapFont(Gdx.files.internal("maps/ughsmall.fnt"));
		fontsmaller = new BitmapFont(Gdx.files.internal("maps/ughsmaller.fnt"));
		sprite.setPosition(myX, myY);
		spriteBatch = new SpriteBatch();
		mShapeRenderer = new ShapeRenderer();
		myDoors = DoorLoader.doors;
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
		spriteBatch.begin();
		fontsmaller.draw(spriteBatch, "Position: ("+currentX+", "+currentY+")", 10, 15);
		spriteBatch.end();
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
			speed = 180f;
			spriteBatch.begin();
			font.draw(spriteBatch, str, 100, 500);
			spriteBatch.end();
		}
		else
		{
			speed = 80f;
		}
		if(myDoors[currentX][currentY].roomNumber != 0)
		{
			spriteBatch.begin();
			font.draw(spriteBatch, "Click E to enter room: " + myDoors[currentX][currentY].roomNumber, 550, 300);
			spriteBatch.end();
			if(Gdx.input.isKeyPressed(Input.Keys.E))
			{
				enterRoom(myDoors[currentX][currentY].roomNumber);
			}
		}
		if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))
		{
			classYear++;
		}
		drawHUD();
		spriteBatch.begin();
		font.draw(spriteBatch, "GPA: "+myGPA, 1280/2-30, 880-100-5);
		fontsmaller.draw(spriteBatch, "Class Year: "+classYear, 1280-300+80, 880-100-15);
		spriteBatch.end();
	}

	private void enterRoom(int roomNumber)
	{
		dispose();
		game.setScreen(new ClassRoom(game, this, roomNumber));
	}

	public void setPos(float x, float y)
	{
		this.myX = x;
		this.myY = y;
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
		mShapeRenderer.rect(400+2, 880-130+2, (int)myGPA*100, 30-4);
		mShapeRenderer.end();
		//right top bar
		mShapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		mShapeRenderer.setColor(new Color(50, 50, 50, 0.5f));
		mShapeRenderer.rect(1280-300, 880-100-100, 300-20, 100);
		mShapeRenderer.end();
		Gdx.gl.glDisable(GL20.GL_BLEND);
	}

	public void dispose()
	{
		return;
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
