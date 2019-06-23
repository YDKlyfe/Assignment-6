import java.util.Scanner;

public class PaidAdvisor extends Person {

	//Variables of this specific class
	private double regularPayRate;
	private double specialPayRate;
	private double overtimePayRate;
	private int hoursWorked;
	private int hoursSpecial;

	//Constructor of the class
	public PaidAdvisor(String first, String last, int totalHours, int special)
	{
		super(first,last); //Calls the super constructor to initialize the names
		regularPayRate = 25;
		specialPayRate = 50;
		overtimePayRate = regularPayRate*1.5;
		hoursWorked = totalHours - special;
		hoursSpecial = special;
	}

	//Getter for the regular payRate
	public double getRegularPayRate()
	{
		return regularPayRate;
	}

	//Getter for hours worked
	public double getHoursWorked()
	{
		return hoursWorked;
	}

	//Setter for names, pay rates and hours
	public void setNameRateHours(String first, String last, int regularRate, int totalHours, int special)
	{
		super.setName(first,last);
		regularPayRate = regularRate;
		overtimePayRate = regularPayRate*1.5;
		hoursWorked = totalHours - special;
		hoursSpecial = special;
	}

	//Method that calculates the final pay
	public double calculatePay()
	{
		double finalPay = 0;
		finalPay += specialPayRate * hoursSpecial;
		if(hoursWorked > 30)
		{
			finalPay += (hoursWorked - 30) * overtimePayRate; //Hours above 30 at the overtime rate
			finalPay += 30 * regularPayRate;
		}
		else
		{
			finalPay += hoursWorked * regularPayRate;
		}
		return finalPay;
	}

	//toString method
	public String toString()
	{
		String info = super.toString();
		info += " Final pay for the Advisor: "+calculatePay();
		return info;
	}

	//Main method -> test of the method
	public static void main(String[] args)
	{
		//Test the main method
		Scanner imTheReader = new Scanner(System.in);

		System.out.println("Enter First Name: ");
		String first = imTheReader.next();
		System.out.println("Enter Last Name: ");
		String last = imTheReader.next();
		System.out.println("Enter Hours Worked: ");
		int totalHours = imTheReader.nextInt();
		System.out.println("Enter Special Hours (if no special, enter 0): ");
		int special = imTheReader.nextInt();

		PaidAdvisor pa = new PaidAdvisor(first,last,totalHours,special);
		System.out.println(pa); //This prints the toString method of the Advisor!
	}

}