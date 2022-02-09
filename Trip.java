package playground;
import java.util.Date;

public class Trip {

	private Route route;
	private Customer customer;
	private Date startTime;
	private Date endTime;
	private static int tripCount;
	private boolean inTransit;
	private Car car;

	Trip(Route route, Customer customer ,boolean inTransit, Car car)
	{
		this.route = route;
		this.customer = customer;
		this.inTransit = true;	
		this.startTime = new Date();
		this.car = car;
		tripCount++;
	}
	
//-----------------------------------------------> GETTERS

	public Route getRoute() {
		return route;
	}

	public Customer getCustomer() {
		return customer;
	}

	public static int getTripCount() {
		return tripCount;
	}

	public boolean getAvailability(){
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
	
	//-----------------------------------------------> SETTERS

	public void startTransit(){
		this.car.changeAvailablity();
		this.inTransit = true;
		
	}
	
	public boolean inTransit(){
		return this.inTransit = true;
	}
	
	public void endTransit(){
		this.endTime = new Date();
		this.inTransit = false;
		this.car.changeAvailablity();
		this.customer.payBill(tripCost());
	}
	
	public float tripCost()
	{
		return Finanance.getTripCoast(route.getDistanceInKm())[0];
	}
	
	
}
