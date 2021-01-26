/*
Name: Jordan Firaben
Date: 03/05/2017
Course/Section: IT-106-2D1
Assignment: Programming Assignment 4

Description:



*/

import javax.swing.JOptionPane;

public class ProgrammingAssignment4test
{
   public static void main (String[] args)
   {
      int totalCount = 0;
      double priceWithoutDiscount = 0;
      double priceWithDiscount = 0;
      double amountSaved = 0;
      final double tuesdayDiscount = .08;
      final double wednesdayDiscount = .16;
      final double thursdayDiscount = .24;
      final double fridayDiscount = .32;
      final double saturdayDiscount = .4;
      double retailPrice = 0;
      boolean validInputFields = false;
      
      String dayOfWeek = JOptionPane.showInputDialog("Please enter the day of the week: ");
      do
      {
         if (dayOfWeek.equalsIgnoreCase("Sunday") || dayOfWeek.equalsIgnoreCase("Monday") || dayOfWeek.equalsIgnoreCase("Tuesday") || dayOfWeek.equalsIgnoreCase("Wednesday") || dayOfWeek.equalsIgnoreCase("Thursday") || dayOfWeek.equalsIgnoreCase("Friday") || dayOfWeek.equalsIgnoreCase("Saturday"))
         {
            validInputFields = true;
         }
         else
         {
            JOptionPane.showMessageDialog(null,"ERROR! Please enter a day of the week");
            dayOfWeek = JOptionPane.showInputDialog("Please enter the day of the week: ");
         }
      }while(!validInputFields);
      
      do
      {
         try
         {
            retailPrice = Double.parseDouble(JOptionPane.showInputDialog("Please enter the retail price of the item: "));
            if (retailPrice > 0 && retailPrice < 1000)
            {
               if (dayOfWeek.equalsIgnoreCase("Sunday") || dayOfWeek.equalsIgnoreCase("Monday"))
               {
                  priceWithoutDiscount += retailPrice;
                  priceWithDiscount = priceWithoutDiscount;
                  totalCount += 1;
               }  
               if (dayOfWeek.equalsIgnoreCase("Tuesday"))
               {
                  priceWithoutDiscount = priceWithoutDiscount + retailPrice;
                  priceWithDiscount = priceWithoutDiscount - (priceWithoutDiscount * tuesdayDiscount);
                  totalCount += 1;
               }
               if (dayOfWeek.equalsIgnoreCase("Wednesday"))
               {
                  priceWithoutDiscount = priceWithoutDiscount + retailPrice;
                  priceWithDiscount = priceWithoutDiscount - (priceWithoutDiscount * wednesdayDiscount);
                  totalCount += 1;
               }
               if (dayOfWeek.equalsIgnoreCase("Thursday"))
               {
                  priceWithoutDiscount = priceWithoutDiscount + retailPrice;
                  priceWithDiscount = priceWithoutDiscount - (priceWithoutDiscount * thursdayDiscount);
                  totalCount += 1;
               }
               if (dayOfWeek.equalsIgnoreCase("Friday"))
               {
                  priceWithoutDiscount = priceWithoutDiscount + retailPrice;
                  priceWithDiscount = priceWithoutDiscount - (priceWithoutDiscount * fridayDiscount);
                  totalCount += 1;
               }
               if (dayOfWeek.equalsIgnoreCase("Saturday"))
               {
                  priceWithoutDiscount = priceWithoutDiscount + retailPrice;
                  priceWithDiscount = priceWithoutDiscount - (priceWithoutDiscount * saturdayDiscount);
                  totalCount += 1;
               }
            }
            else if (retailPrice != -1)
            {
               JOptionPane.showMessageDialog(null,"ERROR! Please enter a number between 0 and 1000");
            }
         }
         catch (NumberFormatException e)
         {
            JOptionPane.showMessageDialog(null,"Error! Must enter a valid number");
         }
         //retailPrice = Double.parseDouble(JOptionPane.showInputDialog("Please enter the retail price of the item: "));
      }while(retailPrice != -1); 
      
      amountSaved = priceWithoutDiscount - priceWithDiscount;
      JOptionPane.showMessageDialog(null,"The total number of items: " + totalCount + "\nThe total price without discount: " + String.format("$%.2f", priceWithoutDiscount) + "\nThe total price with discount: " + String.format("$%.2f", priceWithDiscount) + "\nThe total amount saved: " + String.format("$%.2f", amountSaved));
   }         
}
