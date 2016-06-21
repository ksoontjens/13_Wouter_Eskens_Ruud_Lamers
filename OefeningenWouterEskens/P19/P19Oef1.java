import java.lang.*;

/**
*	Deze klasse (P19Oef1) is een programma
*	@author Wouter Eskens
*	@version 1.5
*/

public class P19Oef1
{
	/**
	* Dit is de main methode
	* @param args Dit een commandline argument
	*/
	
	public static void main (String args[])
	{
		for(int i=1; i<=9; i++)
		{
			for(int j=1; j<=9; j++)
			{
				System.out.println(i + "x" + j + "=" + (i*j));
			}
		}
	}
}