package com.georgiaspeaches.game.screens.rooms;

import com.georgiaspeaches.game.MainHalls;
import com.georgiaspeaches.game.entities.Player;

import javax.swing.*;

public class Satalino
{
	public static int x = 112;
	public static int y = 90;
	public Satalino(MainHalls game, Player player, int roomNumber)
	{

	}

	public static void work(Player player)
	{
		if(player.classYear == 9)
		{
			String ans = JOptionPane.showInputDialog("Solve for x lmao: \n1x+6=3x");
			if(ans == "3")
			{
				player.myGPA+=1.0;
			}

		}
		else if(player.classYear == 10)
		{

		}
		else if(player.classYear == 11)
		{

		}
		else if(player.classYear == 12)
		{

		}
	}
}
