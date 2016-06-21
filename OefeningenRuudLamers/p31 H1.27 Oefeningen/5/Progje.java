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
		PartTimeWerknemer mieke, kim;
		mieke=new PartTimeWerknemer("Mieke","de Man",221133,10,6);
		mieke.salarisVerhogen(10);
		kim=new PartTimeWerknemer("Kim","de Man",221133,10,11);
		kim.salarisVerhogen(1);
		
		System.out.println(mieke.getRSZ());
	}
	
}