package com.georgiaspeaches.game.screens.rooms;

import com.georgiaspeaches.game.MainHalls;
import com.georgiaspeaches.game.entities.Player;

import javax.swing.*;

/**
 * com.georgiaspeaches.game.screens.rooms
 * [Description]
 * <p>
 * [Variable Dictionary]
 *
 * @author ${user}
 * @version ${date}
 */
public class Doc
{
	public static int x = 137;
	public static int y = 90;
	public Doc(MainHalls game, Player player, int roomNumber)
	{

	}

	public static void work(Player player)
	{
		if(player.classYear == 9 && player.doneHistory == false)
		{
			String ans = JOptionPane.showInputDialog("In what year did Columbus sail the ocean blue?");
			if(ans.equals("1492"))
			{
				JOptionPane.showMessageDialog(null, "Yeah that's a good answer");
				player.myGPA+=1;
				player.doneHistory = true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "nah u failed lmao");
			}
		}
		else if(player.classYear == 10 && player.doneHistory == false)
		{
			String ans = JOptionPane.showInputDialog("The type of architecture with tall and dark buildings is known as....");
			if(ans.equals("Gothic"))
			{
				JOptionPane.showMessageDialog(null, "You bet your bottom dollar!");
				player.myGPA+=1;
				player.doneMath = true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No you don't bet your bottom dollar");
			}

		}
		else if(player.classYear == 11 && player.doneHistory == false)
		{
			String ans = JOptionPane.showInputDialog("What year did the stock market crash?");
			if(ans.equals("1929"))
			{
				JOptionPane.showMessageDialog(null, "Yep, you know your american history i guess");
				player.myGPA+=1;
				player.doneHistory = true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Nahhhhhhh trryyyyy agaaaainnnn");
			}

		}
		else if(player.classYear == 12 && player.doneHistory == false)
		{
			String ans = JOptionPane.showInputDialog("What is the friggin capital of Iran");
			if(ans.equals("Tehran"))
			{
				JOptionPane.showMessageDialog(null, "Wow you passed senior history congrchulachions");
				player.myGPA+=1;
				player.doneMath = true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "you must actually be a pile of turd if you actually think it's " + ans + ". try again");
			}

		}
		else
		{
			JOptionPane.showMessageDialog(null, "You have completed history class :)");
		}
	}
}
