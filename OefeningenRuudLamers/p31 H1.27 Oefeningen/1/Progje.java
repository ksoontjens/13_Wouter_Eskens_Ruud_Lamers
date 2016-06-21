import java.lang.*;

/**
	* eerste java progje
	* @author Ruud Lamers
*/
public class Progje{
	
	/**
		* main method
		* @param args Dit is een commandline argument
	*/
	public static void main(String args[])
	{
		Werknemer jan, bob, piet, henk;
		jan=new Werknemer("Jan","de Man",221133);
		bob=new Werknemer("Bob","de Man",221134);
		piet=new Werknemer("Piet","de Man",221134);
		henk=new Werknemer("Jan","de Man",221135);
		
		System.out.println(jan.voornaam);
		System.out.println(bob.voornaam);
		System.out.println(piet.voornaam);
		System.out.println(henk.voornaam);
	}
	
}