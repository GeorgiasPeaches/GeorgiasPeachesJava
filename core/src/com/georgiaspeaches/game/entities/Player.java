package com.georgiaspeaches.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite
{
	private Vector2 velocity = new Vector2();
	private float speed = 60 * 2, gravity = 60 * 1.8f;

	public Player(Sprite sprite)
	{
		super(sprite);
	}

	@Override
	public void draw(Batch batch)
	{
		update(Gdx.graphics.getDeltaTime());
		super.draw(batch);
	}

	public void update(float delta)
	{
		velocity.y -= gravity * delta;

		if(velocity.y > speed)
		{
			velocity.y = speed;
		}
		else if(velocity.y < speed)
		{
			velocity.y = -speed;
		}

		setX(getX() + velocity.x * delta);
		setY(getY() + velocity.y * delta);
	}
}
