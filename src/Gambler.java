import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.utility.Delay;

public class Gambler {
	public static int credit = 0;
	public static int balance = 0;
	
	public static EV3ColorSensor cs;
	
	public static void main(String[] args) {
		cs = new EV3ColorSensor(SensorPort.S2);
		
		while (true) {
			
			if (Button.ESCAPE.isDown()) return;
			
			/*Vipu.WaitForButton();
			
			m.setSpeed(200);
			m.rotate(360);*/
			
			DrawInfo();
			
			WaitForCoin();
			
			credit++;
			balance++;
			
			Delay.msDelay(1000);
			
			// Hello world! Nice!
			
			// Moi!
			
			/*boolean coin = false;
			switch (cs.getColorID()) {
              case 7:
            	  	coin = false;
                break;
              default:
            	  	coin = true;
                break;
            }
			
			if (!coin) continue;
			
			LCD.drawString("Sain!", 1, 1);
			Delay.msDelay(1000);
			LCD.clear();
			*/
		}
	}
	
	public static String Money(int credits) {
		double money = ((double)credits * 20) / (double)100;
		return money + "0";
	}
	
	public static void DrawInfo() {
		LCD.clear();
		LCD.drawString("You have " + Money(credit) + "e", 1, 1);
		LCD.drawString("Holding " + balance + " coins", 1, 6);
	}
	
	public static void WaitForCoin() {
		boolean coin = false;
		while(!coin && !Button.ESCAPE.isDown()) {
			switch (cs.getColorID()) {
	          // case -1:
	          case -1:
	        	  	// coin = true;
	            break;
	          default:
	        	  	coin = true;
	            break;
	        }
		}
		return;
	}
}
