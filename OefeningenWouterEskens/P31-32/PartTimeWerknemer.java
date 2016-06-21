import java.lang.*;

/**
*	Deze klasse (PartTimeWerknemer) is een programma
*	@author Wouter Eskens
*	@version 1.5
*/

public class PartTimeWerknemer extends Werknemer
{
	/**
	* Dit is de main methode
	* @param args Dit een commandline argument
	*/
	
	int aantalUrenGewerkt;
	
	public PartTimeWerknemer (String vnaam, String anaam, int wNum, float sal, int aantalUren)
	{
		super(vnaam, anaam, wNum, sal);
		aantalUrenGewerkt = aantalUren;
	}
	
	public float getWeekLoon()
	{
		return aantalUrenGewerkt*salaris;
	}
	
	public void salarisVerhogen(int percentage)
	{
		if(percentage > 5)
		{
			percentage = 0;
			System.out.println("Fout: slechts 5% opslag toegestaan");
		} 
		else
		{
			super.salarisVerhogen(percentage);
		}
	}
}