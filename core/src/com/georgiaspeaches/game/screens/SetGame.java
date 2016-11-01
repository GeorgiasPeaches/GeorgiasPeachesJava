package com.georgiaspeaches.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.georgiaspeaches.game.MainHalls;

public class SetGame implements Screen
{
	Skin skin;
	final MainHalls game;
	Stage stage = new Stage();
	BitmapFont font;
	BitmapFont fontLarge;
	SpriteBatch spriteBatch;

	public SetGame(MainHalls game, Skin skin)
	{
		this.skin = skin;
		this.game = game;

		Gdx.input.setInputProcessor(stage);
		spriteBatch = new SpriteBatch();

	}

	@Override
	public void show()
	{

	}

	@Override
	public void render(float delta)
	{
		Gdx.gl.glClearColor(0x64/255.0f, 0x95/255.0f, 0xed/255.0f, 0xff/255.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
		fontLarge.draw(spriteBatch, "Charter Game", (Gdx.graphics.getWidth()/2 - Gdx.graphics.getWidth()/8)-70 , (Gdx.graphics.getHeight()/2)+300);
		spriteBatch.end();

		TextField gpaEntry = new TextField("", skin);
		gpaEntry.setText("Kobe");
		gpaEntry.setPosition(50, 50);
		stage.addActor(gpaEntry);
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
