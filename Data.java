package playground;

import java.util.ArrayList;

public abstract class Data {

	private static ArrayList<Customer> customerInfo = new ArrayList<Customer>();
	private static ArrayList<Route> routeInfo = new ArrayList<Route>();
	private static ArrayList<Car> carsInfo = new ArrayList<Car>();
	private static ArrayList<Trip> tripsInfo = new ArrayList<Trip>();

	// ##################################################### START OF CUSTOMERS

	/*
	 * This block of code checks if the name is not null and it is not empty space
	 * and also if the name is outlast 3 char longS
	 * 
	 * @param name -> customer name
	 * 
	 * @param cash -> amount to deposit
	 */
	static boolean newCustomer(String name, int cash, String pass) {

		if (name == null || name.equals("") && name.length() >= 3 || pass == null && !customerExists(name))
			return false;

		if (cash < 0)
			return false;

		customerInfo.add(new Customer(name, cash, pass));
		return true;
	}

	// checks if the customer exists or not
	static boolean customerExists(String name) {
		for (Customer val : customerInfo) {
			if (name.equalsIgnoreCase(val.getCustomerName()))
				return true;
		}

		return false;
	}

	// returns the object of customer
	static Customer getCustomer(String name, String pass) {
		Customer val = null;
		for (Customer c : customerInfo) {
			if (c.getCustomerName().equalsIgnoreCase(name)) {
				val = c;
				break;
			}

		}

		if (val != null) {
			if (!val.getPassword().equals(pass))
				val = null;
		}

		return val;
	}

	// print Customer Data
	static boolean customerData() {
		System.out.println("-----------------------------------------");
		System.out.println("\t \t* Customer DETAILS *");
		System.out.println("-----------------------------------------");
		for (Customer c : customerInfo) {
			System.out.println("Name: \t" + c.getCustomerName());
			System.out.println("Balance Cash: \t" + c.getBalanceCash());
			System.out.println("Trips : \t" + c.getTripCount());
			System.out.println("-------------");
		}
		System.out.println("No. Customers :  \t" + Customer.getCustomerCount());
		return false;
	}
//##################################################### END OF CUSTOMERS

// #################################################### START OF ROUT

	static boolean newRoute(String routeName, String fullAddress, int distance) {
		if (routeName == null || fullAddress == null || distance < 0 && !routeExists(routeName))
			return false;

		routeInfo.add(new Route(routeName, fullAddress, distance));
		return true;
	}

	// checks if the customer exists or not
	static boolean routeExists(String routeName) {
		for (Route val : routeInfo) {
			if (routeName.equals(val.getRouteName()))
				return true;
		}

		return false;
	}

	// print Route Data
	static boolean routeData() {
		System.out.println("-----------------------------------------");
		System.out.println("\t \t* ROUTE DETAILS *");
		System.out.println("-----------------------------------------");
		for (Route r : routeInfo) {

			System.out.println("Route Name: \t" + r.getRouteName());
			System.out.println("Address: \t" + r.getFullAddress());
			System.out.println("Distance: \t" + r.getDistanceInKm() + " Km");
			System.out.println("-------------");
		}
		System.out.println("No. Routes Available:  \t" + Route.getRouteCount());
		return false;
	}
// #################################################### END OF ROUT

// #################################################### START OF CAR
	static boolean newCar(int seatingCapacity, String numberPlate, int mileage, int averageSpeed) {

		if (seatingCapacity < 2 || numberPlate == null || mileage <= 1 || averageSpeed <= 1 && !carExists(numberPlate))

			return false;

		carsInfo.add(new Car(seatingCapacity, numberPlate, mileage, averageSpeed));
		return true;
	}

	// checks if the car exists or not
	static boolean carExists(String carName) {
		for (Car val : carsInfo) {
			if (carName.equals(val.getNumberPlate()))
				return true;
		}

		return false;
	}

	static Car nextAvailableCar() {
		for (Car c : carsInfo) {
			if (c.getAvailability())
				return c;
		}
		return null;
	}

	// print Car Data
	static boolean carData() {
		System.out.println("-----------------------------------------");
		System.out.println("\t \t* CAR DETAILS *");
		System.out.println("-----------------------------------------");
		for (Car c : carsInfo) {

			System.out.println("Car Name: \t" + c.getNumberPlate());
			System.out.println("Capacity : \t" + c.getCapacity());
			System.out.println("Mileage: \t" + c.getMailage() + "/liter");
			System.out.println("Availablity: \t" + c.getAvailability());
			System.out.println("-------------");
		}
		System.out.println("No. Cars Available:  \t" + Car.carCount());
		return false;
	}
// #################################################### END OF CAR

// #################################################### START OF TRIP
	// start the trip
	static boolean newTrip(Route route, Customer customer, boolean inTransit, Car car) {

		if (route == null || customer == null || car == null)
			return false;
		tripsInfo.add(new Trip(route, customer, inTransit, nextAvailableCar()));
		return true;
	}

	// stop the trip
	static boolean stopTrip(Trip t) {
		t.endTransit();
		return true;
	}

	// print Trip Data
	static boolean tripData() {
		System.out.println("-----------------------------------------");
		System.out.println("\t \t* TRIP DETAILS *");
		System.out.println("-----------------------------------------");
		for (Trip t : tripsInfo) {

			System.out.println("Route Name: \t" + t.getRoute().getRouteName());
			System.out.println("Customers Name: \t" + t.getCustomer().getCustomerName());
			System.out.println("Cars Number: \t" + t.getCar().getNumberPlate());
			System.out.println("In Transit: \t" + t.inTransit());
			System.out.println("Start Time: \t" + t.getStartTime());
			System.out.println("End Time: \t" + t.getEndTime());
			System.out.println("Distance : \t" + t.getRoute().getDistanceInKm());
			System.out.println("Cost : \t" + t.tripCost());
			System.out.println("-------------");
		}
		System.out.println("No. Cars Available:  \t" + Car.carCount());
		return false;
	}

}
