import java.lang.*;

/**
*	Deze klasse (P31Oef6) is een programma
*	@author Wouter Eskens
*	@version 1.5
*/

public class P31Oef6
{
	/**
	* Dit is de main methode
	* @param args Dit een commandline argument
	*/
	
	public static void main (String args[])
	{
		Werknemer Jan = new Werknemer("Jan", "Met de Pet", 1, 35.0f);
		Werknemer Luc = new Werknemer("Luc", "Met de Muts", 2, 35.0f);
		Werknemer Koen = new Werknemer("Koen", "Met de Klak", 3, 35.0f);
		Werknemer Jos = new Werknemer("Jos", "Met het Hoofddeksel", 4, 35.0f);
		PartTimeWerknemer Suzy = new PartTimeWerknemer("Suzy", "Met de Boerka", 5, 20.0f, 20);
		PartTimeWerknemer Nancy = new PartTimeWerknemer("Nancy", "De Kuisvrouw", 6, 20.0f, 30);
		
		System.out.println("RSZpercentage = " + Jan.getRSZ());
	}
}