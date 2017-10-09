/**
 * Pitää lukua käyttäjän rahan määrästä, lisää siihen, vähentää siitä ja palauttaa voitot.
 * 
 * @author Mikko Romo
 */

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
	
	/**
	 * Aloittaa rahan syöttämisen kuuntelun.
	 */
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
	
	/**
	 * Palauttaa tämän hetkisen rahan määrän.
	 * 
	 * @return int Rahan määrä.
	 */
	public int getRaha() {
		return this.raha;
	}
	
	/**
	 * Tarkistaa onko pelaajalla tietty määrä rahaa.
	 * 
	 * @param panos Kuinka paljon rahaa pitäisi olla.
	 * @return boolean Onko pelaajalla annettu määrä rahaa.
	 */
	public boolean hasRaha(int panos) {
		return raha >= panos;
	}
	
	/**
	 * Vähentää käyttäjältä rahaa, ei anna rahamäärän muuttua negatiiviseksi.
	 * 
	 * @param panos Kuinka paljon rahaa vähennetään.
	 * @return int Uusi määrä rahaa.
	 */
	public void vahennaRaha(int panos) {
		raha = Math.max(raha - panos, 0);
	}
	
	/**
	 * Palauttaa pelaajan rahan määrän luettavassa muodossa (0.20e).
	 * 
	 * @return String Pelaajan rahamäärä luettavassa muodossa.
	 */
	public String getRahaString() {
		return (((double)raha * 20) / (double)100) + "0";
	}
	
	/**
	 * Palauttaa rahaa pelaajalle koneesta.
	 * 
	 * @param amount Kuinka paljon rahaa palautetaan pelaajalle.
	 */
	public void giveRaha(int amount) {
		motor.rotate(360 * amount);
	}
}
