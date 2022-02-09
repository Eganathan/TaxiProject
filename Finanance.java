package playground;

public abstract class Finanance{
	
	private static final int coastPerKm = 25;
	private static final float tax = 2.3f;
	private static final float cess = 1.1f;
	private static final int minDistance = 10;
	
	
	static float[] getTripCoast(int distance){
		
		
		//Maintains the minimum Distance
		distance = distance > minDistance ? distance:minDistance;	
		
		float coast = coastPerKm * distance;
		float cessAmount = (coast / 100) * cess;
		float taxAmount = (coast / 100) * tax;
		float total = coast + (coast / 100) * tax + (coast / 100) * cess;
		
		float[] values = {total, cessAmount ,taxAmount};
	
		return values;
	}
	
}
