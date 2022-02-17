package playground;

import java.util.Date;

public abstract class Finanance{

	private static final float coastPerKm = 11.0f;
	private static final float tax = 2.3f;
	private static final float cess = 1.1f;
	private static final int minDistance = 10;
	private static float BANKBALANCE = 0.0f;
	private static float TAX = 0.0f;
	private static float CESS = 0.0f;
	private static String tName = "ZGS-Taxi Service ";
	private static Date startTime;

	public static void addToBank(float amount) {
		BANKBALANCE += amount;
	}

	static float[] getTripCoast(int distance) {

		// Maintains the minimum Distance
		distance = distance > minDistance ? distance : minDistance;

		float coast = coastPerKm * distance;
		float cessAmount = (coast / 100) * cess;
		float taxAmount = (coast / 100) * tax;
		float total = coast + (coast / 100) * tax + (coast / 100) * cess;

		float[] values = { total, cessAmount, taxAmount };

		return values;
	}

	static void printBill(int i) {
		startTime = new Date();
		float[] bill = getTripCoast(Data.getTripByID(i).getRoute().getDistanceInKm());
		System.out.println("_________________________________________________________");
		System.out.println("| Bill-ID TXBY" + i + "                                      |");
		System.out.println("| Company name: " + tName + "                                |");
		System.out.println("|                                                        |");
		System.out.println("|                                                        |");
		System.out.println("|                                                        |");
		System.out.println("|                                                        |");
		System.out.println("|                                                        |");
		System.out.println("|                                    CESS :" + bill[1] + " |");
		System.out.println("|                                    TAX :" + bill[2] + " |");
		System.out.println("|                                    TOTAL :" + bill[0] + " |");
		System.out.println("|       " + startTime.toString() + "                    |");
		System.out.println("_________________________________________________________");

		TAX += bill[2];
		CESS += bill[1];

	}

	// ========================Getters

	public static float getBANKBALANCE() {
		return BANKBALANCE;
	}

	public static float getTAX() {
		return TAX;
	}

	public static float getCESS() {
		return CESS;
	}

	public static void setBANKBALANCE(float bANKBALANCE) {
		BANKBALANCE = bANKBALANCE;
	}

	public static void setTAX(float tAX) {
		TAX = tAX;
	}

	public static void setCESS(float cESS) {
		CESS = cESS;
	}

	
	
}
