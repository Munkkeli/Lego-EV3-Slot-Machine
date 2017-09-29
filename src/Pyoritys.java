import java.util.*;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Pyoritys {
	public static void main(String[] Args) {
		ArrayList<String> kuvio = new ArrayList<String>();

		RegulatedMotor right = new EV3LargeRegulatedMotor(MotorPort.A);
		RegulatedMotor mid = new EV3LargeRegulatedMotor(MotorPort.B);
		RegulatedMotor left = new EV3LargeRegulatedMotor(MotorPort.C);

		RegulatedMotor coin = new EV3LargeRegulatedMotor(MotorPort.D);

		kuvio.add("1");
		kuvio.add("2");
		kuvio.add("3");
		kuvio.add("4");

		left.setSpeed(500);
		mid.setSpeed(500);
		right.setSpeed(500);

		coin.setSpeed(100);

		Pyorat r = new Pyorat(right);
		Pyorat l = new Pyorat(left);
		Pyorat m = new Pyorat(mid);

		r.start();
		l.start();
		m.start();

		int one = 0;
		int two = 0;
		int three = 0;

		while (!Button.ESCAPE.isDown()) {
			int eka = (int) (Math.random() * 4);
			int toka = (int) (Math.random() * 4);
			int kolmas = (int) (Math.random() * 4);

			if (Math.random() < 0.8) {
				int offset = (int) (Math.random() * 4);
				eka = ((3 - one) + offset) % 4;
				toka = ((3 - two) + offset) % 4;
				kolmas = ((3 - three) + offset) % 4;
			}

			one = (one + eka) % 4;
			two = (two + toka) % 4;
			three = (three + kolmas) % 4;

			int re = (int) (Math.random() * 3) * 360;
			int rt = (int) (Math.random() * 3) * 360;
			int rk = (int) (Math.random() * 3) * 360;

			int eka2 = (eka * 90) + re;
			int toka2 = (toka * 90) + re + rt;
			int kolmas2 = (kolmas * 90) + re + rt + rk;

			r.rotate(eka2);
			// Delay.msDelay(400);
			m.rotate(toka2);
			// Delay.msDelay(400);
			l.rotate(kolmas2);

			Delay.msDelay(((eka2 / 360) + (toka2 / 360) + (kolmas2 / 360)) * 550);

			if (one == two && two == three) {
				Sound.beep();
				Button.LEDPattern(4);
				coin.rotate(360);
			}

			Delay.msDelay(500);

			Button.LEDPattern(0);
		}

		r.interrupt();
		l.interrupt();
		m.interrupt();
	}
}

