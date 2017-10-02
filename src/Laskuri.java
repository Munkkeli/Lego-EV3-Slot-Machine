import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Laskuri extends Thread {
	private int raha = 1;
	
	private RegulatedMotor motor;

	public void run() {
		EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S2);
		
		motor = new EV3LargeRegulatedMotor(MotorPort.D);
		motor.setSpeed(200);
		
		while(!Thread.currentThread().isInterrupted()) {
			boolean coin = false;

			switch (cs.getColorID()) {
	          case -1:
	          case Color.WHITE:
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
	
	public String getRahaString() {
		return (((double)raha * 20) / (double)100) + "0";
	}
	
	public void giveRaha(int amount) {
		motor.rotate(360 * amount);
	}
}
