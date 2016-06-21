import java.lang.*;

/**
*	Deze klasse (P19Oef3) is een programma
*	@author Wouter Eskens
*	@version 1.5
*/

public class P19Oef3
{
	/**
	* Dit is de main methode
	* @param args Dit een commandline argument
	*/
	
	public static void main (String args[])
	{
		float pi = 0.0f;
		
		float teller = 1;
		
		for(float i = 0; i<10000; i++)
		{
			if(i%2==0)
			{
				pi+=(1/teller);
			} 
			else
			{
				pi-=(1/teller);
			} 
			
			teller +=2;
		}
		
		pi = pi * 4;
		
		System.out.print(pi);
	}
}