package playground;

public class LoadData {

	public LoadData() {

		// Adding new customers
		Data.newCustomer("a", 34534, "a");
		Data.newCustomer("Subash", 19000, "test");
		Data.newCustomer("Karnan", 4499, "test");
		Data.newCustomer("Kumar", 6599, "test");
		Data.newCustomer("Jayesh", 4939, "test");
		Data.newCustomer("Lokesh", 3749, "test");
		Data.newCustomer("Nukumar", 2445, "test");

		// Adding Routes
		Data.newRoute("Tiruvannamalai", "Temple Tiruvannamalau.Tamilnadu", 200);
		Data.newRoute("Pondicherry", "Auroville,pondicherry,India 678600", 300);
		Data.newRoute("Chennai Central", "MGR Central Railwaystation, Chennai,Tamilnadu,India 678600", 800);
		Data.newRoute("Chennai Egmore", "EGMORE Railwaystation, Chennai,Tamilnadu,India 678600", 750);
		Data.newRoute("Palakkad", "Palakkad Junction, Palakkad,Kerala,India 678600", 1250);
		Data.newRoute("Delhi", "Palakkad Junction, Palakkad,Kerala,India 678600", 6700);

		// Adding Car --> seatingCapacity, numberPlate, mileage, averageSpeed
		Data.newCar(4, "TN05X4954", 26, 55);
		Data.newCar(5, "TN06X4855", 30, 55);
		Data.newCar(6, "TN07X4756", 40, 70);
		Data.newCar(7, "TN08X4657", 35, 65);
		Data.newCar(9, "TN05X4758", 33, 80);
		Data.newCar(2, "TN05X4259", 39, 67);
		
		 //newTrip(Route route, Customer customer, Car car, int countTravellers)
		Data.newTrip(Data.getRoute("Tiruvannamalai") ,Data.getCustomer("subash", "test"), Data.nextAvailableCar(5),5).endTransit();
		Data.newTrip(Data.getRoute("Chennai Central") ,Data.getCustomer("subash", "test"), Data.nextAvailableCar(5),5).endTransit();
		Data.newTrip(Data.getRoute("Pondicherry") ,Data.getCustomer("subash", "test"), Data.nextAvailableCar(5),5).endTransit();
	}

}
