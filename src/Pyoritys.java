import lejos.hardware.Button;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Pyoritys {
	private RegulatedMotor rightWheel;
	private RegulatedMotor middleWheel;
	private RegulatedMotor leftWheel;
	
	private int rightPosition = 0;
	private int middlePosition = 0;
	private int leftPosition = 0;
	
	public void run() {
		rightWheel = new EV3LargeRegulatedMotor(MotorPort.A);
		middleWheel = new EV3LargeRegulatedMotor(MotorPort.B);
		leftWheel = new EV3LargeRegulatedMotor(MotorPort.C);

		rightWheel.setSpeed(500);
		middleWheel.setSpeed(500);
		leftWheel.setSpeed(500);

		Pyora right = new Pyora(rightWheel);
		Pyora middle = new Pyora(leftWheel);
		Pyora left = new Pyora(middleWheel);

		right.start();
		middle.start();
		left.start();

		while (!Thread.currentThread().isInterrupted()) {
			int rightSpin = (int) (Math.random() * 4);
			int middleSpin = (int) (Math.random() * 4);
			int leftSpin = (int) (Math.random() * 4);

			if (Math.random() < 0.8) {
				int offset = (int) (Math.random() * 4);

				rightSpin = ((3 - rightPosition) + offset) % 4;
				middleSpin = ((3 - middlePosition) + offset) % 4;
				leftSpin = ((3 - leftPosition) + offset) % 4;
			}

			rightPosition = (rightPosition + rightSpin) % 4;
			middlePosition = (middlePosition + middleSpin) % 4;
			leftPosition = (leftPosition + leftSpin) % 4;

			int rightOffset = (int) (Math.random() * 3) * 360;
			int middleOffset = rightOffset + (int) (Math.random() * 3) * 360;
			int leftOffset = middleOffset + (int) (Math.random() * 3) * 360;

			int spinRight = (rightPosition * 90) + rightOffset;
			int spinMiddle = (middlePosition * 90) + middleOffset;
			int spinLeft = (leftPosition * 90) + leftOffset;

			right.Rotate(spinRight);
			middle.Rotate(spinMiddle);
			left.Rotate(spinLeft);

			Delay.msDelay(((spinRight / 360) + (spinMiddle / 360) + (spinLeft / 360)) * 550);

			if (rightPosition == middlePosition && middlePosition == leftPosition) {
				Aanet.PlayWin();
				Button.LEDPattern(4);
			}

			Delay.msDelay(1000);

			Button.LEDPattern(0);
		}

		right.interrupt();
		middle.interrupt();
		left.interrupt();
	}
}

