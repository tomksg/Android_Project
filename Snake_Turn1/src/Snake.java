import java.util.*;
public class Snake extends Map{
	
	private int snake_x[];
	private int snake_y[];
	
	private int snake_length = 1;
	private int tail_buffer_X;
	private int tail_buffer_Y;
	
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
		initMap();
		int snake_x[] = new int [(x-2)*(y-2)];
		int snake_y[] = new int [(x-2)*(y-2)];
		
		snake_x[0] = 3;
		snake_y[0] = 3;

	}
	
	public void ScanNextMove(){
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

	public void move(){
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
		tail_buffer_X = snake_x[snake_length-1];
		tail_buffer_Y = snake_y[snake_length-1];
		for(int i = snake_length-1; i>0;i--){
			snake_x[i] = snake_x[i-1];
			snake_y[i] = snake_y[i-1];
			map[snake_x[i]][snake_y[i]]=0;
		}
		CheckEat();
		UpdateMap();
		PrintMap();
	}
	
	public void UpdateMap(){
		for(int i = 0; i<snake_length;i++){
			if(i==0){
				map[snake_x[i]][snake_y[i]]=3;
			}else{
				map[snake_x[i]][snake_y[i]]=2;
			}
		}
	}

	
	public void CheckEat() {
		System.out.println("CheckEat Initiate");
		if(eat()){
			snake_x[snake_length]=tail_buffer_X;
			snake_y[snake_length]=tail_buffer_Y;
			snake_length++;
		}
	}
	public boolean eat(){
		//¸Ô¾úÀ¸¸é true
		return false;
	}
	
	
	public void RandomApple(){
		
	}
	
	
	
	
	
	
	
	
	
	
}
