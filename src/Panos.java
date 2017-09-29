
public class Panos extends Laskuri {
	private double panos = 1;

	public void raiseBet() {
		
		if (panos >= 3) {
			panos = 1;
		} else if (getRaha() > panos + 1) {
			panos++;
		}
	}

	public double getBet() {
		return panos;
	}
	
	public String getPanosString() {
		return (((double)panos * 20) / (double)100) + "0";
	}
}
