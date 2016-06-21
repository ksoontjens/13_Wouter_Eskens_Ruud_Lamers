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
		PartTimeWerknemer mieke;
		StudentWerknemer bob;
		mieke=new PartTimeWerknemer("Mieke","de Man",221133,10,6);
		bob=new StudentWerknemer("Bob","de Man",991133,10,5);
		
		
		System.out.println("bob rsz: "+bob.getRSZ());
		System.out.println("mieke rsz: "+mieke.getRSZ());
	}
	
}