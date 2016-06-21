import java.lang.*;

/**
	* eerste java progje
	* @author Ruud Lamers
*/
public class HEenOefTwee{
	
	/**
		* main method
		* @param args Dit is een commandline argument
	*/
	public static void main(String args[]){
		int weekdag=0;
		for(int dag=1;dag<=29;dag++){
			switch(weekdag){
				case 0:
					System.out.print("zon");
					break;
				case 1:
					System.out.print("maan");
					break;
				case 2:
					System.out.print("dins");
					break;
				case 3:
					System.out.print("woens");
					break;
				case 4:
					System.out.print("donder");
					break;
				case 5:
					System.out.print("vrij");
					break;
				case 6:
					System.out.print("zater");
					break;
				default:
				System.out.print("Deze dag bestaat niet!");
			}
			
			System.out.println("dag "+dag+" februari");
			
			weekdag++;
			if(weekdag>6)
				weekdag=0;
		}
	}
	
}