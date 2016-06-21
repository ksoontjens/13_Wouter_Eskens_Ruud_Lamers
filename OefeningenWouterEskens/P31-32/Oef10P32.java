import java.lang.*;

/**
*	Deze klasse (Oef10P32) is een programma
*	@author Wouter Eskens
*	@version 1.5
*/

public class Oef10P32
{
	/**
	* Dit is de main methode
	* @param args Dit een commandline argument
	*/
	
	public static void main (String args[])
	{
		Factuur factuur = new Factuur(1, 500.0f);
		
		factuur.betaal();
	}
}