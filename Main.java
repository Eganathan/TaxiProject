

public class Main {
	static CompanysGUI cGUI;
	public static void main(String[] args) {

		
		new LoadData();
		Data.updateFin();
		
		new Fram().setVisible(true);;
		cGUI = new CompanysGUI();
		cGUI.setVisible(true);

	}

}
