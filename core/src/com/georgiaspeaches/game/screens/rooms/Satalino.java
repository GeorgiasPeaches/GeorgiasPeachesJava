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
		if(player.classYear == 9 && player.doneMath == false)
		{
			String ans = JOptionPane.showInputDialog("Solve for x lmao: \n1x+6=3x");
			if(ans.equals("3"))
			{
				JOptionPane.showMessageDialog(null, "Correct");
				player.myGPA+=1;
				player.doneMath = true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No you wrong. Go study.");
			}
		}
		else if(player.classYear == 10 && player.doneMath == false)
		{

		}
		else if(player.classYear == 11 && player.doneMath == false)
		{

		}
		else if(player.classYear == 12 && player.doneMath == false)
		{

		}
		else
		{
			JOptionPane.showMessageDialog(null, "You have completed math class.");
		}
	}
}
