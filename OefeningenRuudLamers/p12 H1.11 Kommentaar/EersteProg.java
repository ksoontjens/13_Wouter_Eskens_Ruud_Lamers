import java.lang.*;

/**
	* eerste java progje
	* @author Ruud Lamers
*/
public class EersteProg{
	
	/*public static void main(String args[]){
		System.out.println("Hallo wereld");
		
		int a; //32 bits signed (2's complimented)
		long b;
		short c;
		byte d;
		
		float f;
		double db;
		
		a=5;
		a=a+1;
		b=3.3;
		b=b-0.1;
		
		char ch; // 
		ch='r'; //
	}*/
	/**
		* main method
		* @param args Dit is een commandline argument
	*/
	public static void main(String args[]){
		drukaf(50);
	}
	
	/**
		* drukaf method: getallen onder elkaar printen van 0 tot en met meegegeven parameter
		* @param m Hoeveel lijnen moeten er afgedrukt worden?
	*/
	public static void drukaf(int m){
		int a;
		for(a=0;a<m;a++){
			System.out.println(a);
		}
	}
	
}