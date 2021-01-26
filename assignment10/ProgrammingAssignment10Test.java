import javax.swing.JOptionPane;

public class ProgrammingAssignment10Test
{
   public static void main(String[] args)
   {
      //In order to keep count of the types and warn if there are too many, each type must have a counter.
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
      int currentSize = 0;
      //Ask the user for the type of pie baked.
      String registrationInfo = JOptionPane.showInputDialog("Please enter the name of the participant then enter the workshops they will be attending. You can enter 1 to 4 of the following workshops:\n1. A Security Primer for New Security Officers\n2. Bringing Results from Privacy Investment\n3. Developing a Company Cyberstrategy\n4. Performing Incident Response: A Real-Time Exercise\n5. Responding to Denial-of-Service Attacks\n6. Sharing Security Responsibility with IT Leadership\n7. Successful Data Breach Notification and Response\nOnce you have entered the amount of workshops the participant wishes to attend, press enter until prompted for the next participant.");
		
		//If the user enteres -1, the loop will stop and move on. 
		while (!registrationInfo.equals("-1") || registrationArray.length < currentSize) 
      {
			// If the array is not filled, add the number to the array
			if (currentSize < registrationArray.length) 
         {
            try 
            {
               String registrationArrayOutput = "";
               for (int i = 0; i < registrationArray.length; i++) {
         			for (int j = 0; j < registrationArray[i].length; j++) {
         				registrationArray[i][j] = registrationInfo;
                     registrationArrayOutput += registrationInfo + 
                     ", ";
         			}
         			registrationArrayOutput += "\n";
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
      JOptionPane.showMessageDialog(null, registrationArray);
   }
}