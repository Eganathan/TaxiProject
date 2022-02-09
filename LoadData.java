package playground;

public class LoadData {

	public LoadData() {
		
		//Adding new customers
		Data.newCustomer("Subash",750,"test");
		Data.newCustomer("Karnan",499,"test");
		Data.newCustomer("Kumar",599,"test");
		Data.newCustomer("Jayesh",939,"test");
		Data.newCustomer("Lokesh",749,"test");
		Data.newCustomer("Nukumar",445,"test");
		
		//Adding Routes
		Data.newRoute("Tiruvannamalai", "Temple Tiruvannamalau.Tamilnadu", 750);
		Data.newRoute("Pondicherry", "Auroville,pondicherry,India 678600", 1900);
		Data.newRoute("Chennai Central", "MGR Central Railwaystation, Chennai,Tamilnadu,India 678600", 250);
		Data.newRoute("Chennai Egmore", "EGMORE Railwaystation, Chennai,Tamilnadu,India 678600", 200);
		Data.newRoute("Palakkad", "Palakkad Junction, Palakkad,Kerala,India 678600", 2450);
		
		//Adding Car --> seatingCapacity, numberPlate, mileage, averageSpeed
		Data.newCar(4,"TN05X4954",26,55);
		Data.newCar(5,"TN06X4855",30,55);
		Data.newCar(6,"TN07X4756",40,70);
		Data.newCar(7,"TN08X4657",35,65);
		Data.newCar(9,"TN05X4758",33,80);
		Data.newCar(2,"TN05X4259",39,67);
	}

}
