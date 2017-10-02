/**
* Arpoo voitot, asettaa voittoprosentin ja pyörittää rullia oikeisiin asentoihin
*
* @author  Tuomas Pöyry
*/

import lejos.hardware.Button;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Pyoritys {
	private Panos panos;
	
	private RegulatedMotor rightWheel;
	private RegulatedMotor middleWheel;
	private RegulatedMotor leftWheel;
	
	private Pyora right;
	private Pyora middle;
	private Pyora left;
	
	private int rightPosition = 0;
	private int middlePosition = 0;
	private int leftPosition = 0;
	
	public Pyoritys(Panos panos) {
		this.panos = panos;
		
		rightWheel = new EV3LargeRegulatedMotor(MotorPort.A);
		middleWheel = new EV3LargeRegulatedMotor(MotorPort.B);
		leftWheel = new EV3LargeRegulatedMotor(MotorPort.C);

		rightWheel.setSpeed(500);
		middleWheel.setSpeed(500);
		leftWheel.setSpeed(500);

		right = new Pyora(rightWheel);
		middle = new Pyora(leftWheel);
		left = new Pyora(middleWheel);

		right.start();
		middle.start();
		left.start();
	}
	
	/**
	* Käynnistää yhden pelikierroksen ja palauttaa mahdolliset voitot
	*/
	public void Spin() {
		int rightSpin = (int) (Math.random() * 4);
		int middleSpin = (int) (Math.random() * 4);
		int leftSpin = (int) (Math.random() * 4);

		if (Math.random() < 0.5) {
			int offset = (int) (Math.random() * 4);

			rightSpin = ((3 - rightPosition) + offset) % 4;
			middleSpin = ((3 - middlePosition) + offset) % 4;
			leftSpin = ((3 - leftPosition) + offset) % 4;
		}

		rightPosition = (rightPosition + rightSpin) % 4;
		middlePosition = (middlePosition + middleSpin) % 4;
		leftPosition = (leftPosition + leftSpin) % 4;

		int rightOffset = (int) ((Math.random() + 1) * 3) * 360;
		int middleOffset = (Math.random() > 0.5 ? rightOffset : 0) + (int) ((Math.random() + 1) * 3) * 360;
		int leftOffset = (Math.random() > 0.5 ? middleOffset : 0) + (int) ((Math.random() + 1) * 3) * 360;

		int spinRight = (rightSpin * 90) + rightOffset;
		int spinMiddle = (middleSpin * 90) + middleOffset;
		int spinLeft = (leftSpin * 90) + leftOffset;

		right.Rotate(spinRight);
		middle.Rotate(spinMiddle);
		left.Rotate(spinLeft);

		Delay.msDelay(((spinRight / 360) + (spinMiddle / 360) + (spinLeft / 360)) * 500);

		if (rightPosition == middlePosition && middlePosition == leftPosition) {
			Aanet.PlayBigWin();
			Button.LEDPattern(4);
			panos.giveRaha(2);
		} else {
			Aanet.PlayLoose();
		}

		Delay.msDelay(1000);

		Button.LEDPattern(0);
	}
	
	/**
	* Keskeyttää ohjelman
	*/
	public void interrupt() {
		right.interrupt();
		middle.interrupt();
		left.interrupt();
	}
}

