package com.georgiaspeaches.game;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
//80*55 grid
public class CharterHallways implements ApplicationListener {
	public SpriteBatch batch;
	public BitmapFont font;
	public Texture tile1;
	public Texture brick;
	public Texture grass;
	public Rectangle tile1render;
	public OrthographicCamera camera;

	@Override
	public void create() {
		tile1 = new Texture(Gdx.files.internal("tile1.png"));
		brick = new Texture(Gdx.files.internal("brick.png"));
		grass = new Texture(Gdx.files.internal("grass.png"));
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		tile1render = new Rectangle();
		tile1render.width = 16;
		tile1render.height = 16;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1280, 880);
	}

	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		drawGrass();
		drawBrick();
		//drawTiles();
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	public void drawGrass()
	{
		for(int x = 0; x<=80; x++)
		{
			for(int y = 0; y<=55; y++)
			{
				batch.draw(grass, getXValue(x), getYValue(y));
			}
		}
	}
	public void drawBrick()
	{
		for(int x = 0; x<=80; x++)
		{
			batch.draw(brick, getXValue(x), getYValue(1));
			batch.draw(brick, getXValue(x), getYValue(2));
		}
	}
	public void drawTiles()
	{
		int x = 32+32;
		while(x <= 1280-32-16-36)
		{
			batch.draw(tile1, x, 960-64+16-32);
			batch.draw(tile1, x, 960-64-32);
			batch.draw(tile1, x, 960-64-32-16);
			batch.draw(tile1, x, 960-64-32-32);
			batch.draw(tile1, x, 960-64-32-48);
			batch.draw(tile1, x, 960-64-32-64);
			x+=16;
		}
		for(int i = 64; i<900-5*16; i+=16)
		{
			batch.draw(tile1, 23*16, i);
			batch.draw(tile1, 23*16+16, i);
			batch.draw(tile1, 23*16+32, i);
			batch.draw(tile1, 23*16+48, i);
			batch.draw(tile1, 23*16+64, i);
			batch.draw(tile1, 23*16+80, i);
		}
	}
	public int getYValue(int y)
	{
		y = 880 - 16*y;
		return y;
	}
	public int getXValue(int x)
	{
		x = 16*x;
		return x-16;
	}
}