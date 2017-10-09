/**
 * Monitoroi vipua ja käynnistää ohjelman vipua vetämällä
 * 
 * @author Janne Suotsalo
 */
import lejos.hardware.Button;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;

public class Vipu {
	EV3TouchSensor touch;
	
	/**
	* Luo uuden olion ja käynnistää värisensorin.
	*/
	public Vipu() {
		touch = new EV3TouchSensor(SensorPort.S1);
	}

	/**
	 * Odottaa vivun vetämistä.
	 * 
	 * @return boolean Palauttaa false jos esc painetaan, ja true jos vipua vedetään.
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
	 * Pysäyttää ohjelman.
	 */
	public void interrupt() {
		touch.close();
	}
}