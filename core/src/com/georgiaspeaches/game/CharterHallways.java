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
		camera.setToOrtho(false, 1200, 900);
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
		batch.draw(tile1, 64, 64);
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
		int x = 0;
		while(x <= 1200)
		{
			batch.draw(grass, x, 0);
			batch.draw(grass, x, 16);
			batch.draw(grass, x, 900-16);
			batch.draw(grass, x, 900-32);
			batch.draw(grass, 0, x);
			batch.draw(grass, 16, x);
			batch.draw(grass, 1200-16, x);
			batch.draw(grass, 1200-32, x);
			x+=16;
		}
	}
	public void drawBrick()
	{
		int x = 32;
		while(x <= 1200-32-16)
		{
			batch.draw(brick, x, 900-64+16);
			batch.draw(brick, x, 900-64);
			x+=16;
		}
	}
}