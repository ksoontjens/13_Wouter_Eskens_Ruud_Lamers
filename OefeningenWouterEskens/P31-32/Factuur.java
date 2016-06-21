import java.lang.*;

/**
*	Deze klasse (Factuur) is een programma
*	@author Wouter Eskens
*	@version 1.5
*/

public class Factuur implements Betaalbaar
{
	/**
	* Dit is de main methode
	* @param args Dit een commandline argument
	*/
	
	public int factuurNummer;
	public float factuurBedrag;
	
	public Factuur (int factuurNummer, float factuurBedrag)
	{
		this.factuurNummer = factuurNummer;
		this.factuurBedrag = factuurBedrag;
	}
	
	public void betaal()
	{
		System.out.println("Betaal de factuur " + factuurNummer + " voor een bedrag van " + factuurBedrag + ".");
	}
}