/*
Name: Jordan Firaben
Date: 04/09/2017
Course/Section: IT-106-2D1
Assignment: Programming Assignment 6

Description:

This program was designed to take the input from a user to keep track of the win/loss
record of each team in a Quidditch league. The user first inputs the total number of
teams in the league. Then the user will input each team name in the league. After all
the team names are entered, the user will be continuously prompted to enter game 
records for each team. The game record consists of the team name and either win or loss.
Once the user has entered all of the records, he/she will indicate they are finished 
entering. When all of the game records are entered, the program will output a 
well-formatted report containing each team name, number of games won, number of games
lost, and the total number of game records entered.

*/

import javax.swing.JOptionPane;

public class ProgrammingAssignment6
{
   public static void main (String[] args)
   {
      int recordsCount = 0;
      int teamCount = 0;
      int index = 0;
      String searchValue;
      String gameResult;
      String teamName;
      String teamNameList = "";
      String finishedReport = "Team Name (Win,Loss)\n";
      boolean validInputFields = false;
      boolean found = false;
      
      /*
         Prompt the user for the number of teams in the quidditch league. This number must be more than 1 and less than or equal to 10.
      */
      
      int numTeams = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of teams in the Quidditch league. It must be more than 1 and less than or equal to 10: "));
      
      /*
         Continuously prompt user for the number of teams if it is entered incorrectly. Once the correct number of teams is entered, the program will move on.
      */
      
      do
      {
         if (numTeams > 1 && numTeams <= 10)
         {
            validInputFields = true;
         }
         //If the user enters an incorrect number, he/she is met with an error and prompted again
         else
         {
            JOptionPane.showMessageDialog(null,"ERROR! Please enter a number greater than 1 and less than or equal to 10.");
            numTeams = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of teams in the Quidditch league. It must be more than 1 and less than or equal to 10: "));
         }
      }while(!validInputFields);
      
      //Create the arrays that will hold the team names, wins, and losses in the correct spot
      String[] teamArray = new String [numTeams];
      int[] winArray = new int[numTeams];
      int[] lossArray = new int[numTeams];
      
      /*
         Enter the names of the teams until the team array is filled. Since this is a club sport, I am under the assumption
         that any team name may be entered. Although when entering the game records, you must enter the correct team name.
      */
      for (int i = 0;i < numTeams;i++)
      {
         teamName = JOptionPane.showInputDialog("Please enter the name of the team: ");
         teamArray[i] = teamName;
         teamNameList += teamArray[i] + "\n";
      }
      
      /*
         Prompt user for team name in order to enter a game result. The team name must match the team names listed below. If
         they do not match, the user will receive an error and have to enter the team name again. Once the user is finished,
         he/she will enter -1 to stop.
      */
      teamName = JOptionPane.showInputDialog("Please enter the name of the team you will be recording a game result for. \nEnter -1 when you are finished." + "\nThe names are as follows: \n" + teamNameList);
      do
      {
         //Search through to find if the team entered is in the league
         while (!found && index < teamArray.length) 
            {
      			//if the team is in the league, prompt for a game result
               if (teamArray[index].equalsIgnoreCase(teamName)) 
               {
      				found = true;
                  gameResult = JOptionPane.showInputDialog("Please enter a game result for " + teamArray[index] + ": ");
                  //if the game result is win, add to win array for that team
                  if (gameResult.equalsIgnoreCase("win"))
                  {
                     winArray[index] = winArray[index] + 1;
                     recordsCount = recordsCount + 1;
                  }
                  //if the game result is loss, add to loss array for that team
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
      			else 
               {
      				++index;
      			}
      		}
            if (!found)
            {
               JOptionPane.showMessageDialog(null,"ERROR! You have entered a team name that is not in the league.");
            }
         index = 0;
         found = false;
         teamName = JOptionPane.showInputDialog("Please enter the name of the team you will be recording a game result for. \nEnter -1 when you are finished." + "\nThe names are as follows: \n" + teamNameList);
      }while(!teamName.equals("-1"));      
      //The report is filled with the appropriate team names, win totals, and loss totals for each team
      for (int i = 0;i < numTeams;i++)
      {
         finishedReport += teamArray[i] + "    (" + winArray[i] + "," + lossArray[i] + ")\n";
      }
      //The total number of game records is added to the report
      finishedReport += "\nTotal number of game records: " + recordsCount;
      //The finalized report is then displayed
      JOptionPane.showMessageDialog(null,finishedReport);
   }         
}
