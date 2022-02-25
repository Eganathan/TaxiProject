

public class Main {
	static CompanysGUI cGUI;
	public static void main(String[] args) {

		//DataBaseFunctions.insertTrip("haha", "k","t",5);
		DataBaseFunctions.loadAllData();
		//new LoadData();
		Data.updateFin();
		
		new CustomerGUILogin().setVisible(true);;
		cGUI = new CompanysGUI();
		cGUI.setVisible(true);

	}

}
