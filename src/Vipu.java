/**
 * @author Janne Suotsalo
 */
import lejos.hardware.Button;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;

public class Vipu {
	EV3TouchSensor touch;
	
	public Vipu() {
		touch = new EV3TouchSensor(SensorPort.S1);
	}
	
	public boolean WaitForButton() {
		float[] sample = new float[touch.sampleSize()];
		boolean down = false;
		while (!Button.ESCAPE.isDown()) {
			touch.fetchSample(sample, 0);
			if (!down && sample[0] == 1) down = true;
			if (down && sample[0] == 0) return true;
		}	
		return false;
	} 
	
	public void interrupt() {
		touch.close();
	}
}