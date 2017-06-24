import java.util.*;
public class Snake extends Map{
	
	private final int snake_x[] = new int[25];
	private final int snake_y[] = new int[25];
	
	private int snake_length = 2;
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
	
	
	public Snake(int x, int y){
		super(x, y);
		super.SnakeMap();
		//int snake_x[] = new int [getTotal()];
		//int snake_y[] = new int [getTotal()];

		snake_x[0] = 3;
		snake_y[0] = 3;
		snake_x[1] = 4;
		snake_y[1] = 3;
		//System.out.printf("test x y  %d\n", getTotal());
		//System.out.printf("test y %d\n", snake_y[0]);
		//System.out.printf("test map %d\n", map[snake_x[0]][snake_y[0]]);
		//map[snake_x[0]][snake_y[0]]=3;
		//PrintMap();
		UpdateMap();
		
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
	public void setXM(){
		snake_x[0] = snake_x[0]-1;
	}
	public void setYM(){
		snake_y[0] = snake_y[0]-1;
	}
	public void setYP(){
		snake_y[0] = snake_y[0]+1;
	}
	public void setXP(){
		snake_x[0] = snake_x[0]+1;
	}
	public void move(){
		ScanNextMove();
		switch(NextDirection){
			case NORTH:
				setXM();
				break;
			case SOUTH:
				setXP();
				break;
			case EAST:
				snake_y[0]++;
				break;
			case WEST:
				snake_y[0]--;
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
	}
	
	public void UpdateMap(){

	//	System.out.printf("%d\n",map[snake_x[0]][snake_y[0]]);
		for(int k = 0; k<snake_length;k++){
			if(k==0){
				//System.out.printf("%d,%d\n",snake_x[i],snake_y[i]);
				//System.out.printf("%d-k\n",snake_length);
				map[snake_x[k]][snake_y[k]]=3;
			}else{
				map[snake_x[k]][snake_y[k]]=2;
			}
		}
		PrintMap();
		
	}

	
	public void CheckEat() {
		//System.out.println("CheckEat Initiate");
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
