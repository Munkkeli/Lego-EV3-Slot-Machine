import lejos.hardware.Button;
import lejos.utility.Delay;

public class Panoskey extends Thread{
	private Panos panos;
	
	public Panoskey(Panos panos) {
		this.panos = panos;
	}

	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			while(Button.UP.isDown()) {
			Delay.msDelay(250);
			panos.raiseBet();
			}

		}
	}
}
