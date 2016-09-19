package com.georgiaspeaches.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MainMenuScreen implements Screen
{

	final MainHalls game;

	OrthographicCamera camera;

	public MainMenuScreen(final MainHalls gam)
	{
		game = gam;

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
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		game.batch.setProjectionMatrix(camera.combined);

		game.batch.begin();
		game.font.draw(game.batch, "Welcome to Charter Hallways.", 100, 150);
		game.font.draw(game.batch, "Click space to begin!", 100, 100);
		game.batch.end();

		if(Gdx.input.isKeyPressed(Input.Keys.SPACE))
		{
			game.setScreen(new TiledMapLoader());
			dispose();
		}
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

}
