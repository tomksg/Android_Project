import java.util.Scanner;

public class Test {
	
	public static void main (String args[]){
		int x;
		int y;
		Scanner scan = new Scanner(System.in);
		x = scan.nextInt();
		y = scan.nextInt();
		Map map = new Map(x,y);
		map.PrintMap();
		
		
	}
}
