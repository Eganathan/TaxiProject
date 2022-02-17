
public class Car {

	private final int seatingCapacity;
	private final String numberPlate;
	private final int mileage;
	private boolean isAvailable;
	private int tripCount;
	private static int carCount;
	private int averageSpeed;

	public Car(int seatingCapacity, String numberPlate, int mileage, int averageSpeed) {
		this.seatingCapacity = seatingCapacity;
		this.numberPlate = numberPlate;
		this.mileage = mileage;
		this.isAvailable = true;
		this.averageSpeed = averageSpeed;
		carCount++;
	}

	// ------------------------> GETTERS
	// Capacity
	int getCapacity() {
		return this.seatingCapacity;
	}

	// Mileage
	int getMailage() {
		return this.mileage;
	}

	// Average Speed
	int getAverageSpeed() {
		return this.averageSpeed;
	}

	// Number plate
	String getNumberPlate() {
		return this.numberPlate;
	}

	// Availability
	boolean getAvailability() {
		return this.isAvailable;
	}

	// Trip Count
	int tripCount() {
		return tripCount;
	}

	// Number of Cars
	static int carCount() {
		return carCount;
	}

	// -----------------------> SETERS
	boolean changeAvailablity() {
		this.isAvailable = this.isAvailable ? false : true;
		return true;
	}

}
