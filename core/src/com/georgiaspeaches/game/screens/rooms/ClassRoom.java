package com.georgiaspeaches.game.screens.rooms;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.georgiaspeaches.game.MainHalls;
import com.georgiaspeaches.game.entities.Player;
import com.georgiaspeaches.game.screens.Play;
import com.georgiaspeaches.game.utilities.DoorLoader;

public class ClassRoom implements Screen
{
	final MainHalls game;
	TiledMap tiledMap;
	OrthographicCamera camera;
	TiledMapRenderer tiledMapRenderer;
	Player player;
	int roomNumber;
	boolean mapArray[][] = new boolean[200][200];
	public ClassRoom(MainHalls game, Player player, int roomNumber)
	{
		this.game = game;
		this.player = player;
		this.roomNumber = roomNumber;
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

		if(currentX == 59 || currentY == 33)
		{
			if(Gdx.input.isKeyPressed(Input.Keys.E))
			{
				tiledMap.dispose();
				player.setPos(77*16, 99*16);
				game.setScreen(new Play(game, player));
			}
		}

		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
		{
			tiledMap.dispose();
			player.setPos(77*16, 99*16);
			game.setScreen(new Play(game, player));
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
