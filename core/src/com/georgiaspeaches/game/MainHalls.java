package com.georgiaspeaches.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.georgiaspeaches.game.entities.Player;
import com.georgiaspeaches.game.screens.MainMenuScreen;


public class MainHalls extends Game {

	public SpriteBatch batch;
	public BitmapFont font;
	public BitmapFont fontLarge, fontSmall, fontSmaller;
	public Skin skin;

	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("maps/ugh.fnt"));
		fontLarge = new BitmapFont(Gdx.files.internal("maps/ughlarge.fnt"));
		fontSmall = new BitmapFont(Gdx.files.internal("maps/ughsmall.fnt"));
		fontSmaller = new BitmapFont(Gdx.files.internal("maps/ughsmaller.fnt"));
		setScreen(new MainMenuScreen(this));
	}

	public Skin createBasicSkin()
	{
		//Create a font
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

		return skin;
	}

	public void render() {
		super.render();
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
		fontLarge.dispose();
		fontSmall.dispose();
		fontSmaller.dispose();
	}
}
