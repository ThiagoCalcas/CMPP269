
//Name: Brett and Thiago
//Date: November 12, 2014
//File: AssignmentThree.java
//read data from infile and write output to file

import java.util.*;
import java.text.SimpleDateFormat;
import java.io.*;

public class AssignmentThree
{
	public static int MAX_PAY_FROM_GROSS = 30;
	public static String DOLLAR = "$";
	
	public static void main (String[] args)
	{
		String loanName=null;
		String highRateLoanName=null;
		String lowRateLoanName=null;
		String highPmtLoanName=null;
		String lowPmtLoanName=null;
		String loanType=null;
		String amountIn=null;
		String rateIn=null;
		String paymentPercentIn=null;
		double amount=0;
		double rate=0;

		ArrayList<Double> aryListRates = new ArrayList<Double>();
		ArrayList<Double> aryListyPayments = new ArrayList<Double>();
		ArrayList<String> aryListNames = new ArrayList<String>();
	
		double paymentPercent=0;
		double payment=0;
		double interestPerYear=0;
		double totalPayments=0;
		double highRate=0;
		double lowRate=10000;
		double highPmt=0;
		double lowPmt=10000;

		double income=0;
		double debtServicing=0;
		double overUnder=0;
		double balance=0;
		int numRecords=0;    
		int counter=0;
		String hex = "25";
		int percentSign = Integer.parseInt(hex,16);
		
		Scanner sc = new Scanner(System.in);
		String Out;
		String In;
		System.out.print("Please enter the path and file to which you wish to save the output: ");
		Out = sc.nextLine();
		UtilityClass outfile = new UtilityClass(Out);   	//create a new instance of UtilityClass
		outfile.openFile(); 								//call to method openFile from UtilityClass
    
		System.out.print("Please enter the path and file from which you wish to access data: ");
		In = sc.nextLine();
		UtilityClassIn infile = new UtilityClassIn(In);  	//create a new instance of UtilityClassIn
		infile.openInFile(); 								//call to method openFile from UtilityClassIn   
   
		String names = outfile.myName();					//call to method for name 
		System.out.println(names);							//write name to outfile
		outfile.writeLineToFile(names + "\n");
		String date = outfile.myDate();						//date to method for date
		System.out.println(date);							//write date to outfile
		outfile.writeLineToFile(date + "\n");
		
		Scanner inputFile=new Scanner(In);
		String line=infile.readLineFromFile();  

		while (line !=null)
		{	 
			String[] nextfield=line.split(",");
			
			//FOR LOOP for checking if a field is blank ONLY THE AMOUNT OR INTEREST RATE WILL BE BLANK IN YOUR INFILE
			for (counter = 0; counter < nextfield.length; counter++ )		
			{
				if (counter == 2 && nextfield[counter].equals(""))					//if statement for error checking
				{
					System.out.println("Error: Amount field for " + nextfield[0] + " is blank.");	//tell your user which field is blank
					outfile.writeLineToFile("Error: Amount field for " + nextfield[0] + " is blank.\n");
					System.exit(0);											//exit the program					
				}

				
				else if (counter == 3 && nextfield[counter].equals(""))
				{
					System.out.println("Error: Rate field for " + nextfield[0] + " is blank.");	//tell your user which field is blank
					outfile.writeLineToFile("Error: Rate field for " + nextfield[0] + " is blank.\n");
					System.exit(0);										//exit the program					
				}
				else						//otherwise, continue with the assignment of fields
				{
					loanName=nextfield[0];   								//assigning array value to a double - can use array name and index, but this is easier
					loanType=nextfield[1]; 									//test this, by using the array index in your a print statement in your code somewhere
					String sub1 = loanType.substring(0,1).toUpperCase();	//String sub1				
					String sub2 = loanType.substring(1).toLowerCase();		//String sub2
					loanType = sub1+sub2;									//Concatenate and return to loanType
					amountIn=nextfield[2];  
					rateIn=nextfield[3]; 	   
					paymentPercentIn=nextfield[4]; 
				}
			}						//end for
			
			amount = Double.parseDouble(amountIn);	   					//parsing the String to a double
			rate = Double.parseDouble(rateIn);							//parsing the String to a double
			paymentPercent = Double.parseDouble(paymentPercentIn);		//parsing the String a  to double

	   
			interestPerYear = amount * rate / 100;					//calculate interestPerYear
			payment = amount * paymentPercent / 100;					//calculate payment
	   
			if (loanName.compareTo("TD")==0)							//checking for String character "TD" because it is not a % of balance, it is a straight payment
			{
	    
				System.out.printf("Loan Institution: %s \n",loanName);
				System.out.printf("Loan Type: %s\n",loanType);
				System.out.printf("Loan Amount: %s%.2f\n" ,DOLLAR, amount);
				System.out.printf("Interest Rate: %.3f%c\n" ,rate, percentSign);		//escaping the % sign
				System.out.printf("Interese Paid Per year: %s%.2f\n",DOLLAR ,interestPerYear);
				System.out.printf("Payment Amount: %s%.2f\n\n",DOLLAR ,paymentPercent);
				outfile.writeLineToFile("Loan Institution: %s \n",loanName);
				outfile.writeLineToFile("Loan Type: %s\n",loanType);
				outfile.writeLineToFile("Loan Amount: %s%.2f\n" ,DOLLAR, amount);
				outfile.writeLineToFile("Interest Rate: %.3f%c\n" ,rate, percentSign);
				outfile.writeLineToFile("Interese Paid Per year: %s%.2f\n",DOLLAR ,interestPerYear);
				outfile.writeLineToFile("Payment Amount: %s%.2f\n\n",DOLLAR ,paymentPercent);
				payment = paymentPercent;
			}	
			else 
			{
				System.out.printf("Loan Institution: %s \n",loanName);
				System.out.printf("Loan Type: %s\n",loanType);
				System.out.printf("Loan Amount: %s%.2f\n",DOLLAR ,amount);
				System.out.printf("Interest Rate: %.3f%c\n" ,rate,percentSign);		//escaping the % sign
				System.out.printf("Payment Rate: %.2f%c\n" ,paymentPercent,percentSign);
				System.out.printf("Interese Paid Per year: %s%.2f\n" ,DOLLAR ,interestPerYear);
				System.out.printf("Payment Per Month: %s%.2f\n\n",DOLLAR  ,payment);
				outfile.writeLineToFile("Loan Institution: %s \n",loanName);
				outfile.writeLineToFile("Loan Type: %s\n",loanType);
				outfile.writeLineToFile("Loan Amount: %s%.2f\n",DOLLAR ,amount);
				outfile.writeLineToFile("Interest Rate: %.3f%c\n" ,rate,percentSign);
				outfile.writeLineToFile("Payment Rate: %.2f%c\n" ,paymentPercent,percentSign);
				outfile.writeLineToFile("Interese Paid Per year: %s%.2f\n" ,DOLLAR ,interestPerYear);
				outfile.writeLineToFile("Payment Per Month: %s%.2f\n\n",DOLLAR  ,payment);
			}	

			totalPayments = totalPayments + payment;
			
			aryListRates.add(numRecords,rate);
			aryListyPayments.add(numRecords,payment);
			aryListNames.add(numRecords,loanName);
			
			if (rate > highRate)
			{
				highRate = rate;
				highRateLoanName = loanName;
			}
			else if (rate < lowRate)
			{
				lowRate = rate;
				lowRateLoanName = loanName;
			}
			
			if (payment > highPmt)
			{
				highPmt = payment;
				highPmtLoanName = loanName;
			}
			else if (payment < lowPmt)
			{
				lowPmt = payment;
				lowPmtLoanName = loanName;
			}
			
			numRecords++;		
			line = infile.readLineFromFile();
		}  //end while
		// System.out.println("Index is " +i);		//uncomment this code and run this, so you can see what the index is doing
		
		System.out.println("Number of records processed is " + numRecords);
		System.out.println("Rates are " + aryListRates);
		System.out.println("Payments are " + aryListyPayments);
		System.out.println("Loan Institutions are " + aryListNames);
		outfile.writeLineToFile("Number of records processed is " + numRecords + "\n");
		outfile.writeLineToFile("Rates are " + aryListRates + "\n");
		outfile.writeLineToFile("Payments are " + aryListyPayments + "\n");
		outfile.writeLineToFile("Loan Institutions are " + aryListNames + "\n");
		
		System.out.printf("Highest rate is %.2f%c for %s\n",highRate, percentSign, highRateLoanName);
		System.out.printf("Lowest rate is %.2f%c for %s\n", lowRate, percentSign, lowRateLoanName);
		System.out.printf("Highest Payment is %s%.2f for %s\n",DOLLAR , highPmt, highPmtLoanName);
		System.out.printf("Lowest Payment is %s%.2f for %s\n",DOLLAR , lowPmt, lowPmtLoanName);
		System.out.printf("Total monthly payments are %s%.2f\n",DOLLAR , totalPayments);
		outfile.writeLineToFile("Highest rate is %.2f%c for %s\n",highRate, percentSign, highRateLoanName);
		outfile.writeLineToFile("Lowest rate is %.2f%c for %s\n", lowRate, percentSign, lowRateLoanName);
		outfile.writeLineToFile("Highest Payment is %s%.2f for %s\n",DOLLAR , highPmt, highPmtLoanName);
		outfile.writeLineToFile("Lowest Payment is %s%.2f for %s\n",DOLLAR , lowPmt, lowPmtLoanName);
		outfile.writeLineToFile("Total monthly payments are %s%.2f\n",DOLLAR , totalPayments);
		
		System.out.println("Enter your monthly income: ");
		income = sc.nextDouble();
		
		debtServicing = income * MAX_PAY_FROM_GROSS / 100.0;
		overUnder = totalPayments / income * 100;
		System.out.printf("Currently, %d%c of your income, which is the amount of money eligible for debt serving, is %s%.2f\n", MAX_PAY_FROM_GROSS, percentSign,DOLLAR , debtServicing);
		outfile.writeLineToFile("Currently, %d%c of your income, which is the amount of money eligible for debt serving, is %s%.2f\n", MAX_PAY_FROM_GROSS, percentSign,DOLLAR , debtServicing);
		if (overUnder <= MAX_PAY_FROM_GROSS)
		{
			System.out.printf("Currently you are at %.2f%c of your salary, and living withing your means\n\n", overUnder, percentSign);
			outfile.writeLineToFile("Currently you are at %.2f%c of your salary, and living withing your means\n\n", overUnder, percentSign);
		}
		else
		{
			System.out.printf("Currently you are at %.2f%c of your salary, and NOT living withing your means\n", overUnder, percentSign);
			System.out.printf("See a credit counselor immediately\n\n");
			outfile.writeLineToFile("Currently you are at %.2f%c of your salary, and NOT living withing your means\n", overUnder, percentSign);
			outfile.writeLineToFile("See a credit counselor immediately\n\n");
		}
		
		balance = income - totalPayments;
		System.out.printf("You will have %s%.2f left over to start paying off your highest interest, lowest payment credit card.",DOLLAR , balance);
		outfile.writeLineToFile("You will have %s%.2f left over to start paying off your highest interest, lowest payment credit card.",DOLLAR , balance);
		
		outfile.closeFile();
		infile.closeInFile();
	} //end main
}  //end Debts  
 
 /*
 debt.txt file
 
MasterCard,Revolving Credit Card,2562.67,18.8,03
Canadian Tire,Revolving Credit Card,2782.32,25.99,03
Sears,Revolving Credit Card,1437.55,25.99,03
CIBC,Convertible Student Loan,14322.48,6.525,01
TD,Car Loan,8496.91,10.2,154.78
*/
