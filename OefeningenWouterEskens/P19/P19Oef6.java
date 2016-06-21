import java.lang.*;

/**
*	Deze klasse (P19Oef6) is een programma
*	@author Wouter Eskens
*	@version 1.5
*/

public class P19Oef6
{
	/**
	* Dit is de main methode
	* @param args Dit een commandline argument
	*/
	
	public static void main (String args[])
	{
		int a[] = {12,34,56,78,123,234,99,88};
	
		int grootsteGetal = a[0];
	
		for(int i=0; i<a.length; i++)
		{
			if(grootsteGetal < a[i]){
				grootsteGetal = a[i];
			}
		}
		
		System.out.println(grootsteGetal);
	}
}