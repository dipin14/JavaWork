
public class Spruce {

	public static void main(String[] args) {
		int i,j,k;
		for(i=1;i<=10;i+=2)
		{
			for(k=1;k <= ((i+9)/2)-i;k++)
			{
				System.out.print(" ");				
			}
			for(j=1;j<=i;j++)
			{
				System.out.print("*");
			}
			System.out.println("\n");
		}
	}
}
