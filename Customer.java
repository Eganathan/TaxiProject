package playground;

//import java.util.ArrayList;

public class Customer {

	private final String customerName;
	private int tripCount;
	private static int customerCount;
	private float loadedCash;
	private String password;
	//private ArrayList pastTrips;
	//private ArrayList upcommingTrips;
	

	Customer(String name,int cash, String pass){
		this.customerName = name;
		this.loadedCash = cash;
		this.password = pass;
		customerCount++;
	}
	
	//--------------------------> GETTERS
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
	
	//-------------------------SETTERS
	public void setTripCount(int tripCount) {
		this.tripCount = tripCount;
	}
	public void loadCash(int cash) {
		this.loadedCash += cash;
	}
	
	public void payBill(float amount)
	{
		this.loadedCash -= amount;
	}

}
