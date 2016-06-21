import java.lang.*;

/**
*	Deze klasse (P19Oef7) is een programma
*	@author Wouter Eskens
*	@version 1.5
*/

public class P19Oef7
{
	/**
	* Dit is de main methode
	* @param args Dit een commandline argument
	*/
	
	public static void main (String args[])
	{
		int a[] = {12,34,56,78,123,234,99,88};
		int b[] = new int[a.length];
	
		int index = 0;
	
		for(int i=0; i<b.length; i++)
		{
			for(int j=0; j<a.length; j++)
			{
				if(a[index] < a[j])
				{
					index = j;
				}
			}
			
			b[i] = a[index];
			a[index] = 0;
		}
	
		for(int k=0; k<b.length; k++)
		{
			System.out.println(b[k]);
		}
	}
}