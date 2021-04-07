import java.util.Scanner;

public class Account {

	//variables
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;
	
	//constructor
	Account (String cName, String cID){
		customerName = cName;
		customerID = cID;
		
	}
	
	//Function for depositing money
	void deposit (int amount) {
		if (amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
			
		}
	}
	
	//function to withdrawing money
	void withdraw(int amount) {
		if (amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount;
			
		}
	}
	
	//function showing the previous transaction
	
	void getPreviousTransaction() {
			
		if (previousTransaction > 0) {
			System.out.println("deposited: " + previousTransaction);
				
		} else if (previousTransaction < 0) {
			System.out.println("withdraw: " + Math.abs(previousTransaction));
				
		} else {
			System.out.println("No Transaction occured");
				
		}
	
	}
	
	// calculating interests according to a number of years
	void calculateInterest(int years) {
		double interestRate = .0185;
		double newBalance = (balance * interestRate * years) + balance;
		System.out.println("The current interest rate is " + (100 * interestRate) + "%");
		System.out.println("after " + years + "years, your balance will be " + newBalance);
		
	}
	
	void showMenu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome " + customerName + ".");
		System.out.println("Customer ID: " + customerID);
		System.out.println();
		System.out.println("Actions");
		System.out.println();
		System.out.println("A - Check Balance");
		System.out.println("B - Make a deposit");
		System.out.println("C - make a withdrawal");
		System.out.println("D - previous transaction");
		System.out.println("E - Calculate interests");
		System.out.println("F - Exit");
		
		do {
			System.out.println();
			System.out.println("Enter options:");
			char option1 = scanner.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch(option) {
			
			//Check balance
			case 'A':
				System.out.println("-----------------");
				System.out.println("Balance = $ " + balance);
				System.out.println("------------------");
				System.out.println();
				break;
				
			//deposit money
			case 'B':
				System.out.println("Enter amount to deposit");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println();
				break;
				
			//withdraw money
			case 'C':
				System.out.println("Enter amount to withdraw");
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println();
				break;
				
			//view the most recent transaction
			case 'D':
				System.out.println("----------------");
				getPreviousTransaction();
				System.out.println("-----------------");
				System.out.println();
				break;
				
			//calculate interests
			case 'E':
				System.out.println("Enter how many years of accrued interest: ");
				int years = scanner.nextInt();
				calculateInterest(years);
				break;

			//exit
			case 'F':
				System.out.println("------------");
				break;
				
			default:
				System.out.println("Error Invalid Obtion");
				break;	
				}
			
			} while (option != 'F');
			System.out.println("Thank you");

		
			
		}
	
		
	}
	
	
	
	
	

