import lejos.hardware.Sound;

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
	 
	  public static void PlayBigWin() throws InterruptedException {
		  Sound.beepSequenceUp();
		  Sound.playTone(287,200); 
	      Thread.sleep(150);         

	      Sound.playTone(392,200);  
	      Thread.sleep(150);         

	      Sound.playTone(440,200);  
	      Thread.sleep(150);        
		  Sound.beepSequenceUp();
		  Sound.beepSequenceUp();
	  }
	  
	  
	  public static void PlayLoose() {
		  Sound.buzz();
		  Sound.buzz();
	  }
}