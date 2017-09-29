

	import lejos.hardware.lcd.LCD;

	public class Panos extends Laskuri{
		
		private double panos = 0.20;

		public void raiseBet() {
			
			if (getRaha() > 0 && panos >= 0.60) {
				this.panos = 0.20;
			} else if (getRaha() > 0){
				this.panos += 0.20;
			}
			LCD.drawString("Panos: " + panos, 0, 7);
		}
		

		public double getBet() {
			return panos;
		}
}

