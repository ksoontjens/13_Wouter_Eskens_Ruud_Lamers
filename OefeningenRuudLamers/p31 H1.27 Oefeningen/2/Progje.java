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
		jan=new Werknemer("Jan","de Man",221133,10);
		jan.salarisVerhogen(10);
		bob=new Werknemer("Bob","de Man",221134,10);
		bob.salarisVerhogen(10);
		piet=new Werknemer("Piet","de Man",221134,10);
		henk=new Werknemer("Jan","de Man",221135,10);
		
		System.out.println(jan.salaris);
		System.out.println(bob.salaris);
		System.out.println(piet.salaris);
		System.out.println(henk.salaris);
	}
	
}