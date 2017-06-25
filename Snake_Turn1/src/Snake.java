import java.util.*;
public class Snake extends Map{
	
	private final int snake_x[] = new int[25];
	private final int snake_y[] = new int[25];
	private int Apple_x;
	private int Apple_y;
	private int Apple_exist = 0;
	private int Game = 0;
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
		//System.out.printf("C %d N %d\n",CurrentDirection,NextDirection);
		switch(NextMove){
			case "w":
				if(CurrentDirection==SOUTH){
					break;
				}else{
					NextDirection=NORTH;
					CurrentDirection = NextDirection;
				}
				break;
			case "s":
				if(CurrentDirection==NORTH){
					break;
				}else{
					NextDirection=SOUTH;
					CurrentDirection = NextDirection;
				}
				break;
			case "a":
				if(CurrentDirection==EAST){
					break;
				}else{
					NextDirection=WEST;
					CurrentDirection = NextDirection;
				}
				break;
			case "d":
				if(CurrentDirection==WEST){
					break;
				}else{
					NextDirection=EAST;
					CurrentDirection = NextDirection;
				}
				break;
			default:
				CurrentDirection = NextDirection;
		}
		//System.out.printf("C %d N %d\n",CurrentDirection,NextDirection);
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
		tail_buffer_X = snake_x[snake_length-1];
		tail_buffer_Y = snake_y[snake_length-1];
		for(int i = snake_length-1; i>0;i--){
			map[snake_x[i]][snake_y[i]]=0;
			snake_x[i] = snake_x[i-1];
			snake_y[i] = snake_y[i-1];
		}
		ScanNextMove();
		switch(NextDirection){
			case NORTH:
				setXM();
				break;
			case SOUTH:
				setXP();
				break;
			case EAST:
				setYP();
				break;
			case WEST:
				setYM();
				break;
		}
		CheckCollition();
		CheckEat();
	//##############check with Game#########################
		if(Game==1){
			return;
		}else if(Game==2){
			System.out.println("Game Clear!!");
			return;
		}
	//##############check with Game#########################
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

	public void setGame(){
		Game++;
	}
	
	public void CheckCollition(){
		if(snake_x[0]==6||snake_x[0]==0||snake_y[0]==0||snake_y[0]==6){
			System.out.println("Wall Crash!!");
			GameOver(); // 추가할것
			setGame();
			return;
		}else{
			for(int i = snake_length;i>0;i--){
				if(snake_x[0]==snake_x[i] && snake_y[0] == snake_y[i]){
					System.out.printf("%dx[0] %dx[%d] %dy[0] %dy[%d]\n",snake_x[0],snake_x[i],i,snake_y[0],snake_y[i],i);
					System.out.println("Crash with yourself!!");
					setGame();
					return;				
				}
			}
		}
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
		//먹었으면 true
		return false;
	}
	
	
	public void RandomApple(){
		Random random = new Random();
		if(Apple_exist==0){
			Apple_x = random.nextInt(x-2)+1;
			Apple_y = random.nextInt(y-2)+1;
			int ok = 0;
			while(ok==0){
				ok = 1;
				for(int i = snake_length;i>=0;i--){
					if(Apple_x==snake_x[i]&&Apple_y==snake_y[i]){
						ok=0;
						Apple_x = random.nextInt(x-2)+1;
						Apple_y = random.nextInt(y-2)+1;
						break;
					}
				}
			}
			Apple_exist=1;
		}

	}
	
	
	
	
	
	
	
	
	
	
}
