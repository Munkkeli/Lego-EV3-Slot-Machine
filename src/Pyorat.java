
import lejos.hardware.Button;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class Pyorat extends Thread {
	private RegulatedMotor motor;
	private int angle = 0;
	//RegulatedMotor right = new EV3LargeRegulatedMotor(MotorPort.A);
	//RegulatedMotor mid = new EV3LargeRegulatedMotor(MotorPort.B);
	//RegulatedMotor left = new EV3LargeRegulatedMotor(MotorPort.C);


	public Pyorat(RegulatedMotor motor) {
		this.motor = motor;
	}

	public void rotate(int angle) {
		this.angle = angle;
	}

	public void run() {
		while (!Button.ENTER.isDown()) {
			if (angle != 0) {
				motor.rotate(angle);
				angle = 0;
			}
		}
	}
}

