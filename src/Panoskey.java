/**
 * Panoksen nostaminen ja laskeminen nappuloiden avulla.
 * 
 * @author Mikko Romo
 */
import lejos.hardware.Button;
import lejos.utility.Delay;

public class Panoskey extends Thread {
	private Panos panos;
	
	/**
	* Luo uuden olion.
	* 
	* @param panos Panos olio jonka panosta nostetaan.
	*/
	public Panoskey(Panos panos) {
		this.panos = panos;
	}

	/**
	 * Aloittaa nappuloiden painamisen kuuntelun.
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
