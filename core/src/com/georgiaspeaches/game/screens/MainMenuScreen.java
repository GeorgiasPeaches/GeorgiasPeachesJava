package com.georgiaspeaches.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.georgiaspeaches.game.MainHalls;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.util.InputValidator;
import com.kotcrab.vis.ui.util.Validators;
import com.kotcrab.vis.ui.widget.VisDialog;
import com.kotcrab.vis.ui.widget.VisTextButton;
import com.kotcrab.vis.ui.widget.VisValidatableTextField;

public class MainMenuScreen implements Screen
{

	final MainHalls game;
	Stage stage = new Stage();

	public MainMenuScreen(final MainHalls game)
	{
		this.game = game;
		VisUI.load(VisUI.SkinScale.X2);
		Gdx.input.setInputProcessor(stage);
		game.batch = new SpriteBatch();
		makeButtons();
	}

	private void makeButtons()
	{
		//initilize buttons
		TextButton newGameButton = new VisTextButton("New Game");
		newGameButton.setPosition(Gdx.graphics.getWidth()/2 - Gdx.graphics.getWidth()/8 , Gdx.graphics.getHeight()/2);
		newGameButton.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				game.setScreen(new Play(game));
			}
		});

		TextButton continueButton = new VisTextButton("Set Game Progress");
		continueButton.setPosition(Gdx.graphics.getWidth()/2 - Gdx.graphics.getWidth()/8 , (Gdx.graphics.getHeight()/2)-85);
		continueButton.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				stage.clear();
				VisValidatableTextField gpa = new VisValidatableTextField();
				gpa.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
				gpa.addValidator(new Validators.FloatValidator());
				stage.addActor(gpa);
				//game.setScreen(new Play(game));
			}
		});

		TextButton settingsButton = new VisTextButton("Settings");
		settingsButton.setPosition(Gdx.graphics.getWidth()/2 - Gdx.graphics.getWidth()/8 , (Gdx.graphics.getHeight()/2)-170);
		settingsButton.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				game.setScreen(new Play(game));
			}
		});
		//add stages
		stage.addActor(newGameButton);
		//stage.addActor(continueButton);
		stage.addActor(settingsButton);
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
		game.batch.begin();
		game.fontLarge.draw(game.batch, "Charter Game", (Gdx.graphics.getWidth()/2 - Gdx.graphics.getWidth()/8)-70 , (Gdx.graphics.getHeight()/2)+300);
		game.batch.end();

		stage.act();
		stage.draw();
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
