/*
Name: Jordan Firaben
Date: 03/05/2017
Course/Section: IT-106-2D1
Assignment: Programming Assignment 4

Description:

This program was designed to calculate the total cost of a certain number of items
at the Fenwick Clothing & Company during a 5-day sale. The discounts for the sale
days are as follows:

   Sunday/Monday: full retail
   Tuesday:       8% discount
   Wednesday:     16% discount
   Thursday:      24% discount
   Friday:        32% discount
   Saturday:      40% discount
   
The clerk first enters the day of week. Once they have entered the correct day of
the week with correct spelling, they will be asked for the retail price of an item.
They can enter as many items as wanted, and when they are finished, they enter -1
to stop the program. Once the clerk has entered all of the retail prices, the program
will print out a well-formatted receipt with the total number of items, total price
of the items without the discount, total price of the items with a discount, and the
amount saved from the sale.
*/

import javax.swing.JOptionPane;

public class ProgrammingAssignment4
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
      
      /*
         Prompt the clerk to enter the day of the week. If an incorrect day of the week
         is entered, the clerk is confronted with an error message and prompted again.
      */
      
      String dayOfWeek = JOptionPane.showInputDialog("Please enter the day of the week: ");
      do
      {
         // If the clerk enters a correct day of the week, the program moves onto the prices.
         if (dayOfWeek.equalsIgnoreCase("Sunday") || dayOfWeek.equalsIgnoreCase("Monday") || dayOfWeek.equalsIgnoreCase("Tuesday") || dayOfWeek.equalsIgnoreCase("Wednesday") || dayOfWeek.equalsIgnoreCase("Thursday") || dayOfWeek.equalsIgnoreCase("Friday") || dayOfWeek.equalsIgnoreCase("Saturday"))
         {
            validInputFields = true;
         }
         // If the clerk enters a wrong day of the week, an error pops up and the clerk
         // must enter the day of the week again.
         else
         {
            JOptionPane.showMessageDialog(null,"ERROR! Please enter a day of the week");
            dayOfWeek = JOptionPane.showInputDialog("Please enter the day of the week: ");
         }
      }while(!validInputFields);
      
      /*
         Once the clerk has entered a correct day of the week, the program asks for the
         first retail price. The user will enter as many retail prices until they wish to
         stop by entering -1. 
      */
      
      do
      {
         try
         {
            // Prompt user for first retail price. Must be between 0 and 10000
            retailPrice = Double.parseDouble(JOptionPane.showInputDialog("Please enter the retail price of the item: "));
            if (retailPrice > 0 && retailPrice < 10000)
            {
               // There is no discount for Sunday/Monday. The program will just add the retail
               // price to both prices with and without discount and also increase the count.
               if (dayOfWeek.equalsIgnoreCase("Sunday") || dayOfWeek.equalsIgnoreCase("Monday"))
               {
                  priceWithoutDiscount += retailPrice;
                  priceWithDiscount = priceWithoutDiscount;
                  totalCount += 1;
               }  
               // A discount of 8% is applied to the retail price. Count increased.
               if (dayOfWeek.equalsIgnoreCase("Tuesday"))
               {
                  priceWithoutDiscount = priceWithoutDiscount + retailPrice;
                  priceWithDiscount = priceWithoutDiscount - (priceWithoutDiscount * tuesdayDiscount);
                  totalCount += 1;
               }
               // A discount of 16% is applied to the retail price. Count increased.
               if (dayOfWeek.equalsIgnoreCase("Wednesday"))
               {
                  priceWithoutDiscount = priceWithoutDiscount + retailPrice;
                  priceWithDiscount = priceWithoutDiscount - (priceWithoutDiscount * wednesdayDiscount);
                  totalCount += 1;
               }
               // A discount of 24% is applied to the retail price. Count increased.
               if (dayOfWeek.equalsIgnoreCase("Thursday"))
               {
                  priceWithoutDiscount = priceWithoutDiscount + retailPrice;
                  priceWithDiscount = priceWithoutDiscount - (priceWithoutDiscount * thursdayDiscount);
                  totalCount += 1;
               }
               // A discount of 32% is applied to the retail price. Count increased.
               if (dayOfWeek.equalsIgnoreCase("Friday"))
               {
                  priceWithoutDiscount = priceWithoutDiscount + retailPrice;
                  priceWithDiscount = priceWithoutDiscount - (priceWithoutDiscount * fridayDiscount);
                  totalCount += 1;
               }
               // A discount of 40% is applied to the retail price. Count increased.
               if (dayOfWeek.equalsIgnoreCase("Saturday"))
               {
                  priceWithoutDiscount = priceWithoutDiscount + retailPrice;
                  priceWithDiscount = priceWithoutDiscount - (priceWithoutDiscount * saturdayDiscount);
                  totalCount += 1;
               }
            }
            // If the user enters a price below 0 (excluding -1) or above 9999, an error
            // message pops up.
            else if (retailPrice != -1)
            {
               JOptionPane.showMessageDialog(null,"ERROR! Please enter a number between 0 and 1000");
            }
         }
         // If the user enters anything other than a number, an error message pops up.
         catch (NumberFormatException e)
         {
            JOptionPane.showMessageDialog(null,"Error! Must enter a valid number");
         }
      }while(retailPrice != -1); 
      
      // The amount saved is calculated from the price with and without discount.
      amountSaved = priceWithoutDiscount - priceWithDiscount;
      // A well-formatted report will display total number of items, the price with discount,
      // price without discount, and amount saved.
      JOptionPane.showMessageDialog(null,"The total number of items: " + totalCount + "\nThe total price without discount: " + String.format("$%.2f", priceWithoutDiscount) + "\nThe total price with discount: " + String.format("$%.2f", priceWithDiscount) + "\nThe total amount saved: " + String.format("$%.2f", amountSaved));
   }         
}
