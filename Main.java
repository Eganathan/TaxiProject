

public class Main {
	static CustomerGUILogin cGUI;
	
	public static void main(String[] args) {

		//DataBaseFunctions.insertTrip("haha", "k","t",5);
		DataBaseFunctions.loadAllData();
		//new LoadData();
		Data.updateFin();
		
		
		
		
		
		cGUI = new CustomerGUILogin();
		cGUI.setVisible(true);
		
	}
	
	protected void finalize()
	{
		
		
		System.out.println("inside finalize");
	}

}
