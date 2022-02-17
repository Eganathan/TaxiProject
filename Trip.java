

import java.util.Date;

public class Trip {

	private Route route;
	private Customer customer;
	private Date startTime;
	private Date endTime;
	static int tripCount;
	private boolean inTransit;
	private Car car;
	private int countTravellers;
	private final int ID = tripCount;

	Trip(Route route, Customer customer, Car car, int countTravellers) {
		this.route = route;
		this.customer = customer;
		this.countTravellers = countTravellers;
		this.car = car;
		tripCount++;
	}

//-----------------------------------------------> GETTERS

	public Route getRoute() {
		return route;
	}

	public Customer getCustomer() {
		System.out.println(customer.getCustomerName() + "> getCustomer();");
		return customer;
	}

	public static int getTripCount() {
		return tripCount;
	}

	public boolean getAvailability() {
		return this.inTransit;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public Car getCar() {
		return car;
	}

	public int getTravellerCount() {
		return this.countTravellers;
	}

	int getID() {
		return this.ID;
	}
	// -----------------------------------------------> SETTERS

	public void startTransit() {
		this.car.changeAvailablity();
		this.inTransit = true;
		this.startTime = new Date();

	}

	public boolean inTransit() {
		return this.inTransit = true;
	}

	public void endTransit() {
		this.endTime = new Date();
		this.inTransit = false;
	}

	public float tripCost() {
		return Finanance.getTripCoast(route.getDistanceInKm())[0];
	}

}
