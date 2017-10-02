/**
 * Monitoroi vipua ja k‰ynnist‰‰ ohjelman vipua vet‰m‰ll‰
 * 
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
	/**
	 * Odottaa vivun vet‰mist‰
	 * 
	 * @return boolean Palauttaa false jos esc painetaan
	 */
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
	/**
	 * Pys‰ytt‰‰ ohjelman
	 * 
	 */
	public void interrupt() {
		touch.close();
	}
}