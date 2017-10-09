import lejos.hardware.Button;
import lejos.utility.Delay;

/**
 * Panosnappulan toiminta
 * @author Mikko
 *
 */
public class Panoskey extends Thread{
	private Panos panos;

	public Panoskey(Panos panos) {
		this.panos = panos;
	}
	/**
	 * panos nousee ylös-nappulaa painamalla
	 */
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			while(Button.UP.isDown()) {
			Delay.msDelay(250);
			panos.raiseBet();
			}

		}
	}
}
