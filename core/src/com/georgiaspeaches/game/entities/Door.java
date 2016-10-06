package com.georgiaspeaches.game.entities;

import com.badlogic.gdx.math.Vector2;

public class Door
{
	boolean isDoor;
	int roomNumber;
	int x;
	int y;
	public Door(int roomNumber)
	{
		this.roomNumber = roomNumber;
	}
	public Door(int roomNumber, int x, int y)
	{
		this.roomNumber = roomNumber;
	}
	public int getRoomNumber()
	{
		return roomNumber;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

}
