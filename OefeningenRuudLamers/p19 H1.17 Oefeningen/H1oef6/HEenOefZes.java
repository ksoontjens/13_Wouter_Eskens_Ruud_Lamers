import java.lang.*;

/**
	* eerste java progje
	* @author Ruud Lamers
*/
public class HEenOefZes{
	
	/**
		* main method
		* @param args Dit is een commandline argument
	*/
	public static void main(String args[])
	{
		int a[]={12,34,56,78,123,234,99,88};
		int grootste=a[0];
		for(int i=1;i < a.length;i++){
			if(a[i]>a[i-1]){
				grootste=a[i];
				}
		}
		System.out.println(grootste);
	}
	
}