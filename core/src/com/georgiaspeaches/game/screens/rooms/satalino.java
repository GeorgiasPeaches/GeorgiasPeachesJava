package com.georgiaspeaches.game.screens.rooms;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.georgiaspeaches.game.MainHalls;
import com.georgiaspeaches.game.entities.Player;
import com.georgiaspeaches.game.screens.Play;

public class Satalino implements Screen
{
	final MainHalls game;
	public Satalino(MainHalls game)
	{
		this.game = game;
	}

	@Override
	public void show()
	{
		System.out.println("Fuck you");
	}

	@Override
	public void render(float delta)
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
