import java.lang.*;

/**
*	Deze klasse (Oef2P31) is een programma
*	@author Wouter Eskens
*	@version 1.5
*/

public class Oef2P31
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
		
		Jan.salarisVerhogen(10);
		Luc.salarisVerhogen(10);
		
		System.out.println(Jan.getSalaris());
		System.out.println(Luc.getSalaris());
		System.out.println(Koen.getSalaris());
		System.out.println(Jos.getSalaris());
	}
}