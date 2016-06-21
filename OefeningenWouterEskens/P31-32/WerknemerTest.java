import java.lang.*;

/**
*	Deze klasse (WerknemerTest) is een programma
*	@author Wouter Eskens
*	@version 1.5
*/

public class WerknemerTest
{
	
	/**
	* Dit is de main methode
	* @param args Dit een commandline argument
	*/
	
	public static void main (String args[])
	{
		Werknemer jan;
		jan = new Werknemer("Jan", "Met de Pet", 5, 200);
		
		System.out.println(jan.voornaam + " " + jan.achternaam);
	}
}