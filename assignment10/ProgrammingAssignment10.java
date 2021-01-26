/*
Name: Jordan Firaben
Date: 04/22/2017
Course/Section: IT-106-2D1
Assignment: Programming Assignment 10

Description:


*/

import javax.swing.JOptionPane;

public class ProgrammingAssignment10
{
   public static void main(String[] args)
   {
      /*
         Sets the maximum amount of each type of pie, maximum amount of pies total, the price to sell and make each pie, the words allowed for each
         pie, and creates the initial array.
      */
      final int MAX_TOTAL_PARTICIPANTS = 238;
      final int MAX_REGISTRATION_INFORMATION = 5;
      
      final double REGISTRATION_FEE = 1030;
      final double WORKSHOP_NOT_LEARNING = 61;
      final double WORKSHOP_LEARNING = 78;
      
      String securityBasics = "Security Basics";
      String privacyMatters = "Privacy Matters";
      String learningLab = "Learning Lab";
      
      String securityPrimer = "A Security Primer for New Security Officers";
      String privacyInvestment = "Bringing Results from Privacy Investment";
      String companyCyberstrategy = "Developing a Company Cyberstrategy";
      String incidentResponse = "Performing Incident Response: A Real-Time Exercise";
      String denialOfService = "Responding to Denial-of-Service Attacks";
      String securityResponsibility = "Sharing Security Responsibility with IT Leadership";
      String dataBreach = "Successful Data Breach Notification and Response";
      
      String[][] registrationArray = new String [MAX_TOTAL_PARTICIPANTS][MAX_REGISTRATION_INFORMATION];
      
      int pieCount = GET_REGISTRATION_INFO(registrationArray, securityPrimer, privacyInvestment, companyCyberstrategy, incidentResponse, denialOfService, securityResponsibility, dataBreach , MAX_TOTAL_PARTICIPANTS, MAX_REGISTRATION_INFORMATION);
      //This new array is created with the correct pie count.
      String[] registrationArray2 = new String [pieCount];
      //This method is called in order to fill the new pie array with the existing pie array. Without it, you would get a null error.
      APPEND_PIES_TO_ARRAY(registrationArray, registrationArray2);
      //The print report method is called
      PRINT_REPORT(PIE_TYPE_COUNT(registrationArray2, applePie, blueberryPie, peanutbutterPie), PIE_TYPE_COUNT(registrationArray2, applePie, blueberryPie, peanutbutterPie), PIE_TYPE_COUNT(registrationArray2, applePie, blueberryPie, peanutbutterPie), CALCULATE_PROFIT(registrationArray2, applePie, blueberryPie, peanutbutterPie, applePieProfit, blueberryPieProfit, peanutbutterPieProfit));
      
   }
   //This method is used to fill the array with all the pie types.
   public static int GET_REGISTRATION_INFO(String[][] anArray, String securityPrimer, String privacyInvestment, String companyCyberstrategy, String incidentResponse, String denialOfService, String securityResponsibility, String dataBreach , int maxTotalParticipants, int maxRegistrationInfo)
   {
      //In order to keep count of the types and warn if there are too many, each type must have a counter.
      
      int currentSize = 0;
      //Ask the user for the type of pie baked.
      String registrationInfo = JOptionPane.showInputDialog("Please enter the name of the participant then enter the workshops they will be attending. You can enter 1 to 4 of the following workshops:\n-A Security Primer for New Security Officers\n-Bringing Results from Privacy Investment\n-Developing a Company Cyberstrategy\n-Performing Incident Response: A Real-Time Exercise\n-Responding to Denial-of-Service Attacks\n-Sharing Security Responsibility with IT Leadership\n-Successful Data Breach Notification and Response\nOnce you have entered the amount of workshops the participant wishes to attend, press enter until prompted for the next participant.");
		
		//If the user enteres -1, the loop will stop and move on. 
		while (!registrationInfo.equals("-1") || anArray.length < currentSize) 
      {
			// If the array is not filled, add the number to the array
			if (currentSize < anArray.length) 
         {
            try 
            {
               String anArrayOutput = "";
               for (int i = 0; i < anArray.length; i++) {
         			for (int j = 0; j < anArray[i].length; j++) {
         				anArray[i][j] + registrationInfo;
                     anArrayOutput += registrationInfo + 
                     ", ";
         			}
         			anArrayOutput += "\n";
                  currentSize++;
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
   	      JOptionPane.showMessageDialog(null, "You have reached the max number participants allowed. Please enter -1");
   	   }
         registrationInfo = JOptionPane.showInputDialog("Please enter the name of the participant then enter the workshops they will be attending. You can enter 1 to 4 of the following workshops:\n-A Security Primer for New Security Officers\n-Bringing Results from Privacy Investment\n-Developing a Company Cyberstrategy\n-Performing Incident Response: A Real-Time Exercise\n-Responding to Denial-of-Service Attacks\n-Sharing Security Responsibility with IT Leadership\n-Successful Data Breach Notification and Response\nOnce you have entered the amount of workshops the participant wishes to attend, press enter until prompted for the next participant.");
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
   public static int PIE_TYPE_COUNT(String[] anArray, String applePie, String blueberryPie, String peanutbutterPie)
   {
      int pieCount = 0;
      for(int x = 0;x<anArray.length;x++)
      {
         if (anArray[x].equalsIgnoreCase(applePie))
         {
            pieCount += 1;
         }
         if (anArray[x].equalsIgnoreCase(blueberryPie))
         {
            pieCount += 1;
         }
         if (anArray[x].equalsIgnoreCase(peanutbutterPie))
         {
            pieCount += 1;
         }
      }
      return pieCount;
   }
   //The print method takes in the counts of each pie and the total profit earned and prints out a well formatted report.
   public static void PRINT_REPORT(int applePieCount, int blueberryPieCount, int peanutbutterPieCount, double totalPieProfit)
   {
      int totalPieCount = applePieCount + blueberryPieCount + peanutbutterPieCount;
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
