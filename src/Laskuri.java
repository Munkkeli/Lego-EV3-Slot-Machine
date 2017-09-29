import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.utility.Delay;

public class Laskuri extends Thread {
	private int raha = 0;

	public void run() {
		EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S2);
		
		while(!Thread.currentThread().isInterrupted()) {
			boolean coin = false;

			switch (cs.getColorID()) {
	          case -1:
	            break;
	          default:
	        	  	coin = true;
	            break;
	        }

			if (coin) {
				raha++;
				Delay.msDelay(500);
			}
		}
		
		cs.close();
	}
	
	public int getRaha() {
		return this.raha;
	}
	
	public boolean hasRaha(int panos) {
		return raha >= panos;
	}

	public void vahennaRaha(int panos) {
		raha = Math.max(raha - panos, 0);
	}
}
