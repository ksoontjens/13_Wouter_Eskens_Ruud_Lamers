import java.lang.*;

/**
*	Deze klasse (Werknemer) is een programma
*	@author Wouter Eskens
*	@version 1.5
*/

public class Werknemer implements Betaalbaar
{
	/**
	* Dit is de main methode
	* @param args Dit een commandline argument
	*/
	
	public String voornaam;
	public String achternaam;
	public int werknemerNummer;
	protected float salaris;
	private float RSZpercentage=33.0f;;
	
	public Werknemer (String voornaam, String achternaam, int werknemerNummer, float salaris)
	{
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.werknemerNummer = werknemerNummer;
		this.salaris = salaris;
	}
	
	public void salarisVerhogen(int perc)
	{
		salaris+=salaris*(perc/100.0);
	}
	
	public float getSalaris()
	{
		return salaris;
	}
	
	public void setRSZ(float rsz)
	{
		if(rsz>100)
		{
			System.out.println("Fout!");
		}
		
		RSZpercentage = rsz;
	}
	
	public float getRSZ()
	{
		return RSZpercentage;
	}
	
	public void betaal()
	{
		System.out.println("Betaal " + salaris + " aan " + voornaam);
	}
}