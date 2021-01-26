/*
Name: Jordan Firaben
Date: 04/09/2017
Course/Section: IT-106-2D1
Assignment: Programming Assignment 6

Description:


*/

import javax.swing.JOptionPane;

public class ProgrammingAssignment6Test
{
   public static void main (String[] args)
   {
      int recordsCount = 0;
      int teamCount = 0;
      String searchValue;
      String gameResult;
      String teamName;
      String teamNameList = "";
      int index = 0;
      String finishedReport = "Team Name (Win,Loss)\n";
      boolean validInputFields = false;
      boolean found = false;
      
      int numTeams = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of teams in the Quidditch league. It must be more than 1 and less than or equal to 10: "));
      
      do
      {
         if (numTeams > 1 && numTeams <= 10)
         {
            validInputFields = true;
         }
         else
         {
            JOptionPane.showMessageDialog(null,"ERROR! Please enter a number greater than 1 and less than or equal to 10.");
            numTeams = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of teams in the Quidditch league. It must be more than 1 and less than or equal to 10: "));
         }
      }while(!validInputFields);
      
      
      String[] teamArray = new String [numTeams];
      int[] winArray = new int[numTeams];
      int[] lossArray = new int[numTeams];
      
      for (int i = 0;i < numTeams;i++)
      {
         teamName = JOptionPane.showInputDialog("Please enter the name of the team: ");
         teamArray[i] = teamName;
         teamNameList += teamArray[i] + "\n";
      }
      teamName = JOptionPane.showInputDialog("Please enter the name of the team you will be recording a game result for. \nEnter -1 when you are finished." + "\nThe names are as follows: \n" + teamNameList);
      do
      {
         while (!found && index < teamArray.length) 
            {
      			if (teamArray[index].equalsIgnoreCase(teamName)) 
               {
      				found = true;
      			}
      			else 
               {
      				++index;
      			}
      		}
            if (found)
            {
               index = 0;
               gameResult = JOptionPane.showInputDialog("Please enter a game result for " + teamArray[index] + ": ");
               if (gameResult.equalsIgnoreCase("win"))
               {
                  winArray[index] = winArray[index] + 1;
                  recordsCount = recordsCount + 1;
               }
               else if (gameResult.equalsIgnoreCase("loss"))
               {
                  lossArray[index] = lossArray[index] + 1;
                  recordsCount = recordsCount + 1;
               }
               else if (!gameResult.equalsIgnoreCase("win") || !gameResult.equalsIgnoreCase("loss"))
               {
                  JOptionPane.showMessageDialog(null,"ERROR! Please enter either \"win\" or \"loss\"! Please try again!");
               }
            }
            if (!found)
            {
               index = 0;
               JOptionPane.showMessageDialog(null,"ERROR! You have entered a team name that is not in the league.");
            }
         found = false;
         teamName = JOptionPane.showInputDialog("Please enter the name of the team you will be recording a game result for. \nEnter -1 when you are finished." + "\nThe names are as follows: \n" + teamNameList);
      }while(!teamName.equals("-1"));
      
      for (int i = 0;i < numTeams;i++)
      {
         finishedReport += teamArray[i] + "    (" + winArray[i] + "," + lossArray[i] + ")\n";
      }
      finishedReport += "\nTotal number of game records: " + recordsCount;
      JOptionPane.showMessageDialog(null,finishedReport);
   }         
}
