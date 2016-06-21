import java.lang.*;

/**
*	Deze klasse (P19Oef5) is een programma
*	@author Wouter Eskens
*	@version 1.5
*/

public class P19Oef5
{
	/**
	* Dit is de main methode
	* @param args Dit een commandline argument
	*/
	
	public static void main (String args[])
	{
		boolean isPriemgetal = true;
	
		for(int i=3; i<=99; i++)
		{
			isPriemgetal = true;
			
			for(int j=2; j<i; j++)
			{
				if(i%j==0)
				{
					isPriemgetal = false;
				}
			}
			
			if(isPriemgetal)
			{
				System.out.println(i);
			}
		}
	}
}