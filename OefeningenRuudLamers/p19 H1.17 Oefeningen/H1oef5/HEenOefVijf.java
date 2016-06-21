import java.lang.*;

/**
	* eerste java progje
	* @author Ruud Lamers
*/
public class HEenOefVijf{
	
	/**
		* main method
		* @param args Dit is een commandline argument
	*/
	public static void main(String args[])
	{
		boolean isPriemgetal = true;
	
		for(int i=3; i<=99; i++)
		{
			isPriemgetal = true;
			
			for(int j=2; j<i; j++)
			{
				if(i%j==0)
				{
					isPriemgetal = false;
				}
			}
			
			if(isPriemgetal)
			{
				System.out.println(i);
			}
		}
	}
	
}