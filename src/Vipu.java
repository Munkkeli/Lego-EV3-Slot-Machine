
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.RegulatedMotor;

public class Vipu {
	public static boolean WaitForButton() {
		EV3TouchSensor ts = new EV3TouchSensor(SensorPort.S1);
		float[] sample = new float[ts.sampleSize()];
		boolean down = false;
		while (!Button.ESCAPE.isDown()) {
			ts.fetchSample(sample, 0);
			if (!down && sample[0] == 1) down = true;
			if (down && sample[0] == 0) break;
		}	
			ts.close();
		
		return !Button.ESCAPE.isDown();
	} 
}