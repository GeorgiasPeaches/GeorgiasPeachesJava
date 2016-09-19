package com.georgiaspeaches.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.georgiaspeaches.game.MainHalls;
import com.georgiaspeaches.game.TiledMapLoader;

public class DesktopLauncher
{
	public static void main(String[] arg)
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Charter Halls";
		config.width = 1280;
		config.height = 880;
		new LwjglApplication(new TiledMapLoader(), config);
	}
}