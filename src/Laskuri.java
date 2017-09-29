import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
import lejos.utility.Delay;

public class Laskuri {

	private int raha = 0;
	
	public Laskuri() {
		
		this.raha = raha;
		
	}

	public void laskuri() {
		
	EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S3);
		
	while(!Button.ESCAPE.isDown())
	{

		switch (cs.getColorID()) {

		case Color.BLACK:
			LCD.drawString("Saldo: " + raha * 0.20, 5, 6);
			break;

		default:
			raha += 1;
			LCD.drawString("Saldo: " + raha * 0.20, 5, 6);
			Delay.msDelay(1000);
			break;
		}
		LCD.refresh();
		Delay.msDelay(200);
	}
	cs.close();
	}
	
	

	public int getRaha() {
		return this.raha;
	}

	public void vahennaRaha(int i) {
		this.raha -= i;
	}

}
