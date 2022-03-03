
public abstract class DataBaseFunctions
{
	private static DB db = new DB();

	/*
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
	*/
	
	//insertion of Trips
	static void insertTrip(String tCustomer, String tRoute,String tCar,int tTravellers)
	{
		db.insertTrip(tCustomer,tRoute, tCar,tTravellers);
	}
	
	//INSERT INTO taxiland.customers VALUES
	//("a","a",50000 );
	static void insertCustomer(String cName, String cPass,String cCash)
	{
		//db.insertTrip(tCustomer,tRoute, tCar,tTravellers);
	}	
	
	// check if the customers exists
	static boolean isUserExists(String cname) {
		
		if (db.customerExisitsInDB(cname))
			return true;

		return false;
	}
	
	static boolean RouteExists(String routeName) {
		if (db.routeExisitsInDB(routeName))
			return true;

		return false;

	}

	//insertion of new Route
	
	static boolean insertRouteDB(String rName, String rAddress, int rDistance)
	{
		if(db.insertNewRoute(rName, rAddress,rDistance))
			return true;
		return false;
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
