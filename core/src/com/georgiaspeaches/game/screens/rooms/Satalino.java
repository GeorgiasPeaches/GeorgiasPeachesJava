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
            String ans = JOptionPane.showInputDialog("A square pyramid has base edge 5 and height 9.\nWhat is its area?");
            if(ans.equals("75"))
            {
                JOptionPane.showMessageDialog(null, "Das correct boi");
                player.myGPA+=1;
                player.doneMath = true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No das sooo wrong. Better study boi");
            }

		}
		else if(player.classYear == 11 && player.doneMath == false)
		{
            String ans = JOptionPane.showInputDialog("Sin of 30 degrees plus cos of 60 degrees is equal to what?");
            if(ans.equals("1"))
            {
                JOptionPane.showMessageDialog(null, "Good boy");
                player.myGPA+=1;
                player.doneMath = true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No bad boy, go lie down and study");
            }

		}
		else if(player.classYear == 12 && player.doneMath == false)
		{
            String ans = JOptionPane.showInputDialog("What is the derivative of: sin(x) + 2x ?");
            if(ans.equals("cos(x) + 2") || ans.equals("cos(x)+2)") || ans.equals("cos(x) +2")
            {
                JOptionPane.showMessageDialog(null, "Wow you passed senior math congrchulachions");
                player.myGPA+=1;
                player.doneMath = true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "nah bro try again");
            }

		}
		else
		{
			JOptionPane.showMessageDialog(null, "You have completed math class.");
		}
	}
}
