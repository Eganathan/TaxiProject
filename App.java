package playground;

import java.util.Scanner;

public class App {

	private static Scanner sc;

	Customer currentCustomer;
	Trip currentTrip;

	App() {

		sc = new Scanner(System.in);

		loginCustomer();

		sc.close();
	}

	void loginCustomer() {
		boolean run = true;
		while (run) {

			System.out.println("Please Enter Your Name :  ");
			String name = sc.nextLine();

			if (Data.customerExists(name)) {
				System.out.println("Please Enter Your Password : ");
				String password = sc.nextLine();

				if (Data.getCustomer(name, password) != null) {
					currentCustomer = Data.getCustomer(name, password);
					run = false;
					menu(currentCustomer);
				} else {
					System.out.println("Please Try Again! Wrong Password!");
				}
			} else {
				System.out.println("User does not exist!");
			}
		}
	}

	void menu(Customer c) {
		boolean run = true;

		System.out.println("=====================================================================");
		System.out.println("\t \t Welcome back! " + "   || " + c.getCustomerName());
		System.out.println("\t \tBalance: " + Data.getCustomer(c.getCustomerName(), c.getPassword()).getBalanceCash()
				+ "\t || No. Trips " + c.getTripCount());
		System.out.println("=====================================================================");

		msg("\n");
		msg("================================= MENU ==============================");
		msg("\t \t  Book a new trip -> (Enter 1)");
		msg("\t \t  Load money to Account -> (Enter 2)");
		msg("\t \t  Previous trips -> (Enter 3)");
		msg("\t \t  Change Password -> (Enter 4)");
		msg("\t \t  LogOut -> (Enter 5)");
		msg("\t \t  Exit -> (Enter 6)");

		while (run) {

			int inp = sc.nextInt();
			if (inp >= 1 && inp <= 7) {
				switch (inp) {
				case 1:
					msg("New Trip [Selected]");
					newTripByCustomer();
					break;
				case 2:
					msg("Load Money[Selected]");
					break;
				case 3:
					msg("Previous Trips [Selected]");
					break;
				case 4:
					msg("Password Changing");
					break;
				case 5:
					currentCustomer = null;
					msg("Logged Out Succesfully");
					sc.nextLine();
					loginCustomer();
					break;
				case 6:
					System.out.flush();
					msg("See you later!");
					System.exit(0);
					break;

				case 7:
					Data.myDataOfCustomer(currentCustomer);
					break;
				default:
					msg("!Oh Oh Something went wrong!");

				}

			} else {
				msg("Please Try Again! -- Invalid Input!");
			}
		}

	}

	boolean newTripByCustomer() {
		boolean run = true;
		Data.routeData();

		msg("================== Please enter your preferred route name :");

		while (run) {
			Route newTripRoute;

			String option = sc.nextLine();
			if (Data.routeExists(option)) {
				newTripRoute = Data.getRoute(option);
				msg("==================================");
				Data.routeDetails(newTripRoute);
				msg("==================================");

				msg("1 ---> REQUEST TRIP NOW[ 1 ]");
				msg("2 ----> Discard   [ 2 ]");
				int val = sc.nextInt();
				Car availableCar = null;

				// Requesting TRIP
				if (val == 1) {

					if (Data.getCustomer(currentCustomer.getCustomerName(), currentCustomer.getPassword())
							.getBalanceCash() >= Finanance.getTripCoast(newTripRoute.getDistanceInKm())[0]) {
						msg("Please enter the number of travellers :");
						sc.nextLine();
						int capacity = sc.nextInt();

						// checking if the Capacity
						if (capacity <= 0 || capacity >= 10) {
							msg("Please enter a valid input!");
							newTripByCustomer();

						} else {
							availableCar = Data.nextAvailableCar(capacity);

							if (availableCar != null) // IF CAR IS NOT NULL
							{
								msg("Available Car : \t" + availableCar.getNumberPlate());// testing purpose
								msg("Route  : \t" + newTripRoute.getRouteName());// testing purpose

								currentTrip = Data.newTrip(newTripRoute, Data
										.getCustomer(currentCustomer.getCustomerName(), currentCustomer.getPassword()),
										availableCar, capacity);
								msg("Trip started--> press any key to end == TRIP ID: TXC" + currentTrip.getID());

								sc.nextLine();

								if (sc.nextLine() != null) {
									Data.customerPayment(currentCustomer.getCustomerName(),
											currentCustomer.getPassword(),
											Finanance.getTripCoast(newTripRoute.getDistanceInKm())[0],
											currentTrip.getID());
									msg("Hope You enjoyed the Trip, Here is your Bill");
									Finanance.printBill(currentTrip.getID());
									menu(currentCustomer);

								}
							} else {
								msg("Sorry we don't have anyting available to cater your needs. ");
								menu(currentCustomer);
							}

						}

					} else {
						msg("Sorry Your Balance is low! :( ");
						menu(currentCustomer);
					}

				} else {

					run = false;
					menu(currentCustomer);
				}

			} else {
				msg("Currently we are yet to reach there...");
			}

		}

		menu(currentCustomer);
		return true;
	}

	void msg(String s) {
		System.out.println(s);
	}
//to be removed!! 
void remove() {
}

}
