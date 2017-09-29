import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;

public class Kaukosaato extends Thread {
	private EV3IRSensor infraredSensor;

	private boolean isLocked = false;
	
	public Kaukosaato() {
		infraredSensor = new EV3IRSensor(SensorPort.S3);
	}
	
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			int remoteCommand = infraredSensor.getRemoteCommand(0);
			if (remoteCommand != 0) {
				if (remoteCommand == 1 || remoteCommand == 2) isLocked = true;
				if (remoteCommand == 3 || remoteCommand == 4) isLocked = false;
			}
		}
	}
	
	public boolean getLocked() {
		return isLocked;
	}
}
