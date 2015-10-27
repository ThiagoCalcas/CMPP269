//Diana Pettit
//August, 2014
//Debts.java
//read data from infile and write output to file

import java.util.*;
import java.text.SimpleDateFormat;
import java.io.*;

public class DebtsForStudents
{ 
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

	ArrayList<Double> aryRates = new ArrayList<Double>();
	ArrayList<Double> aryPayments = new ArrayList<Double>();
	ArrayList<String> aryNames = new ArrayList<String>();
	
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
	
	
    Scanner sc = new Scanner(System.in);
    String Out;
    String In;
    System.out.print("Please enter the path and file to which you wish to save the output: ");
    Out = sc.nextLine();
    UtilityClass outfile = new UtilityClass(Out);   	//create a new instance of UtilityClass
    outfile.openFile(); 								//call to method openFile from UtilityClass
    
    System.out.print("Please enter the path a.34*300nd file from which you wish to access data: ");
    In = sc.nextLine();
    UtilityClassIn infile = new UtilityClassIn(In);  	//create a new instance of UtilityClassIn
    infile.openInFile(); 								//call to method openFile from UtilityClassIn   
   
														//call to method for name 
														//write name to outfile
														//date to method for date
														//write date to outfile
    Scanner inputFile=new Scanner(In);
    String line=infile.readLineFromFile();  

    while (line !=null)
    {	 
       String[] nextfield=line.split(",");
									//FOR LOOP for checking if a field is blank ONLY THE AMOUNT OR INTEREST RATE WILL BE BLANK IN YOUR INFILE
									//if statement for error checking
			
									//tell your user which field is blank
									//exit the program
			
			
		else						//otherwise, continue with the assignment of fields
		{
			loanName=nextfield[0];   						//assigning array value to a double - can use array name and index, but this is easier
			loanType=nextfield[1]; 							//test this, by using the array index in your a print statement in your code somewhere
															// String sub1				
															//String sub2
															//Concatenate and return to loanType
			amountIn=nextfield[2];  
			rateIn=nextfield[3]; 	   
			paymentPercentIn=nextfield[4]; 
		}
									1//end for
	 
	   amount = Double.parseDouble(amountIn);	   				//parsing the String to a double
	   rate=Double.parseDouble(rateIn);							//parsing the String to a double
	   paymentPercent=Double.parseDouble(paymentPercentIn);		//parsing the String a  to double
	  
	   if (loanName.compareTo("TD")==0)							//checking for String character "TD" because it is not a % of balance, it is a straight payment
	  {
	    
	    System.out.printf("Loan Institution: %s \n",loanName);
		System.out.printf("Loan Type: %s\n",loanType);
		System.out.printf("Loan Amount: $%.2f\n" ,amount);
		System.out.printf("Interest Rate: %.3f%%\n" ,rate);		//escaping the % sign
		System.out.printf("Payment Amount: $%.2f\n" ,paymentPercent);
		System.out.println();		
	}	
	  else 
	  {
	    System.out.printf("Loan Institution: %s \n",loanName);
		System.out.printf("Loan Type: %s\n",loanType);
		System.out.printf("Loan Amount: $%.2f\n" ,amount);
		System.out.printf("Interest Rate: %.3f%%\n" ,rate);		//escaping the % sign
	    System.out.printf("Payment Rate: %.2f%%\n" ,paymentPercent);
		System.out.println();	
	  }	

	  numRecords++;
	
	   line = infile.readLineFromFile();
	}  //end while
	// System.out.println("Index is " +i);		//uncomment this code and run this, so you can see what the index is doing
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