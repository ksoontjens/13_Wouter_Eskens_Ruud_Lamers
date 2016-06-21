import java.lang.*;

/**
	* eerste java progje
	* @author Ruud Lamers
*/
public class HEenOefDrie{
	
	/**
		* main method
		* @param args Dit is een commandline argument
	*/
	public static void main(String args[]){
		float pi=0.0f;
		int breuk=1;
		
		for(int i=1;i<=10000;i++){
			if(i%2!=0){
				pi+=(float)1/breuk;
				breuk+=2;
			}else{
				pi-=(float)1/breuk;
				breuk+=2;
			}
		}
		System.out.println(pi*(float)4);
	}
	
}