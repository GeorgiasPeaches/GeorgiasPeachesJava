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
public class Louns
{
	public static int x = 124;
	public static int y = 63;
	public Louns(MainHalls game, Player player, int roomNumber)
	{

	}

	public static void work(Player player)
	{
		if(player.classYear == 9 && player.doneScience == false)
		{
			String ans = JOptionPane.showInputDialog("The binary number, 00001101, is what in base 10?");
			if(ans.equals("13"))
			{
				JOptionPane.showMessageDialog(null, "c0rrect!!11!");
				player.myGPA+=1;
				player.doneScience = true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No you wrong. Go study.");
			}
		}
		else if(player.classYear == 10 && player.doneScience == false)
		{
			String ans = JOptionPane.showInputDialog("What is the powerhouse of the cell?");
			if(ans.equals("Mitochondria") || ans.equals("the mitochondria"))
			{
				JOptionPane.showMessageDialog(null, "Correct, that's like the only thing you learned in school right");
				player.myGPA+=1;
				player.doneScience = true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "HOW DID YOU NOT KNOW THAT. TRY AGAIN");
			}

		}
		else if(player.classYear == 11 && player.doneScience == false)
		{
			String ans = JOptionPane.showInputDialog("What element has atomic number 6?");
			if(ans.equals("Carbon"))
			{
				JOptionPane.showMessageDialog(null, "Good little child, you're right");
				player.myGPA+=1;
				player.doneScience = true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Nope.");
			}

		}
		else if(player.classYear == 12 && player.doneScience == false)
		{
			String ans = JOptionPane.showInputDialog("Velocity is:\nA. A scalar quantity\nB. A vector quantity");
			if(ans.equals("B"))
			{
				JOptionPane.showMessageDialog(null, "Wow you passed senior science congrchulachions");
				player.myGPA+=1;
				player.doneScience = true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "nah bro try again");
			}

		}
		else
		{
			JOptionPane.showMessageDialog(null, "You have completed science class :)");
		}
	}
}
