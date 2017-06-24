import java.util.*;
public class Snake extends Map{
	
	private int snake_x[];
	private int snake_y[];
	
	private int CurrentDirection = NORTH;
	private int NextDirection = NORTH;
	
	private static final int NORTH = 1;
	private static final int SOUTH = 2;
	private static final int EAST = 3;
	private static final int WEST = 4;
	
	private static final int WIN = 1;
	private static final int LOSE = 2;
	
	
	public Snake(int x, int y) {
		super(x, y);
	}
	private void initGame(){
		initMap();
		int snake_x[] = new int [(x-2)*(y-2)];
		int snake_y[] = new int [(x-2)*(y-2)];
		
		snake_x[0] = 3;
		snake_y[0] = 3;
		
		for(int i = (x-2)*(y-2);i>0;i--){
			map[snake_x[i][snake_y[i]
		}
		
		
 	}
	private void ScanNextMove(){
		Scanner scan = new Scanner(System.in);
		String NextMove =scan.next();
		switch(NextMove){
			case "w":
				if(CurrentDirection==WEST){
					break;
				}else{
					NextDirection=NORTH;
				}
				break;
			case "s":
				if(CurrentDirection==WEST){
					break;
				}else{
					NextDirection=NORTH;
				}
				break;
			case "a":
				if(CurrentDirection==WEST){
					break;
				}else{
					NextDirection=NORTH;
				}
				break;
			case "d":
				if(CurrentDirection==WEST){
					break;
				}else{
					NextDirection=NORTH;
				}
				break;
			default:
				CurrentDirection = NextDirection;
		}
	}
	
	private void move(){
		ScanNextMove();
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
