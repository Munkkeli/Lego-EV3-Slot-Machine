/**
 * Pyörittää yksittäistä pyörää omassa säikeessä tietyn määrän asteita
 * 
 * @author Janne Suotsalo
 */
import lejos.robotics.RegulatedMotor;

public class Pyora extends Thread {
	private RegulatedMotor motor;
	private int angle = 0;

	public Pyora(RegulatedMotor motor) {
		this.motor = motor;
	}

	public void Rotate(int angle) {
		this.angle = angle;
	}

	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			if (angle != 0) {
				motor.rotate(angle);
				angle = 0;
			}
		}
	}
}