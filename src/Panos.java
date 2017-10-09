/**
 * Lisää panoksen, sen nostamisen ja sen avulla rahan palauttamisen Laskurin toimintoihin.
 * 
 * @author Mikko Romo
 */

public class Panos extends Laskuri {
	private int panos = 1;

	/**
	 * Nostaa panosta 60snt asti.
	 */
	public void raiseBet() {
		if (panos >= 3) {
			panos = 1;
		} else if (getRaha() > panos ) {
			panos++;
		}
	}

	/**
	 * Palauttaa tämänhetkisen panoksen.
	 * 
	 * @return int Tämänhetkinen panos.
	 */
	public int getBet() {
		return panos;
	}
	
	/**
	 * Vähentää rahamäärästä panoksen verran.
	 */
	public void vahennaRaha() {
		vahennaRaha(panos);
	}

	/**
	 * Palauttaa panoksen suuruuden luettavassa muodossa (0.20).
	 * 
	 * @return String Panoksen suuruus.
	 */
	public String getPanosString() {
		return (((double) panos * 20) / (double) 100) + "0";
	}
}
