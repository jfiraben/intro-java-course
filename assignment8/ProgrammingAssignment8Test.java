/*
Name: Jordan Firaben
Date: 04/22/2017
Course/Section: IT-106-2D1
Assignment: Programming Assignment 8

Description:

This program is designed to accomodate Grandma Martha and her homemade pie business. She makes three types of pies: apple, blueberry, and peanut butter. 
She sells these pies to the local grocery store and makes a certain profit on each pie she makes. The prices to make and sell each pie are as follows:

   Apple Pie:           $4.05 to make. $9.99 to sell.
   Blueberry Pie:       $5.10 to make. $10.99 to sell.
   Peanut Butter Pie:   $7.55 to make. $14.50 to sell.
   
Each day she can only make a miximum of 13 pies of each type for a theoretical maximum of 39 pies per day. This program will continuously ask Grandma
Martha what pie she has mad. If grandma Martha enters an invalid option, she will be met with an error. If she has baked 13 of a certain pie and enters
that same pie, she will be met with an error. Once Grandma Martha has indicated she is done entering pies, the program will calculate the total number
of each pie type made, total number of pies, and the total profit earned for that day. If she hasn't made any pies, the program will wish her a happy
day off.

*/

import javax.swing.JOptionPane;

public class ProgrammingAssignment8Test
{
   public static void main(String[] args)
   {
      /*
         Sets the maximum amount of each type of pie, maximum amount of pies total, the price to sell and make each pie, the words allowed for each
         pie, and creates the initial array.
      */
      final int MAX_TOTAL_PIES = 39;
      final int MAX_PIE_TYPE = 13;
      final double APPLE_PIE_MAKE = 4.05;
      final double APPLE_PIE_SELL = 9.99;
      final double BLUEBERRY_PIE_MAKE = 5.10;
      final double BLUEBERRY_PIE_SELL = 10.99;
      final double PEANUTBUTTER_PIE_MAKE = 7.55;
      final double PEANUTBUTTER_PIE_SELL = 14.50;
      double applePieProfit = APPLE_PIE_SELL - APPLE_PIE_MAKE;
      double blueberryPieProfit = BLUEBERRY_PIE_SELL - BLUEBERRY_PIE_MAKE;
      double peanutbutterPieProfit = PEANUTBUTTER_PIE_SELL - PEANUTBUTTER_PIE_MAKE;
      String applePie = "apple";
      String blueberryPie = "blueberry";
      String peanutbutterPie = "peanut butter";
      String[] pieArray = new String [MAX_TOTAL_PIES];
      /*
         In order to get the correct size of the final array that will be used to count and calculate, the size of the items in the initial array
         must be figured out. This calls the GET_PIES method which will fill the initial pie array and also return the total number of pies made.
      */
      int pieCount = GET_PIES(pieArray, applePie, blueberryPie, peanutbutterPie, MAX_PIE_TYPE);
      //This new array is created with the correct pie count.
      String[] pieArray2 = new String [pieCount];
      //This method is called in order to fill the new pie array with the existing pie array. Without it, you would get a null error.
      APPEND_PIES_TO_ARRAY(pieArray, pieArray2);
      
      double totalProfit = CALCULATE_PROFIT(pieArray2, applePie, blueberryPie, peanutbutterPie, applePieProfit, blueberryPieProfit, peanutbutterPieProfit);
      //The print report method is called
      PRINT_REPORT(PIE_TYPE_COUNT(totalProfit, applePieProfit), PIE_TYPE_COUNT(totalProfit, blueberryPieProfit), PIE_TYPE_COUNT(totalProfit, peanutbutterPieProfit), totalProfit);
      
   }
   //This method is used to fill the array with all the pie types.
   public static int GET_PIES(String[] anArray, String applePie, String blueberryPie, String peanutbutterPie, int maxPieType)
   {
      //In order to keep count of the types and warn if there are too many, each type must have a counter.
      int applePieCount = 0;
      int blueberryPieCount = 0;
      int peanutbutterPieCount = 0;
      int currentSize = 0;
      //Ask the user for the type of pie baked.
      String pieType = JOptionPane.showInputDialog("Please enter the type of pie baked. \nRemember, you cannot bake more than 13 of the same type of pies in one day!\nEnter -1 when you are finished entering pies.");
		
		//If the user enteres -1, the loop will stop and move on. 
		while (!pieType.equals("-1") || anArray.length < currentSize) 
      {
			// If the array is not filled, add the number to the array
			if (currentSize < anArray.length) 
         {
            try 
            {
               //If the user enters apple and the count is less than 13, then the word apple is added to the array.
               if (pieType.equalsIgnoreCase("apple") && applePieCount < maxPieType)
               {
                  anArray[currentSize] = pieType;
                  applePieCount += 1;
                  currentSize++;
               }
               //If the user enters blueberry and the count is less than 13, then the word blueberry is added to the array.
               else if (pieType.equalsIgnoreCase("blueberry") && blueberryPieCount < maxPieType)
               {
                  anArray[currentSize] = pieType;
                  blueberryPieCount += 1;
                  currentSize++;
               }
               //If the user enters peanut butter and the count is less than 13, then the word peanut butter is added to the array.
               else if (pieType.equalsIgnoreCase("peanut butter") && peanutbutterPieCount < maxPieType)
               {
                  anArray[currentSize] = pieType;
                  peanutbutterPieCount += 1;
                  currentSize++;
               }
               //Once the user has entered the max amount of pies for this type, you will receive an error
               else if (applePieCount >= maxPieType || blueberryPieCount >= maxPieType || peanutbutterPieCount >= maxPieType)
               {
                  JOptionPane.showMessageDialog(null,"Error! You have reached the max number of pies of that type you can bake in one day!");
               }
               //If the user enters anything other than the three types of pies, this error will pop up.
               else
               {
                  JOptionPane.showMessageDialog(null,"Error! You have entered an invalid option! Please enter \"apple\", \"blueberry\", or \"peanut butter\"!");
               }
   			}
            //If the user enters a number other than -1, this error will pop up.
            catch(Exception e) 
            {
               JOptionPane.showMessageDialog(null, "ERROR! You have entered in invalid character!");
            }
   		}
         //Once the array is filled, you will be asked to enter -1 to move on with the program.
         else
         {
   	      JOptionPane.showMessageDialog(null, "You have reached the max number of pies available to bake for the day. Please enter -1");
   	   }
         pieType = JOptionPane.showInputDialog("Please enter the type of pie baked. \nRemember, you cannot bake more than 13 of the same type of pies in one day!\nEnter -1 when you are finished entering pies.");
      }
      //The current size of the array is returned in order to accurately fill the final pie array for calculating and counting.
      return currentSize;
   }
   //Thie method is used to fill the final array with all of the initial array elements
   public static void APPEND_PIES_TO_ARRAY(String[] anArray, String[] anArray2)
   {
      for(int x = 0;x<anArray2.length;x++)
      {
         anArray2[x] = anArray[x];
      }
   }
   /*
      Each item in the array is matched with the correct amount of profit earned per pie type. The amount of profit is then added together
      in a total profit earned variable.
   */
   public static double CALCULATE_PROFIT(String[] anArray, String applePie, String blueberryPie, String peanutbutterPie, double applePieProfit, double blueberryPieProfit, double peanutbutterPieProfit)
   {
      double totalPieProfit = 0;
      //Each profit earned per type of pie is added to the total running profit.
      for(int x = 0;x<anArray.length;x++)
      {
         if (anArray[x].equalsIgnoreCase(applePie))
         {
            totalPieProfit = totalPieProfit + applePieProfit;
         }
         else if (anArray[x].equalsIgnoreCase(blueberryPie))
         {
            totalPieProfit = totalPieProfit + blueberryPieProfit;
         }
         else if (anArray[x].equalsIgnoreCase(peanutbutterPie))
         {
            totalPieProfit = totalPieProfit + peanutbutterPieProfit;
         }
      }
      return totalPieProfit;
   }
   //This method is used to count each type of pie in the array. It is called three times--once for each type of pie.
   public static double PIE_TYPE_COUNT(double pieProfit, double totalProfit)
   {
      double pieCount = pieProfit % totalProfit;
      
      return pieCount;
   }
   //The print method takes in the counts of each pie and the total profit earned and prints out a well formatted report.
   public static void PRINT_REPORT(double applePieCount, double blueberryPieCount, double peanutbutterPieCount, double totalPieProfit)
   {
      double totalPieCount = applePieCount + blueberryPieCount + peanutbutterPieCount;
      //If the user has not entered a pie type, the program assumes they had a day off and wishes them a happy day off.
      if (totalPieCount == 0)
      {
         JOptionPane.showMessageDialog(null,"No pies were made. Enjoy your day off.");
      }
      //If the user has not had a day off, the program prints out a well-formatted report.
      else
      {
         JOptionPane.showMessageDialog(null,"The total number of apple pies is: " + applePieCount + "\nThe total number of blueberry pies is: " + blueberryPieCount + "\nThe total number of peanut butter pies is: " + peanutbutterPieCount + "\nThe total number of pies is: " + totalPieCount + "\nThe total profit for the day is: " + String.format("$%.2f", totalPieProfit));
      }
   }
}
