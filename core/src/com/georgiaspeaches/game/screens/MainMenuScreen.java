package com.georgiaspeaches.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.georgiaspeaches.game.MainHalls;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

public class MainMenuScreen implements Screen
{

	final MainHalls game;
	Texture cswLogo;
	OrthographicCamera camera;

	public MainMenuScreen(final MainHalls game)
	{
		this.game = game;
		cswLogo = new Texture(Gdx.files.internal("maps/CSW-Logo.jpg"));
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
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		game.batch.setProjectionMatrix(camera.combined);

		game.batch.begin();
		game.font.draw(game.batch, "Welcome to Charter Hallways.", 100, 150);
		game.font.draw(game.batch, "Click space to spawn!", 100, 100);
		game.batch.draw(cswLogo, 100, 880-500);
		game.batch.end();

		if(Gdx.input.isKeyPressed(Input.Keys.SPACE))
		{
			game.setScreen(new Play(game));
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
