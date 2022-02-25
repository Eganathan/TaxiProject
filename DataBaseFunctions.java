
public abstract class DataBaseFunctions
{
	private static DB db = new DB();

	//Verifying if the DB exists
	private boolean dbExists() {

		if (true)
			return true;

		return false;
	}

	//Verifying if the DB exists
	private boolean tableExists() {

		if (true)
			return true;

		return false;
	}
	
	
	static void insertTrip(String tCustomer, String tRoute,String tCar,int tTravellers)
	{
		db.insertTrip(tCustomer,tRoute, tCar,tTravellers);
	}
	static boolean loadAllData()
	{
		
		db.getCustomersDetails();
		db.loadRoutesFromDB();
		db.loadCarFromDB();
		db.loadTripsFromDB();
		return false;
		
	}


}
