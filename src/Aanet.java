import lejos.hardware.Sound;
import lejos.utility.Delay;

public class Aanet { 
	  
	// paras mihin mä pystyn
	
	public static void PlayWin() {
		 Sound.beepSequence();
		 Sound.beepSequence();
		 
	 }
	 
	 public static void PlayWinwin() {
		 Sound.beepSequenceUp();
		 Sound.beepSequenceUp();
		 
	 }
	 
	  public static void PlayBigWin() {
		  Sound.beepSequenceUp();
		  Sound.playTone(287,200); 
	      Delay.msDelay(150);         

	      Sound.playTone(392,200);  
	      Delay.msDelay(150);         

	      Sound.playTone(440,200);  
	      Delay.msDelay(150);        
		  Sound.beepSequenceUp();
		  Sound.beepSequenceUp();
	  }
	  
	  
	  public static void PlayLoose() {
		  Sound.buzz();
		  Sound.buzz();
	  }
}