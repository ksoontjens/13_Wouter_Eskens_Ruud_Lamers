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
		PartTimeWerknemer kim;
		Werknemer mieke;
		mieke=new Werknemer("Mieke","de Man",221133,10);
		mieke.salarisVerhogen(10);
		kim=new PartTimeWerknemer("Kim","de Man",221133,10,11);
		kim.salarisVerhogen(1);
		
		mieke.setRSZ(101);
		System.out.println(mieke.getRSZ());
		kim.setRSZ(2);
		System.out.println(kim.getRSZ());
	}
	
}