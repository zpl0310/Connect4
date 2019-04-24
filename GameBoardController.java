
public class GameBoardController {
	
	public int[][] grids;
	public boolean isFirstPlayer = true;
	private int row;
	private int col;
	
	public GameBoardController(int row, int col){
		this.row = row;
		this.col = col;
		grids = new int[row][col];	
	}
	
	public boolean hasWin(int x, int y){
		int current = grids[x][y];
		
		////vertical////
		int leftX = x;
		while(leftX >= 0 && grids[leftX][y]==current){
			leftX--;
		}
		
		int VNum =0;
		leftX ++;
		while(leftX<grids.length && grids[leftX][y]==current){
			VNum ++;
			leftX ++;
		}
		
		////horizontal////
		int topY =y;
		while(topY>=0 && grids[x][topY]==current){
			topY --;
		}
		
		int HNum = 0;
		topY ++;
		while (topY<grids[x].length && grids[x][topY]==current){
			topY ++;
			HNum++;
		}
		
		////bottom left to top right////
		int boleftX = x;
		int boleftY = y;
		while(boleftX>=0 &&boleftY< grids.length && grids[boleftX][boleftY]==current){
			boleftX --;
			boleftY ++;
		}
		
		int DiagonalNum1 =0;
		boleftX ++;
		boleftY --;
		while(boleftX<grids.length && boleftY>= 0 && grids[boleftX][boleftY]==current){
			DiagonalNum1 ++;
			boleftX ++;
			boleftY --;
			
		}
		
		////top left to bottom right////
		int toleftX = x;
		int toleftY = y;
		while(toleftX>=0 &&toleftY< grids.length && grids[toleftX][toleftY]==current){
			toleftX --;
			toleftY --;
			
		}
		
		int DiagonalNum2 =0;
		toleftX ++;
		toleftY ++;
		while(toleftX>=0 && toleftY<grids.length && grids[toleftX][toleftY]==current){
			DiagonalNum2 ++;
			toleftX ++;
			toleftY ++;
			
		}
		
		if (VNum>=4 || HNum >=4|| DiagonalNum1 >=4|| DiagonalNum2>=4){
			return true;
		}
		return false;
		
	}
	
	public boolean isValidMove(int x,int y){
		if (grids[x][y] == 1|| grids[x][y]== 2){
			return false;
		}
		else {
			if (y==col-1){
				return true;
			}
			if (grids[x][y+1] == 1 || grids[x][y+1]==2){
				return true;
			}
		}
		
		return false;
	}

	public int[][] getGrids() {
		return grids;
	}

	public void setGrids(int[][] grids) {
		this.grids = grids;
	}
	
	public void setOneGrid(int x, int y){
		if (isFirstPlayer){
			grids[x][y] = 1;
			}
		else {
			grids[x][y] = 2;
		}
	}
	
	public boolean switchPlayer(){
		isFirstPlayer = !isFirstPlayer;
		return isFirstPlayer;
	}
	
	

}
