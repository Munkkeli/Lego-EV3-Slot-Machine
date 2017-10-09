/**
 * Pyörittää yksittäistä pyörää omassa säikeessä tietyn määrän asteita
 * 
 * @author Janne Suotsalo
 */
import lejos.robotics.RegulatedMotor;

public class Pyora extends Thread {
	private RegulatedMotor motor;
	private int angle = 0;
	
	/**
	* Luo uuden olion.
	* 
	* @param motor Moottori jota tämä olio liikuttelee.
	*/
	public Pyora(RegulatedMotor motor) {
		this.motor = motor;
	}

	/**
	 * Pyörittää annetun asteen verran
	 * 
	 * @param angle Kuinka monta astetta pyörät pyörii
	 */
	public void Rotate(int angle) {
		this.angle = angle;
	}
	
	/**
	* Aloittaa moottorin liikuttelemisen.
	*/
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			if (angle != 0) {
				motor.rotate(angle);
				angle = 0;
			}
		}
	}
}