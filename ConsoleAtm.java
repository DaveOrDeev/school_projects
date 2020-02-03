//Student David Arroyo

import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.*;
public class ConsoleAtm {
	
	  static //declare a Scanner class object
	  Scanner sc = new Scanner(System.in);
	  
	  //2 decimal format
	  DecimalFormat df = new DecimalFormat("####0.00");
	  
	
	public static void Pin(){
		int i = 1, pin = 0, intlocate = 0;
		
		
		System.out.println("Welcome to the Virtual ATM Program, please enter your 4 digit pin number");
		pin = sc.nextInt();
		if (pin >= 0100 && pin <= 8888)intlocate = 1;
		if (pin < 0100 && pin > 8888)intlocate = 2;
		
		switch(intlocate) {
	  case 1: System.out.println("Access granted"); 
	  Afterpin();break;
      case 2: System.out.println("invalid pin, pleasae try again\n"); break;
      default: System.out.println("invalid pin, pleasae try again\n"); Pin();
		}
	}
	
		public static void Afterpin(){
			int select = 0;
			
			System.out.println("Please choose an account to make a transaction in\n");
			System.out.println("Enter '1' for Savings Account");
			System.out.println("Enter '2' for Checkings Account");
			System.out.println("Enter '3' to make a payment on a loan");
			select = sc.nextInt();
			if (select == 1){
				Savings();
			}
			if (select == 2){
				Checkings();
			}
			if (select == 3){
				Loan();
			}
			else{
				System.out.println("Invalid number, please try again\n");
				Afterpin();
			}
		}
			
		public static void Savings(){
			int select = 0;
			
			System.out.println("Welcome to your Savings Account\n");
			System.out.println("Enter '1' to make a Deposit");
			System.out.println("Enter '2' to make a Withdrawal");
			System.out.println("Enter '3' to go back to the main menu");
			select = sc.nextInt();
			if (select == 1){
				Deposit();
			}
			if (select == 2){
				Withdraw();
			}
			if (select == 3){
				Afterpin();
			}
			else{
			System.out.println("Invalid number, please try again\n");
			Savings();
			}
		
		}
		
		public static void Checkings() {
			int select = 0;
			
			System.out.println("Welcome to your Checkings Account\n");
			System.out.println("Enter '1' to make a Deposit");
			System.out.println("Enter '2' to make a Withdrawal");
			System.out.println("Enter '3' to go back to the main menu");
			select = sc.nextInt();
			
			if (select == 1){
				Deposit();
			}
			if (select == 2){
				Withdraw();
			}
			if (select == 3){
				Afterpin();
			}
			else{
			System.out.println("Invalid number, please try again\n");
			Checkings();
			}
			}
			
			public static void Deposit(){
				double balance = 3000 , in = 0;
				int select = 0;
				
				System.out.println("Please insert your deposit amount");
				in = sc.nextDouble();
				balance += in;
				System.out.println("New balance after deposit\t $" + balance + "\n" + "\nTo return to the main menu, type '1'" + "\nTo exit the program, type '2'");
				select = sc.nextInt();
				
				if (select == 1){
					Afterpin();
				}
				if (select == 2){
					System.exit(2);
				}
				else{
				System.out.println("Invalid number, system will now exit");
				System.exit(2);
				}
				}	
				
			public static void Withdraw(){
				double balance = 3000, in = 0;
				int select = 0;
				
				System.out.println("Please insert the amount you want to withdraw");
				in = sc.nextDouble();
				balance -= in;
				System.out.println("New balance after Withdrawal\t $" + balance );
				
				if (balance < 500){
					System.out.println("WARNING, BALANCE LOW!\t$" + balance);
				}
				System.out.println("To return to the main menu, type '1'");
				System.out.println("To exit the program, type '2'");
				select = sc.nextInt();
				
				if (select == 1){
					Afterpin();
				}
				if (select == 2){
					System.exit(2);
				}
				
				else{
				System.out.println("Invalid number, system will now exit");
				System.exit(2);
				}
			
				}
				
				
				
		
		
		public static void Loan(){
			int select = 0;
			
			System.out.println("Welcome to your Loan Payment Account\n");
			System.out.println("Enter '1' to pay your Monthly Mortgage payment");
			System.out.println("Enter '2' to pay your Monthly Student Loan payment");
			System.out.println("Enter '3' to pay your Monthly Auto Loan payment");
			System.out.println("Enter '4' to pay your Monthly Personal Loan payment");
			System.out.println("Enter '5' to go back to the main menu");
			select = sc.nextInt();
			
			if (select == 1){
				Mortgage();
			}
			if (select == 2){
				Student();
			}
			if (select == 3){
				Auto();
			}
			if (select == 4){
				Pers();
			}
			if (select == 5){
				Afterpin();
			}
			else{
			System.out.println("Invalid number, please try again\n");
			Loan();
			
		}
		}
		
		public static void Mortgage(){
			double balance = 250000;
			int select = 0, pay = 2000, many = 0;
			
			System.out.println("How many payments would you like to make ($2000 per payment)");
			many = sc.nextInt();
			
			pay *= many;
			balance -= pay;
			
			System.out.println("Loan amount remaining\t $" + balance + "\n" + "\nTo return to the main menu, type '1'" + "\nTo exit the program, type '2'");
			select = sc.nextInt();
			
			if (select == 1){
				Afterpin();
			}
			if (select == 2){
				System.exit(2);
			}
			
			else{
			System.out.println("Invalid number, system will now exit");
			System.exit(2);
			}
		}
		
		public static void Student(){
			double balance = 55000;
			int select = 0, pay = 200, many = 0;
			
			System.out.println("How many payments would you like to make ($200 per payment)");
			many = sc.nextInt();
			
			pay *= many;
			balance -= pay;
			
			System.out.println("Loan amount remaining\t $" + balance + "\n" + "\nTo return to the main menu, type '1'" + "\nTo exit the program, type '2'");
			select = sc.nextInt();
			
			if (select == 1){
				Afterpin();
			}
			if (select == 2){
				System.exit(2);
			}
			
			else{
			System.out.println("Invalid number, system will now exit");
			System.exit(2);
			}
		
		}
		
		public static void Auto(){
			double balance = 45000;
			int select = 0, pay = 500, many = 0;
			
			System.out.println("How many payments would you like to make ($500 per payment)");
			many = sc.nextInt();
			
			pay *= many;
			balance -= pay;
			
			System.out.println("Loan amount remaining\t $" + balance + "\n" + "\nTo return to the main menu, type '1'" + "\nTo exit the program, type '2'");
			select = sc.nextInt();
			
			if (select == 1){
				Afterpin();
			}
			if (select == 2){
				System.exit(2);
			}
			
			else{
			System.out.println("Invalid number, system will now exit");
			System.exit(2);
			}
		}
			public static void Pers(){
				double balance = 4000;
				int select = 0, pay = 1000, many = 0;
				
				System.out.println("How many payments would you like to make ($1000 per payment)");
				many = sc.nextInt();
				
				pay *= many;
				balance -= pay;
				
				System.out.println("Loan amount remaining\t $" + balance + "\n" + "\nTo return to the main menu, type '1'" + "\nTo exit the program, type '2'");
				select = sc.nextInt();
				
				if (select == 1){
					Afterpin();
				}
				if (select == 2){
					System.exit(2);
				}
				
				else{
				System.out.println("Invalid number, system will now exit");
				System.exit(2);
				}
			}

	
	
		public static void main(String args[]){
			Pin();
		}
}
