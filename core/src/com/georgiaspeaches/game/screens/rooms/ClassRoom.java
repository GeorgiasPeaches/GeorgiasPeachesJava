package com.georgiaspeaches.game.screens.rooms;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.georgiaspeaches.game.MainHalls;
import com.georgiaspeaches.game.entities.Player;
import com.georgiaspeaches.game.screens.Play;
import com.sun.org.apache.bcel.internal.generic.SALOAD;

public class ClassRoom implements Screen
{
	final MainHalls game;
	TiledMap tiledMap;
	OrthographicCamera camera;
	TiledMapRenderer tiledMapRenderer;
	Player player;
	int roomNumber;
	boolean mapArray[][] = new boolean[200][200];
	SpriteBatch spriteBatch;
	int spawnX, spawnY;
	public ClassRoom(MainHalls game, Player player, int roomNumber)
	{
		this.game = game;
		this.player = player;
		this.roomNumber = roomNumber;
		spriteBatch = new SpriteBatch();
		System.out.println("You are in room: "+roomNumber);
		runRoom(roomNumber);
	}

	@Override
	public void show()
	{
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera();
		camera.setToOrtho(false,w,h);
		camera.update();
		tiledMap = new TmxMapLoader().load("maps/classroom.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
		setBlocked();
		player.setPos(61*16, 34*16);

	}

	private void setBlocked()
	{
		for (int i = 0; i < tiledMap.getLayers().getCount(); i++) {
			TiledMapTileLayer layer = (TiledMapTileLayer) tiledMap.getLayers().get(i);
			for (int y = 0; y < layer.getHeight(); y++) {
				for (int x = 0; x < layer.getWidth(); x++) {
					if (layer.getCell(x, y) != null
							&& layer.getCell(x, y).getTile().getProperties()
									.containsKey("blocked")) {
						this.mapArray[x][y] = true;
					}
				}
			}
		}
	}

	@Override
	public void render(float delta)
	{
		int currentX = (int)player.getX()/16;
		int currentY = (int)player.getY()/16;
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.position.set(68*16, 45*16, 0);
		camera.update();
		tiledMapRenderer.setView(camera);
		tiledMapRenderer.render();
		player.render(camera);
		player.update(mapArray);

		if((currentX == 59 && currentY == 33)||
				(currentX == 58 && currentY == 33)||
				(currentX == 60 && currentY == 33)||
				(currentX == 59 && currentY == 32)||
				(currentX == 59 && currentY == 34)||
				(currentX == 60 && currentY == 34)||
				(currentX == 58 && currentY == 34)||
				(currentX == 58 && currentY == 32)||
				(currentX == 60 && currentY == 32))
		{
			spriteBatch.begin();
			game.font.draw(spriteBatch, "Click E to exit!", 615, 300-120);
			spriteBatch.end();
			if(Gdx.input.isKeyJustPressed(Input.Keys.E))
			{
				tiledMap.dispose();
				player.setPos(spawnX, spawnY);
				game.setScreen(new Play(game, player));
			}
		}

		if((currentX == 81 && currentY == 33)||
				(currentX == 82 && currentY == 33)||
				(currentX == 83 && currentY == 33)||
				(currentX == 81 && currentY == 32)||
				(currentX == 81 && currentY == 34)||
				(currentX == 82 && currentY == 34)||
				(currentX == 83 && currentY == 34)||
				(currentX == 82 && currentY == 32)||
				(currentX == 83 && currentY == 32))
		{
			spriteBatch.begin();
			game.font.draw(spriteBatch, "Click E to work!", 615, 300-120);
			spriteBatch.end();
			if(Gdx.input.isKeyJustPressed(Input.Keys.E))
			{
				runClasswork(roomNumber);
			}
		}

		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
		{
			tiledMap.dispose();
			player.setPos(77*16, 99*16);
			game.setScreen(new Play(game, player));
		}
	}


	public void runRoom(int roomNumber)
	{
		switch(roomNumber)
		{
			case 311:
				new Satalino(game, player, roomNumber);
				spawnX = Satalino.x*16;
				spawnY = Satalino.y*16;
		}
	}

	public void runClasswork(int roomNumber)
	{
		switch(roomNumber)
		{
			case 311:
				Satalino.work(player);
			case 306:
				Payne.work(player);
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
