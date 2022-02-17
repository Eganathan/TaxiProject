
import java.util.ArrayList;
import java.util.LinkedList;

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

	// prints all Customer Data
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

	// payment by the customer
	static void customerPayment(String name, String pass, float amount, int tripID) {
		getCustomer(name, pass).newTrip(tripsInfo.get(tripID));
		getCustomer(name, pass).payBill(amount, tripsInfo.get(tripID));
		stopTrip(tripsInfo.get(tripID));
	}

	// prints specified customer data
	static boolean myDataOfCustomer(Customer c) {
		System.out.println("-----------------------------------------");
		System.out.println("\t \t* Your DETAILS *");
		System.out.println("-----------------------------------------");

		customerInfo.indexOf(c);

		System.out.println("Name: \t" + c.getCustomerName());
		System.out.println("Balance Cash: \t" + c.getBalanceCash());
		System.out.println("Trips : \t" + c.getTripCount());
		System.out.println("Previous Trip:  \t" + c.getLastTrip());
		System.out.println("-------------");
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

	// checks if the route exists or not
	static boolean routeExists(String routeName) {
		for (Route val : routeInfo) {
			if (routeName.equalsIgnoreCase(val.getRouteName()))
				return true;
		}

		return false;
	}

	// Return route
	static Route getRoute(String routeName) {
		for (Route route : routeInfo) {
			if (routeName.equalsIgnoreCase(route.getRouteName()))
				return route;
		}

		return null;
	}

	static boolean routeDetails(Route r) {
		if (r != null) {
			System.out.println("||                                   ");
			System.out.println("|| Route Name:" + r.getRouteName());
			System.out.println("|| Distance : " + r.getDistanceInKm() + "Km");
			System.out.println("|| Address :" + r.getFullAddress());
			System.out.println("|| Tax  :" + Finanance.getTripCoast(r.getDistanceInKm())[2]);
			System.out.println("|| Cess :" + Finanance.getTripCoast(r.getDistanceInKm())[1]);
			System.out.println("|| G. Total :" + Finanance.getTripCoast(r.getDistanceInKm())[0]);
			System.out.println("||                                   ");
			return true;
		}
		return false;
	}

	static ArrayList<String> getRouteNameList() {
		ArrayList<String> routeNames = new ArrayList<String>();

		if (routeInfo != null) {
			for (Route r : routeInfo) {
				routeNames.add(r.getRouteName());
			}
		}

		return routeNames;
	}

	// print Route Data
	static boolean routeData() {
		int counter = 0;
		System.out.println("-----------------------------------------");
		System.out.println("\t \t* ROUTE DETAILS *");
		System.out.println("-----------------------------------------");
		for (Route r : routeInfo) {
			System.out.println("OPTION NO:\t" + counter++);
			System.out.println("Route Name: \t" + r.getRouteName());
			System.out.println("Address: \t" + r.getFullAddress());
			System.out.println("Distance: \t" + r.getDistanceInKm() + " Km");
			System.out.println("-------------");
		}
		System.out.println("No. Routes Available:  \t" + Route.getRouteCount());
		return false;
	}
	
	static int getRouteCount(){
		return Route.getRouteCount();
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

	// sends an available car
	static Car nextAvailableCar(int countOfCustomer) {

		for (Car c : carsInfo) {
			if (c.getAvailability() && c.getCapacity() >= countOfCustomer) {
				return c;

			}

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
	
	static ArrayList<String> getCarNumberAsList()
	{
		ArrayList<String> carList = new ArrayList<>();
				
		for(Car c:carsInfo)
		{
			carList.add(c.getNumberPlate());
		}
		return carList;
	}
	
	//int seatingCapacity, String numberPlate, int mileage, int averageSpeed
	static Car getCarNumber(String car)
	{
		for(Car c: carsInfo)
		{
			if(c.getNumberPlate().equals(car))
			{
				return c;
			}
		}
		return null;
		
	}
// #################################################### END OF CAR

// #################################################### START OF TRIP
	// start the trip
	static Trip newTrip(Route route, Customer customer, Car car, int countTravellers) {
		if (route == null || customer == null || car == null)
			return null;
		tripsInfo.add(new Trip(route, customer, nextAvailableCar(countTravellers), countTravellers));
		//customer.pastTrips.add(tripsInfo.get( tripsInfo.size()-1));
		return tripsInfo.get(tripsInfo.size() - 1);
	}

	static Trip getTripByID(int id) {
		return tripsInfo.get(id);
	}

	// stop the trip
	static boolean stopTrip(Trip t) {
		if (t != null) {
			t.endTransit();
			t.getCar().changeAvailablity();
		}
		return true;
	}
	
	static ArrayList<String> getTripsInfoAsList()
	{
		ArrayList<String> tripInfoAsList =new ArrayList<>();
		for(Trip t: tripsInfo)
		{
			StringBuilder sb = new StringBuilder();
			
			sb.append(t.getID() +" \t");
			sb.append(t.getRoute().getRouteName() +" \t");
			sb.append(t.getTravellerCount() +" \t");
			sb.append(t.getRoute().getDistanceInKm() +" \t");
			
			tripInfoAsList.add( sb.toString());
		}
		
		return tripInfoAsList;
	}

	// print Trip Data
	static boolean tripData() {
		System.out.println("-----------------------------------------");
		System.out.println("\t \t* TRIP DETAILS *");
		System.out.println("-----------------------------------------");
		for (Trip t : tripsInfo) {

			System.out.println("ID : \t" + t.getID());
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
	
	//#==============================================================================Finances values

	static void updateFin() {
		for (Trip t : tripsInfo) {
			float[] x = Finanance.getTripCoast(t.getRoute().getDistanceInKm());

			Finanance.setBANKBALANCE(Finanance.getBANKBALANCE() + x[0]);
			Finanance.setCESS(Finanance.getCESS() + x[1]);
			Finanance.setTAX(Finanance.getTAX() + x[2]);
		}

	}

}
