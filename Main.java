

public class Main {
	public static void main(String[] args) {

		//DataBaseFunctions.insertTrip("haha", "k","t",5);
		DataBaseFunctions.loadAllData();
		//new LoadData();
		Data.updateFin();
		
		new CustomerGUILogin().setVisible(true);;
		//new CompanysGUI().setVisible(true);
		new Main().finalize();
	}
	
	protected void finalize()
	{
		
		
		System.out.println("inside finalize");
	}

}
