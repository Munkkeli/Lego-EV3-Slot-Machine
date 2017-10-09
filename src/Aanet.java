/**
 * Toistaa pelin äänet.
 * 
 * @author Neea Oja
 */

import lejos.hardware.Sound;
import lejos.utility.Delay;

public class Aanet { 
	  
	/**
	 * Toistaa voiton äänen.
	 */
	public static void PlayWin() {
		 Sound.beepSequence();
		 Sound.beepSequence();
	 }
	 
	 /**
	  * Toistaa suuremman voiton äänen.
	  */
	 public static void PlayWinwin() {
		 Sound.beepSequenceUp();
		 Sound.beepSequenceUp();
		 
	 }
	 
	 /**
	  * Toistaa suurimman voiton äänen.
	  */
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
	  
	  /**
	   * Toistaa häviön äänen.
	   */
	  public static void PlayLoose() {
		  Sound.buzz();
		  Sound.buzz();
	  }
}