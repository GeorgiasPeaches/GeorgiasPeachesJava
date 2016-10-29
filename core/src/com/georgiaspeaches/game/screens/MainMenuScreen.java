package com.georgiaspeaches.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.georgiaspeaches.game.MainHalls;

public class MainMenuScreen implements Screen
{

	final MainHalls game;
	Skin skin;
	Stage stage = new Stage();
	BitmapFont font;
	BitmapFont fontLarge;
	SpriteBatch spriteBatch;

	public MainMenuScreen(final MainHalls game)
	{
		this.game = game;
		Gdx.input.setInputProcessor(stage);
		spriteBatch = new SpriteBatch();

		createBasicSkin();

		makeButtons();
	}

	private void makeButtons()
	{
		//initilize buttons
		TextButton newGameButton = new TextButton("New Game", skin);
		newGameButton.setPosition(Gdx.graphics.getWidth()/2 - Gdx.graphics.getWidth()/8 , Gdx.graphics.getHeight()/2);
		newGameButton.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				game.setScreen(new Play(game));
			}
		});

		TextButton continueButton = new TextButton("Continue Game", skin);
		continueButton.setPosition(Gdx.graphics.getWidth()/2 - Gdx.graphics.getWidth()/8 , (Gdx.graphics.getHeight()/2)-85);
		continueButton.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				game.setScreen(new Play(game));
			}
		});

		TextButton settingsButton = new TextButton("Settings", skin);
		settingsButton.setPosition(Gdx.graphics.getWidth()/2 - Gdx.graphics.getWidth()/8 , (Gdx.graphics.getHeight()/2)-170);
		settingsButton.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) {
				game.setScreen(new Play(game));
			}
		});
		//add stages
		stage.addActor(newGameButton);
		stage.addActor(continueButton);
		stage.addActor(settingsButton);
	}

	private void createBasicSkin()
	{
		//Create a font
		font = new BitmapFont(Gdx.files.internal("maps/ugh.fnt"));
		fontLarge = new BitmapFont(Gdx.files.internal("maps/ughlarge.fnt"));
		skin = new Skin();
		skin.add("default", font);

		//Create a texture
		Pixmap pixmap = new Pixmap((int)Gdx.graphics.getWidth()/4,(int)Gdx.graphics.getHeight()/10, Pixmap.Format.RGB888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		skin.add("background",new Texture(pixmap));

		//Create a button style
		TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
		textButtonStyle.up = skin.newDrawable("background", Color.GRAY);
		textButtonStyle.down = skin.newDrawable("background", Color.DARK_GRAY);
		textButtonStyle.checked = skin.newDrawable("background", Color.DARK_GRAY);
		textButtonStyle.over = skin.newDrawable("background", Color.LIGHT_GRAY);
		textButtonStyle.font = skin.getFont("default");
		skin.add("default", textButtonStyle);

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
