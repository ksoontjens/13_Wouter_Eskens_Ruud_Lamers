import java.lang.*;

/**
*	Deze klasse (P12Oef) is een programma
*	@author Wouter Eskens
*	@version 1.5
*/

public class P12Oef
{
	
	/**
	* Dit is de main methode
	* @param args Dit een commandline argument
	*/
	
	public static void main (String args[])
	{
		drukaf(100);
	}
	
	/**
	* Dit is de drukaf methode
	*/
	private static void drukaf(int m)
	{
		int a;
		for(a=0;a<m;a++)
		{
			System.out.println(a);
		}
	}
}