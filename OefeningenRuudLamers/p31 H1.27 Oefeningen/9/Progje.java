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
		PartTimeWerknemer mieke=new PartTimeWerknemer("Mieke","de Man",221133,15,6);
		Werknemer kim=new Werknemer("Kim","de Man",221134,20.0f);
		StudentWerknemer bob=new StudentWerknemer("Bob","de Man",221135,10,11);
		
		mieke.betaal();
		kim.betaal();
		bob.betaal();
	}
	
}