package playground;

public class Route {

	private String routeName;
	private String fullAddress;
	private int distanceInKm;
	private int totalDistanceInKm;
	private static int routeCount;

	Route(String routeName, String fullAddress, int distance) {

		this.routeName = routeName;
		this.fullAddress = fullAddress;
		this.distanceInKm = distance;
		this.totalDistanceInKm = 2 * distance;
		routeCount++;

	}

	// --------------------------------GETTERS
	public String getRouteName() {
		return routeName;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public int getDistanceInKm() {
		return distanceInKm;
	}

	public int getTotalDistanceInKm() {
		return totalDistanceInKm;
	}

	public static int getRouteCount() {
		return routeCount;
	}
	
	//-------------------------------------SETTERS
	public boolean setRouteName(String routeName) {

		if (routeName == null || routeName.equals(" "))
			return false;

		this.routeName = routeName;
		return true;
	}
}
