import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Notice, do not import com.mysql.cj.jdbc.*
// or you will have problems!

public class DB{

	private String url = "jdbc:mysql://localhost:3306/taxiland";
	private Connection conn = null;

	DB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "1234");

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		getCustomersCount();
	}

	// start function
	void startConn(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "1234");
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	// start function
	void endConn() throws SQLException {
		if(!conn.isClosed())
			conn.close();
	}

	// Gets the current counter value
	int getCustomersCount() {

		dealConn();
		int count = 0;
		String sql = "SELECT COUNT(cName) as count FROM taxiland.customers";

		try {
			Statement statement = conn.prepareStatement(sql);
			ResultSet outputSet = statement.executeQuery(sql);
			if (outputSet.next())
				count = Integer.parseInt(outputSet.getString("count"));
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	// Gets the customer details
	boolean setCustomersDetails() {
		dealConn();
		String sql = "SELECT * FROM taxiland.customers";

		try {
			Statement statement = conn.prepareStatement(sql);
			ResultSet outputSet = statement.executeQuery(sql);
			while (outputSet.next()) {

				String name = outputSet.getString("cName");
				String password = outputSet.getString("cPass");
				int cash = Integer.parseInt(outputSet.getString("cCash"));

				// creating a new object of the customer from the informations from DB
				Data.newCustomer(name, cash, password);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

//================================================================================================ START LOADING DATA

	// ===============================================================Gets the
	// customer details
	/*
	 * This block of code deals with the retreval of customers data from DB using
	 * Data.newCustomer function we pass the values to create the objects by the
	 * methods..
	 */
	boolean getCustomersDetails() {
		List<Customer> customers = new ArrayList<Customer>();
		// newCustomer(String name, int cash, String pass)
		dealConn();
		int count = 0;
		String sql = "SELECT * FROM taxiland.customers";

		try {

			Statement statement = conn.prepareStatement(sql);
			ResultSet outputSet = statement.executeQuery(sql);

			while (outputSet.next()) {

				String name = outputSet.getString("cName");
				String password = outputSet.getString("cPass");
				int cash = Integer.parseInt(outputSet.getString("cCash"));

				// Passing the arguments for the method fo object creation.
				Data.newCustomerDB(name, cash, password);
				count++;
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// System.out.println(count + " Counter");
		return true;
	}
	// ======================================================================END OF
	// CUSTOMERS DATA

	// ===============================================================Gets the ROUTE
	// details
	/*
	 * This block of code deals with the retrieval of customers data from DB using
	 * Data.newCustomer function we pass the values to create the objects by the
	 * methods..
	 */
	boolean loadRoutesFromDB() {

		// newRoute(String routeName, String fullAddress, int distance)
		dealConn();
		String sql = "SELECT * FROM taxiland.routes";

		try {

			Statement statement = conn.prepareStatement(sql);
			ResultSet outputSet = statement.executeQuery(sql);

			while (outputSet.next()) {

				String name = outputSet.getString("rName");
				String address = outputSet.getString("rAddress");
				int distance = Integer.parseInt(outputSet.getString("rDistance"));

				// Passing the arguments for the method fo object creation.
				Data.newRoute(name, address, distance);
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	// ======================================================================END OF
	// ROUTE DATA

	// ===============================================================Gets the CAR
	// details
	/*
	 * This block of code deals with the retreval of customers data from DB using
	 * Data.newCustomer function we pass the values to create the objects by the
	 * methods..
	 */
	boolean loadCarFromDB() {

		// newRoute(String routeName, String fullAddress, int distance)
		dealConn();
		String sql = "SELECT * FROM taxiland.cars";

		try {

			Statement statement = conn.prepareStatement(sql);
			ResultSet outputSet = statement.executeQuery(sql);

			while (outputSet.next()) {

				String name = outputSet.getString("carName");
				int milage = Integer.parseInt(outputSet.getString("carMilage"));
				int capacity = Integer.parseInt(outputSet.getString("cCapacity"));
				int avgSpeed = Integer.parseInt(outputSet.getString("cAvgSpeed"));

				// Passing the arguments for the method fo object creation.
				Data.newCar(capacity, name, milage, avgSpeed);
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	// ======================================================================END OF
	// CAR DATA

	// ====================================================================== TRIP
	// details
	/*
	 * This block of code deals with the retreval of customers data from DB using
	 * Data.newCustomer function we pass the values to create the objects by the
	 * methods..
	 */
	boolean loadTripsFromDB() {

		// newRoute(String routeName, String fullAddress, int distance)
		dealConn();
		String sql = "SELECT * FROM taxiland.trips";

		try {

			Statement statement = conn.prepareStatement(sql);
			ResultSet outputSet = statement.executeQuery(sql);

			while (outputSet.next()) {
				// newTrip(int id, String Route, String customer, String car, int
				// countTravellers)

				int tID = Integer.parseInt(outputSet.getString("tID"));
				String route = outputSet.getString("tRoute");
				String customer = outputSet.getString("tCustomer");
				String car = outputSet.getString("tCar");
				int travellers = Integer.parseInt(outputSet.getString("tTravellers"));

				// Passing the arguments for the method fo object creation.
				Data.newTrip(tID, route, customer, car, travellers);
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	// ======================================================================END OF
	// TRIP DATA

//==================================================================================END OF LOADING DATA ==============	

//==================================================================================INSERTIONS

	// =======================================================================INSERT
	// TRIP DETAILS
	void insertTrip(String tCustomer, String tRoute, String tCar, int tTravellers) {
		dealConn();

		String sql = "INSERT INTO taxiland.trips (tCustomer, tRoute,tCar, tTravellers)values " + " ( '" + tCustomer
				+ "' , '" + tRoute + "' , '" + tCar + "' ," + String.valueOf(tTravellers) + " )";

		Statement statement;
		try {
			statement = conn.prepareStatement(sql);
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	// ======================================================================END OF
	// INSERTION OF TRIPS

	// =======================================================================START
	// OF INSETION
	// CUSTOMER DETAILS

	// checks if the customers exists
	boolean customerExisitsInDB(String cName) {
		dealConn();

		boolean isThere = false;
		String sql = "SELECT COUNT(*) as count FROM taxiland.customers WHERE cName =  '" + cName + "'";

		Statement statement;
		try {

			statement = conn.prepareStatement(sql);
			ResultSet outputSet = statement.executeQuery(sql);
			while (outputSet.next()) {
				 if(outputSet.getInt("count") > 0)
					 isThere = true;
				 
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isThere;
	}

	// =============================================================================INSERTION
	// OF NEW CUSTOMER
	void insertNewCustomer(String cName, String cPass, int loadCash) {
		dealConn();

		String sql = "INSERT INTO taxiland.customers VALUES " + " ( '" + cName + "' , '" + cPass + "' , " + loadCash
				+ " )";

		Statement statement;
		try {
			statement = conn.prepareStatement(sql);
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
// ======================================================================END OF CUSTOMER DETAILS

//=============================================================================INSERTION OF NEW ROUTE
	void insertNewRoute(String rName, int rDistance, String rAddress) {
		dealConn();

		String sql = "INSERT INTO taxiland.routes VALUES " + " ( '" + rName + "' , " + rDistance + " , '" + rAddress
				+ "' , " + " )";

		Statement statement;
		try {
			statement = conn.prepareStatement(sql);
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
// ======================================================================END OF ROUTE 

//================================================================INSERTION OF NEW CAR
	void insertNewCar(String cName, String cPass, int loadCash) {
		dealConn();

		String sql = "INSERT INTO taxiland.customers VALUES " + " ( '" + cName + "' , '" + cPass + "' , " + loadCash
				+ " )";

		Statement statement;
		try {
			statement = conn.prepareStatement(sql);
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
// ======================================================================END OF ROUTE 

//===================================================================END OF INSERTIONS	
	// Deals the SQL query
	void dealQuery(String sql) {
		dealConn();
		try {
			Statement statement = conn.prepareStatement(sql);
			statement.execute(sql);
			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	// Checks if the connection is still available if not then opens a new conection
	void dealConn() {
		startConn();

	}

	/*
	 * 
	 * void loadDataFromDB() { dealConn(); String sql =
	 * "SELECT * FROM test_db.notes_test WHERE intrash = 0;";
	 * 
	 * Notes.titleHMap.clear(); Notes.textHMap.clear(); try { Statement statement =
	 * conn.prepareStatement(sql); ResultSet outputSet =
	 * statement.executeQuery(sql); while (outputSet.next()) {
	 * 
	 * int id = outputSet.getInt("note_id"); String title =
	 * outputSet.getString("note_title"); // String text =
	 * outputSet.getString("note_text");
	 * 
	 * Notes.titleHMap.put(id, title); Notes.textHMap.put(id, text); }
	 * statement.close(); } catch (SQLException e) { e.printStackTrace(); }
	 * loadDELDataFromDB(); Notes.updateListModal();
	 * 
	 * }
	 * 
	 * void loadDELDataFromDB() { dealConn(); String sql =
	 * "SELECT * FROM test_db.notes_test WHERE intrash >= 1;";
	 * 
	 * Notes.titleSHMapDEL.clear(); Notes.textSHMapDEL.clear(); try { Statement
	 * statement = conn.prepareStatement(sql); ResultSet outputSet =
	 * statement.executeQuery(sql); while (outputSet.next()) {
	 * 
	 * int id = outputSet.getInt("note_id"); String title =
	 * outputSet.getString("note_title"); // String text =
	 * outputSet.getString("note_text");
	 * 
	 * Notes.titleSHMapDEL.put(id, title); Notes.textSHMapDEL.put(id, text); }
	 * statement.close(); } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * boolean updateTextAndTitle(int id, String title, String text) { boolean
	 * insert = false; dealConn(); String sql =
	 * "UPDATE test_db.notes_test SET  note_text = '" + text + " ' WHERE note_id = "
	 * + id; String sql1 = "UPDATE test_db.notes_test SET  note_title = '" + title +
	 * " ' WHERE note_id = " + id;
	 * 
	 * try {
	 * 
	 * Statement statement = conn.prepareStatement(sql); int s1 =
	 * statement.executeUpdate(sql);// execute(sql); statement.close();
	 * 
	 * Statement statement1 = conn.prepareStatement(sql1); int s2 =
	 * statement1.executeUpdate(sql1); statement1.close();
	 * 
	 * System.out.println(s1 + " " + s2); Notes.titleHMap.replace(id, title);
	 * Notes.textHMap.replace(id, text); } catch (SQLException e) {
	 * e.printStackTrace(); }
	 * 
	 * Notes.updateListModal(); return insert; }
	 * 
	 * boolean deleteRowWithID(int id) { boolean insert = false; dealConn(); String
	 * sql = "UPDATE test_db.notes_test SET intrash = 1 where note_id =" + id; //
	 * DELETE FROM `table_name` [WHERE condition]; try {
	 * 
	 * Statement statement = conn.prepareStatement(sql);
	 * statement.executeUpdate(sql); statement.close(); Notes.titleHMap.remove(id);
	 * Notes.textHMap.remove(id); } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * Notes.updateListModal(); return insert; }
	 * 
	 * void updateRestore(int id, int action, String title, String text) {
	 * dealConn(); if (action == 1) {
	 * 
	 * String sql = "UPDATE test_db.notes_test SET  intrash = 0  WHERE note_id = " +
	 * id;
	 * 
	 * try {
	 * 
	 * Statement statement = conn.prepareStatement(sql);
	 * statement.executeUpdate(sql); Notes.titleHMap.put(id, title);
	 * Notes.textHMap.put(id, text); statement.close();
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * } else if (action >= 2) {
	 * 
	 * String sql = "DELETE FROM test_db.notes_test WHERE note_id = " + id;
	 * Notes.titleSHMapDEL.remove(id); Notes.textSHMapDEL.remove(id); try {
	 * 
	 * Statement statement = conn.prepareStatement(sql);
	 * statement.executeUpdate(sql); statement.close();
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * Notes.updateListModal(); }
	 */

}
