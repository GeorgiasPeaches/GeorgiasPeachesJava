package com.georgiaspeaches.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * com.georgiaspeaches.game
 * [Description]
 * <p/>
 * [Variable Dictionary]
 *
 * @author ${user}
 * @version ${date}
 */
public class GameScreen implements Screen
{
	final MainHalls game;
	public Texture tile1;
	public Texture brick;
	public Texture grass;
	public Rectangle tile1render;
	public OrthographicCamera camera;
	public GameScreen(final MainHalls gam)
	{
		this.game = gam;
		tile1 = new Texture(Gdx.files.internal("tile1.png"));
		brick = new Texture(Gdx.files.internal("brick.png"));
		grass = new Texture(Gdx.files.internal("grass.png"));
		tile1render = new Rectangle();
		tile1render.width = 16;
		tile1render.height = 16;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1280, 880);
	}

	@Override
	public void show()
	{

	}

	@Override
	public void render(float delta)
	{
		camera.update();

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		game.batch.setProjectionMatrix(camera.combined);
		game.batch.begin();
		drawGrass();
		drawBrick();
		drawTiles();
		game.batch.end();
	}

	@Override
	public void resize(int width, int height)
	{

	}

	@Override
	public void pause()
	{

	}

	@Override
	public void resume()
	{

	}

	@Override
	public void hide()
	{

	}

	@Override
	public void dispose()
	{

	}

	public void drawGrass()
	{
		for(int x = 1; x<=80; x++)
		{
			for(int y = 1; y<=55; y++)
			{
				game.batch.draw(grass, getXValue(x), getYValue(y));
			}
		}
	}
	public void drawBrick()
	{
		for(int x = 3; x<=80-4; x++)
		{
			game.batch.draw(brick, getXValue(x), getYValue(3));
			game.batch.draw(brick, getXValue(x), getYValue(4));
		}
		for(int x = 5; x<=10; x++)
		{
			game.batch.draw(brick, getXValue(3), getYValue(x));
			game.batch.draw(brick, getXValue(4), getYValue(x));
		}
		for(int x = 3; x<=26; x++)
		{
			game.batch.draw(brick, getXValue(x), getYValue(11));
			game.batch.draw(brick, getXValue(x), getYValue(12));
		}
	}
	public void drawTiles()
	{
		for(int x = 5; x<=80-4; x++)
		{
			game.batch.draw(tile1, getXValue(x), getYValue(5));
			game.batch.draw(tile1, getXValue(x), getYValue(6));
			game.batch.draw(tile1, getXValue(x), getYValue(7));
			game.batch.draw(tile1, getXValue(x), getYValue(8));
			game.batch.draw(tile1, getXValue(x), getYValue(9));
			game.batch.draw(tile1, getXValue(x), getYValue(10));
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
