import java.util.ArrayList;
import java.util.Stack;

public class Customer {

	private final String customerName;
	private int tripCount;
	private static int customerCount;

	private float loadedCash;
	private String password;
	 ArrayList<Trip> pastTrips = new ArrayList<Trip>();
	private Stack<Trip> currentTrips = new Stack<Trip>();

	Customer(String name, int cash, String pass) {
		this.customerName = name;
		this.loadedCash = cash;
		this.password = pass;
		customerCount++;
	}

	// --------------------------> GETTERS
	public int getTripCount() {
		return this.tripCount;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public static int getCustomerCount() {
		return customerCount;
	}

	public float getBalanceCash() {
		return this.loadedCash;
	}

	public String getPassword() {
		return this.password;
	}

	public String getLastTrip() {
		if (pastTrips.size() > 1)
			return this.pastTrips.get(pastTrips.size() - 1).toString();
		return "0";
	}

	public Trip getLastTripObject() {
		if (this.currentTrips.peek() != null)
			return this.currentTrips.peek();

		return null;
	}
	
	public int getKmTravelled(){
		
		int distanceKm = 0;
		
		for(Trip t:pastTrips) {
			distanceKm += t.getRoute().getDistanceInKm();
		}
	return distanceKm;	
	}
	
	

	// -------------------------SETTERS
	public void loadCash(int cash) {
		this.loadedCash += cash;
	}

	public void payBill(float amount, Trip t) {
		this.loadedCash -= amount;
		this.tripCount++;
		this.pastTrips.add(t);
		Finanance.addToBank(amount);
		Main.cGUI.reloadDashCompanyGUI();
		

	}

	Trip newTrip(Trip t) {
		currentTrips.add(t);
		return t;
	}
	
	public static void setCustomerCount(int customerCount) {
		Customer.customerCount = customerCount;
	}

}
