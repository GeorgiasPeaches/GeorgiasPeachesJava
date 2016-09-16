package com.georgiaspeaches.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

/**
 * com.georgiaspeaches.game
 * [Description]
 * </p>
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
	public Texture stairs;
	public OrthographicCamera camera;

	public GameScreen(final MainHalls gam)
	{
		game = gam;
		tile1 = new Texture(Gdx.files.internal("tile1.png"));
		brick = new Texture(Gdx.files.internal("brick.png"));
		grass = new Texture(Gdx.files.internal("grass.png"));
		stairs = new Texture(Gdx.files.internal("stairs.png"));
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
		drawObjects();
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
		for(int x = 1; x <= 80; x++)
		{
			for(int y = 1; y <= 55; y++)
			{
				game.batch.draw(grass, getXValue(x), getYValue(y));
			}
		}
	}

	public void drawBrick()
	{
		for(int x = 3; x <= 80 - 4; x++)
		{
			game.batch.draw(brick, getXValue(x), getYValue(3));
			game.batch.draw(brick, getXValue(x), getYValue(4));
		}
		for(int x = 26 + 10; x <= 80 - 4; x++)
		{
			game.batch.draw(brick, getXValue(x), getYValue(11));
			game.batch.draw(brick, getXValue(x), getYValue(12));
		}
		for(int x = 3; x <= 12; x++)
		{
			game.batch.draw(brick, getXValue(80-2), getYValue(x));
			game.batch.draw(brick, getXValue(80-3), getYValue(x));
		}
		for(int x = 5; x <= 10; x++)
		{
			game.batch.draw(brick, getXValue(3), getYValue(x));
			game.batch.draw(brick, getXValue(4), getYValue(x));
		}
		for(int x = 3; x <= 26; x++)
		{
			game.batch.draw(brick, getXValue(x), getYValue(11));
			game.batch.draw(brick, getXValue(x), getYValue(12));
		}
		for(int x = 11; x <= 53; x++)
		{
			game.batch.draw(brick, getXValue(26), getYValue(x));
			game.batch.draw(brick, getXValue(27), getYValue(x));
		}
		for(int x = 11; x <= 53-8; x++)
		{
			game.batch.draw(brick, getXValue(26+8), getYValue(x));
			game.batch.draw(brick, getXValue(27+8), getYValue(x));
		}
		for(int x = 26; x <= 80 - 2 - 10; x++)
		{
			game.batch.draw(brick, getXValue(x), getYValue(53));
			game.batch.draw(brick, getXValue(x), getYValue(52));
		}
		for(int x = 26+8; x <= 80 - 10 - 10; x++)
		{
			game.batch.draw(brick, getXValue(x), getYValue(53-8));
			game.batch.draw(brick, getXValue(x), getYValue(52-8));
		}
		for(int x = 3; x <= 55-4; x++)
		{
			game.batch.draw(brick, getXValue(80 - 3 - 10), getYValue(x));
			game.batch.draw(brick, getXValue(80 - 2 - 10), getYValue(x));
		}
		for(int x = 11; x <= 55-4-8; x++)
		{
			game.batch.draw(brick, getXValue(80 - 3 - 8 - 10), getYValue(x));
			game.batch.draw(brick, getXValue(80 - 2 - 8 - 10), getYValue(x));
		}

	}

	public void drawTiles()
	{
		for(int x = 5; x <= 80 - 4; x++)
		{
			game.batch.draw(tile1, getXValue(x), getYValue(5));
			game.batch.draw(tile1, getXValue(x), getYValue(6));
			game.batch.draw(tile1, getXValue(x), getYValue(7));
			game.batch.draw(tile1, getXValue(x), getYValue(8));
			game.batch.draw(tile1, getXValue(x), getYValue(9));
			game.batch.draw(tile1, getXValue(x), getYValue(10));
		}
		for(int x = 28; x <= 80 - 4 - 10; x++)
		{
			game.batch.draw(tile1, getXValue(x), getYValue(51));
			game.batch.draw(tile1, getXValue(x), getYValue(50));
			game.batch.draw(tile1, getXValue(x), getYValue(49));
			game.batch.draw(tile1, getXValue(x), getYValue(48));
			game.batch.draw(tile1, getXValue(x), getYValue(47));
			game.batch.draw(tile1, getXValue(x), getYValue(46));
		}
		for(int x = 11; x <= 55-10; x++)
		{
			game.batch.draw(tile1, getXValue(28), getYValue(x));
			game.batch.draw(tile1, getXValue(29), getYValue(x));
			game.batch.draw(tile1, getXValue(30), getYValue(x));
			game.batch.draw(tile1, getXValue(31), getYValue(x));
			game.batch.draw(tile1, getXValue(32), getYValue(x));
			game.batch.draw(tile1, getXValue(33), getYValue(x));
		}
		for(int x = 11; x <= 55-10; x++)
		{
			game.batch.draw(tile1, getXValue(80-4-10), getYValue(x));
			game.batch.draw(tile1, getXValue(80-5-10), getYValue(x));
			game.batch.draw(tile1, getXValue(80-6-10), getYValue(x));
			game.batch.draw(tile1, getXValue(80-7-10), getYValue(x));
			game.batch.draw(tile1, getXValue(80-8-10), getYValue(x));
			game.batch.draw(tile1, getXValue(80-9-10), getYValue(x));
		}
	}

	public void drawObjects()
	{
		game.batch.draw(stairs, getXValue(3), getYValue(8));
	}

	public int getYValue(int y)
	{
		y = 880 - 16 * y;
		return y;
	}

	public int getXValue(int x)
	{
		x = 16 * x;
		return x - 16;
	}
}
