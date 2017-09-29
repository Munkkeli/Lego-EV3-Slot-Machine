import lejos.hardware.Sound;

public class Gambler {

	public static void main(String[] args) {
		Laskuri laskuri = new Laskuri();
		laskuri.start();
		
		Pyoritys pyoritys = new Pyoritys();
		
		while (true) {
			if (!Vipu.WaitForButton()) return;
			
			if (!laskuri.hasRaha(1)) {
				Sound.beep();
			} else {
				pyoritys.Spin();
			}
		}
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
