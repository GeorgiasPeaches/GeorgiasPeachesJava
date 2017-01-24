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
public class Benzing
{
	public static int x = 106;
	public static int y = 53;
	public Benzing(MainHalls game, Player player, int roomNumber)
	{

	}
	public static void work(Player player)
	{
		if(player.classYear == 9 && player.doneEnglish == false)
		{
			String ans = JOptionPane.showInputDialog("Copy and paste this sentence, correcting the grammatical error:\nYour face currently look like it was smashed by a pineapple");
			if(ans.equals("Your face currently looks like it was smashed by a pineapple"))
			{
				JOptionPane.showMessageDialog(null, "Correct :) you get candy (jk)");
				player.myGPA+=1;
				player.doneEnglish = true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No you wrong. Go study.");
			}
		}
		else if(player.classYear == 10 && player.doneEnglish == false)
		{
			String ans = JOptionPane.showInputDialog("Is the word dog a verb?");
			if(ans.equals("no"))
			{
				JOptionPane.showMessageDialog(null, "Nice going!");
				player.myGPA+=1;
				player.doneEnglish = true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "uhh close? Try again...");
			}

		}
		else if(player.classYear == 11 && player.doneEnglish == false)
		{
			String ans = JOptionPane.showInputDialog("Define the word umbrage:\nA. Offense or annoyance\nB. Large-scale slaughter or loss of life\nC. A weakness or ailment");
			if(ans.equals("A"))
			{
				JOptionPane.showMessageDialog(null, "You actually passed a vocab test!");
				player.myGPA+=1;
				player.doneEnglish = true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Nah, you can't run from vocab here, go");
			}

		}
		else if(player.classYear == 12 && player.doneEnglish == false)
		{
			String ans = JOptionPane.showInputDialog("What literary device is the repetition of a word or phrase at the beginning of successive clauses");
			if(ans.equals("anaphora"))
			{
				JOptionPane.showMessageDialog(null, "Wow you passed senior english congrchulachions");
				player.myGPA+=1;
				player.doneEnglish = true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "nah bro try again");
			}

		}
		else
		{
			JOptionPane.showMessageDialog(null, "You have completed english class :)");
		}
	}
}
