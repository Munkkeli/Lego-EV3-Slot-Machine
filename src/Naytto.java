import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class Naytto extends Thread {
	private Panos panos;
	
	public Naytto(Panos panos) {
		this.panos = panos;
	}
	
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			Draw();
			Delay.msDelay(500);
		}
	}
	
	public void Draw() {
		LCD.clear();
		LCD.drawString("You have " + panos.getRahaString() + "e", 1, 1);
		LCD.drawString("Your bet is " + panos.getPanosString() + "e", 1, 3);
	}
}
