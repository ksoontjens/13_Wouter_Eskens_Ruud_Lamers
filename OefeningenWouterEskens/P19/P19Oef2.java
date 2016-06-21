import java.lang.*;

/**
*	Deze klasse (P19Oef2) is een programma
*	@author Wouter Eskens
*	@version 1.5
*/

public class P19Oef2
{
	/**
	* Dit is de main methode
	* @param args Dit een commandline argument
	*/
	
	public static void main (String args[])
	{
		int weekdag = 0;
		for(int dag = 1; dag<=28; dag++)
		{
			if(weekdag == 0) System.out.print("zon");
			if(weekdag == 1) System.out.print("maan");
			if(weekdag == 2) System.out.print("dins");
			if(weekdag == 3) System.out.print("woens");
			if(weekdag == 4) System.out.print("donder");
			if(weekdag == 5) System.out.print("vrij");
			if(weekdag == 6) System.out.print("zater");
			weekdag++;
			if(weekdag>6) weekdag=0;
			System.out.println("dag "+dag+" februari");
		}
	}
}