import lejos.hardware.Sound;

public class Gambler {

	public static void main(String[] args) {
		Panos laskuri = new Panos();
		laskuri.start();
		
		Pyoritys pyoritys = new Pyoritys();
		
		Naytto naytto = new Naytto(laskuri);
		naytto.start();
		
		while (true) {
			if (!Vipu.WaitForButton()) break;
			
			if (!laskuri.hasRaha(1)) {
				Sound.beep();
			} else {
				pyoritys.Spin();
			}
		}
		
		naytto.interrupt();
		pyoritys.interrupt();
		laskuri.interrupt();
		
		return;
	}
}
