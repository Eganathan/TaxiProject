package playground;

import java.util.Scanner;

public class App{
	
	Customer currentCustomer;

	App() {

		Scanner sc = new Scanner(System.in);
		boolean run = true;
		while (run) {
			
			System.out.println("Please Enter Your Name :  ");
			String name = sc.nextLine();

			if (Data.customerExists(name)) {
				System.out.println("Please Enter Your Password : ");
				String password = sc.nextLine();
				
				if(Data.getCustomer(name,password) != null)
				{
					currentCustomer = Data.getCustomer(name,password);
					run = false;
					menu(currentCustomer);
				}else {
					System.out.println("Please Try Again! Wrong Password!");
				}
			}
			else
			{
				System.out.println("User does not exist!");
			}
		}

		sc.close();
	}
	
	void menu(Customer c)
	{
		System.out.println("=====================================================================");
		System.out.println("\t \t Welcome back! "+"   || "+ c.getCustomerName());
		System.out.println("\t \tBalance: "+ c.getBalanceCash()+ "\t || No. Trips " + c.getTripCount());
		System.out.println("=====================================================================");
		
		
		msg("\n");
		msg("================================= MENU ==============================");
		msg("\t \t  Book a new trip -> (Enter 1)");
		msg("\t \t  Load money to Account -> (Enter 2)");
		msg("\t \t  Previous trips -> (Enter 3)");
		msg("\t \t  Change Password -> (Enter 4)");
		msg("\t \t  LogOut -> (Enter 5)");
		msg("\t \t  Exit -> (Enter 6)");
		
	}
	
	void msg(String s)
	{
		System.out.println(s);
	}

}
