import java.lang.*;

/**
*	Deze klasse (P19Oef4) is een programma
*	@author Wouter Eskens
*	@version 1.5
*/

public class P19Oef4
{
	/**
	* Dit is de main methode
	* @param args Dit een commandline argument
	*/
	
	public static void main (String args[])
	{
		int getal = 4302;
		int neg;
		
		neg = ~getal+1;
		
		System.out.println(neg);
	}
}