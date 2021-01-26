/*
Name: Jordan Firaben
Date: 02/17/2017
Course/Section: IT-106-2D1
Assignment: Programming Assignment 2

Description:

This program was designed to calculate the total cost of a ticket at the museum. Each ticket
cost depends on the age of the patron. The cost breakdowns are as follows:

   child 0-5: free
   child 6-17: $2.93
   adult 18-149: $8.65
   
There will be a convenience fee of $0.85 added to the price of the ticket and a sales tax 
of 10% also added. The program takes in to account the day of the week the patron visited 
the museum. If they visit during the weekend, the ticket price remains the same. If they visit
during the week, the initial ticket price is decreased by 20%. After the ticket is decreased 
by 20%, the convenience fee and the sales tax is added.

Once the program has calculated the total cost of the ticket, it prints out a well-formated
report with the customer age, ticket cost plus convenience fee, the sales tax, and the total
cost of the ticket.

*/

import javax.swing.JOptionPane;

public class ProgrammingAssignment2
{
   public static void main (String[] args)
   {
      double childPrice = 0;
      double olderChildrenPrice = 2.93;
      double adultPrice = 8.65;
      double convenienceFee = 0.85;
      double taxAmount = 0.1;
      double discountAmount = 0.2;
      double totalTicketCost = 0;
      double salesTax = 0;
      double ticketPlusConvenience = 0;
      double ticketMinusDiscount = 0;
      double initialTicketCost = 0;
      boolean validInputFields = true;
      String dayOfWeek = new String();
      
      /*
      Prompt user to enter the age of the customer. If an incorrect age is entered, the user is
      confronted with an error message, and the program is closed.
      */
      
      int customerAge = Integer.parseInt(JOptionPane.showInputDialog("Please enter the customer age: "));
      
         /*
         If the user entered an age above 0 and below 6, the total ticket price is the child price
         of zero dollars.
         */
      
         if (customerAge > 0 && customerAge < 6)
         {
            totalTicketCost = childPrice;
         }
         
         /*
         If the user entered an age above 5 or below 18, the total ticket price is the older child price
         of $2.93.
         */
         
         else if (customerAge >= 6 && customerAge < 18)
         {
            initialTicketCost = olderChildrenPrice;
            
            /*
            The user is prompted for the day of the week. If the user enters anything other than the
            day of the week, including correct spelling, an error message displays then the program
            is terminated.
            */
            
            dayOfWeek = JOptionPane.showInputDialog("Please enter the day of the week: ");
            
            /*
            If the day of the week is on a weekday, the weekday discount is applied to the initial ticket
            price. The convenience fee is then added to that price. The sales tax is calculated using the 
            current price, then added to the total.
            */
            
            if (dayOfWeek.equalsIgnoreCase("Monday") || dayOfWeek.equalsIgnoreCase("Tuesday") || dayOfWeek.equalsIgnoreCase("Wednesday") || dayOfWeek.equalsIgnoreCase("Thursday") || dayOfWeek.equalsIgnoreCase("Friday"))
            {
               ticketMinusDiscount = initialTicketCost - (initialTicketCost * discountAmount);
               ticketPlusConvenience = ticketMinusDiscount + convenienceFee;
               salesTax = ticketPlusConvenience * taxAmount;
               totalTicketCost = ticketPlusConvenience + salesTax;
            }
            
            /*
            If the day of the week is on a weekend, the convenience fee is then added to the initial price. The sales tax is calculated using the 
            current price, then added to the total.
            */
            
            else if (dayOfWeek.equalsIgnoreCase("Saturday") || dayOfWeek.equalsIgnoreCase("Sunday"))
            {
               ticketPlusConvenience = initialTicketCost + convenienceFee;
               salesTax = ticketPlusConvenience * taxAmount;
               totalTicketCost = ticketPlusConvenience + salesTax;
            } 
            
            /*
            If the user enters anything other than a day of the week, an error message is displayed and the program is terminated.
            */
            
            else
            {
               JOptionPane.showMessageDialog(null,"Error! You have incorrectly entered the day of the week. Please restart and try again.");
               validInputFields = false;
            }
         }
         
         /*
         If the user entered an age above 17 or below 150, the total ticket price is the adult price of $8.65.
         */
         
         else if (customerAge >= 18 && customerAge < 150)
         {
            initialTicketCost = adultPrice;
            
            /*
            The user is prompted for the day of the week. If the user enters anything other than the
            day of the week, including correct spelling, an error message displays then the program
            is terminated.
            */
            
            dayOfWeek = JOptionPane.showInputDialog("Please enter the day of the week: ");
            if (dayOfWeek.equalsIgnoreCase("Monday") || dayOfWeek.equalsIgnoreCase("Tuesday") || dayOfWeek.equalsIgnoreCase("Wednesday") || dayOfWeek.equalsIgnoreCase("Thursday") || dayOfWeek.equalsIgnoreCase("Friday"))
            {
               
               /*
               If the day of the week is on a weekday, the weekday discount is applied to the initial ticket
               price. The convenience fee is then added to that price. The sales tax is calculated using the 
               current price, then added to the total.
               */
               
               ticketMinusDiscount = initialTicketCost - (initialTicketCost * discountAmount);
               ticketPlusConvenience = ticketMinusDiscount + convenienceFee;
               salesTax = ticketPlusConvenience * taxAmount;
               totalTicketCost = ticketPlusConvenience + salesTax;
            }
            
            /*
            If the day of the week is on a weekend, the convenience fee is then added to the initial price. The sales tax is calculated using the 
            current price, then added to the total.
            */
            
            else if (dayOfWeek.equalsIgnoreCase("Saturday") || dayOfWeek.equalsIgnoreCase("Sunday"))
            {
               ticketPlusConvenience = initialTicketCost + convenienceFee;
               salesTax = ticketPlusConvenience * taxAmount;
               totalTicketCost = ticketPlusConvenience + salesTax;
            } 
            
            /*
            If the user enters anything other than a day of the week, an error message is displayed and the program is terminated.
            */
            
            else
            {
               JOptionPane.showMessageDialog(null,"Error! You have incorrectly entered the day of the week. Please restart and try again.");
               validInputFields = false;
            }
         }
         
         /*
         If the user enters an age below 1 or above 149, the user is prompted with an error message and the program is terminated.
         */
         
         else if (customerAge <= 0 || customerAge >= 150)
         {
            JOptionPane.showMessageDialog(null,"Error! Please enter a valid age above 0 and below 150. Restart and try again.");
            validInputFields = false;
         }
         
         /*
         If validInputFields is true, no errors were made while entering the data, the program will display a well-formatted report
         with the customer age, the ticket price including the convenience fee, the sales tax, and the total price of the ticket.
         */
         
         if (validInputFields == true)
         {
            JOptionPane.showMessageDialog(null,"The customer age is: " + customerAge + "\nThe ticket price plus convenience fee is: " + String.format("$%.2f", ticketPlusConvenience) + "\nThe total Sales Tax is: " + String.format("$%.2f", salesTax) + "\nThe total ticket cost is: " + String.format("$%.2f", totalTicketCost));
         }
      }  
         
   }