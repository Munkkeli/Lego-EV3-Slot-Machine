

public class Gambler {

	public static void main(String[] args) {
		Laskuri laskuri = new Laskuri();
		
		laskuri.start();
		
		
	}
	
	public static String Money(int credits) {
		double money = ((double)credits * 20) / (double)100;
		return money + "0";
	}
	
	/*
	public static void DrawInfo() {
		LCD.clear();
		LCD.drawString("You have " + Money(credit) + "e", 1, 1);
		LCD.drawString("Holding " + balance + " coins", 1, 6);
	}
	*/
}
