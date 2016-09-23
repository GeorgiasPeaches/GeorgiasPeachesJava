package com.georgiaspeaches.game.utilities;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.georgiaspeaches.game.entities.Door;
import com.georgiaspeaches.game.screens.Play;

public class DoorLoader
{
	public static Door[][] doors = new Door[1000][1000];
	public static void setDoors(TiledMap tiledMap)
	{
		for (int y = 0; y < 1000; y++)
		{
			for (int x = 0; x < 1000; x++)
			{
					doors[x][y] = new Door(0);
			}
		}
		for (int i = 0; i < tiledMap.getLayers().getCount(); i++)
		{
			TiledMapTileLayer layer = (TiledMapTileLayer) tiledMap.getLayers().get(i);
			for (int y = 0; y < layer.getHeight(); y++)
			{
				for (int x = 0; x < layer.getWidth(); x++)
				{
					if (layer.getCell(x, y) != null && layer.getCell(x, y).getTile().getProperties().containsKey("roomNumber"))
					{
						doors[x][y] = new Door((Integer) layer.getCell(x, y).getTile().getProperties().get("roomNumber"));
						doors[x+1][y] = new Door((Integer) layer.getCell(x, y).getTile().getProperties().get("roomNumber"));
						doors[x-1][y] = new Door((Integer) layer.getCell(x, y).getTile().getProperties().get("roomNumber"));
						doors[x][y+1] = new Door((Integer) layer.getCell(x, y).getTile().getProperties().get("roomNumber"));
						doors[x][y-1] = new Door((Integer) layer.getCell(x, y).getTile().getProperties().get("roomNumber"));
					}
				}
			}
		}
	}
}
