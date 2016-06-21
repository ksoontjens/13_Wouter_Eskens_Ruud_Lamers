import java.lang.*;

/**
	* eerste java progje
	* @author Ruud Lamers
*/
public class HEenOefZeven{
	
	/**
		* main method
		* @param args Dit is een commandline argument
	*/
	public static void main(String args[])
	{
		int a[]={12,34,56,78,123,234,99,88};
		int b[]=new int[a.length];
		int index=0;
		
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println("");
		
		for(int i=0; i < a.length;i++){
			for(int j=0;j<a.length;j++){
				if(a[j]>a[index]){
					index=j;
				}
			}
			b[i]=a[index];
			a[index]=0;
			
		}
		
		for(int i=0;i<b.length;i++){
			System.out.print(b[i]+" ");
		}
		System.out.println("");
	}
	
}