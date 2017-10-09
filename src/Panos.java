import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;
/**
 * Muuttaa panoksen suuruutta
 * @author Mikko 
 *
 */
public class Panos extends Laskuri {
	private int panos = 1;

	/**
	 * nostaa panosta 60snt asti
	 */
	public void raiseBet() {
		if (panos >= 3) {
			panos = 1;
		} else if (getRaha() > panos ) {
			panos++;
		}
	}
	/**
	 * 
	 * @return palauttaa panoksen suuruuden
	 */
	public int getBet() {
		return panos;
	}
	
	/**
	 * vähentää rahamäärästä panoksen verran
	 */
	public void vahennaRaha() {
		vahennaRaha(panos);
	}

	/**
	 * 
	 * @return palauttaa panoksen suuruuden tulostettavassa muodossa
	 */
	public String getPanosString() {
		return (((double) panos * 20) / (double) 100) + "0";
	}
}
