package com.georgiaspeaches.game.screens;


import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.georgiaspeaches.game.MainHalls;
import com.georgiaspeaches.game.entities.Player;

public class Play implements Screen
{
	Texture img;
	TiledMap tiledMap;
	OrthographicCamera camera;
	TiledMapRenderer tiledMapRenderer;
	Player player = new Player(500, 10);
	boolean mapArray[][] = new boolean[1000][1000];
	final MainHalls game;

	public Play(final MainHalls game)
	{
		this.game = game;
	}

	@Override
	public void show()
	{
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera();
		camera.setToOrtho(false,w,h);
		camera.update();
		tiledMap = new TmxMapLoader().load("maps/themap.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

		setBlocked();
	}

	private void setBlocked() {
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
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
			dispose();

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.position.set(player.getX(), player.getY(), 0);
		camera.update();
		tiledMapRenderer.setView(camera);
		tiledMapRenderer.render();
		player.render(camera);
		player.update(mapArray);
	}

	@Override
	public void hide()
	{

	}

	@Override
	public void dispose()
	{
		tiledMap.dispose();
		player.dispose();
		game.setScreen(new MainMenuScreen(game));
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
}
