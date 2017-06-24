import java.util.*;
public class Snake extends Map{
	
	private int snake_x[];
	private int snake_y[];
	
	private int snake_length = 0;
	
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
		
		
 	}
	private void ScanNextMove(){
		Scanner scan = new Scanner(System.in);
		String NextMove =scan.next();
		switch(NextMove){
			case "w":
				if(CurrentDirection==SOUTH){
					break;
				}else{
					NextDirection=NORTH;
				}
				break;
			case "s":
				if(CurrentDirection==NORTH){
					break;
				}else{
					NextDirection=SOUTH;
				}
				break;
			case "a":
				if(CurrentDirection==EAST){
					break;
				}else{
					NextDirection=WEST;
				}
				break;
			case "d":
				if(CurrentDirection==WEST){
					break;
				}else{
					NextDirection=EAST;
				}
				break;
			default:
				CurrentDirection = NextDirection;
		}
	}
	
	private void move(){
		for(int i = snake_length; i>0;i--){
			snake_x[i-1] = snake_x[i];
			snake_y[i-1] = snake_y[i];
		}
		ScanNextMove();
		switch(NextDirection){
			case NORTH:
				snake_y[0]--;
				break;
			case SOUTH:
				snake_y[0]++;
				break;
			case EAST:
				snake_x[0]++;
				break;
			case WEST:
				snake_x[0]--;
				break;
		}
		CheckEat();
	}
	
	
	private void CheckEat() {
		System.out.println("CheckEat Initiate");
	}
	private void eat(){
		
	}
	
	
	private void RandApple(){
		
	}
	
	
	
	
	
	
	
	
	
	
}
