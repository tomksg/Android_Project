import java.util.*;


public class Map {
	
	protected int map[][];
	protected int x;
	protected int y;
	
	public Map(int x, int y){
		this.x = x;
		this.y = y;
		SnakeMap();
	}
	public int getTotal(){
		return (x-2)*(y-2);
	}
	
	public void SnakeMap(){	
		map = new int[x][y]; // 7,7
		initMap();
	}
	public void initMap(){
		for(int i =0; i<x ; i++){
			for(int j =0; j<y; j++){
				if(i==0||j==0||j==x-1||i==y-1){
						map[i][j] = 1;
				}else{
					map[i][j] = 0;
				}
			}
		}
	}
	
	public void GameOver(){
		String msg = "GameOver";
		System.out.println(msg);
	}
	
	public void PrintMap(){
		for(int i =0; i<x;i++){
			for(int j=0;j<y;j++){
				if(j==y-1){
					System.out.println(map[i][j]);
				}else{
					System.out.print(map[i][j]);
				}	
			}
		}
	}

}
