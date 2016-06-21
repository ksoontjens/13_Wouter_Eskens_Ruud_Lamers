import java.lang.*;

/**
*	Deze klasse (StudentWerknemer) is een programma
*	@author Wouter Eskens
*	@version 1.5
*/

public class StudentWerknemer extends PartTimeWerknemer
{
	/**
	* Dit is de main methode
	* @param args Dit een commandline argument
	*/
	
	int aantalUrenGewerkt;
	
	public StudentWerknemer (String vnaam, String anaam, int wNum, float sal, int aUG)
	{
		super(vnaam, anaam, wNum, sal, aUG);
		setRSZ(5.0f);
	}
}