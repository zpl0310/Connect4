import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

public class GameBoard extends Panel implements MouseListener{
	private int row;
	private int col;
	private static final int gridSize = 40;
	private GameBoardController gbc;
	/////constructor/////
	
	public GameBoard(int row,int col){
		super();
		this.row = row;
		this.col = col;
		gbc = new GameBoardController(row,col);		
	}
	
	
	/////draw grid and token////
	public void paint(Graphics g){
		
		////draw vertical lines///
		for (int i = 0; i<= col;i++){
			g.setColor(Color.BLACK);
			g.drawLine(20, 20+i*gridSize, 20+gridSize*(row), 20+i*gridSize);
			
		}
		
		///draw horizontal lines///
		for (int i = 0; i<=row;i++){
			g.setColor(Color.BLACK);
			g.drawLine(20+i*gridSize,20, 20+i*gridSize,20+gridSize*(col));
			
		}
		
		for (int i=0;i<gbc.grids.length;i++){
			for(int j=0;j<gbc.grids[i].length;j++){
				if(gbc.grids[i][j]==1){
					g.setColor(Color.WHITE);
					g.fillOval(i*40+5, j*40+5, 30, 30);
					g.drawOval(i*40+5, j*40+5, 30, 30);
				}
				
				if(gbc.grids[i][j]==2){
					g.setColor(Color.BLACK);
					g.fillOval(5+i*40, 5+j*40, 30, 30);
					g.drawOval(5+i*40, 5+j*40, 30, 30);
				}
			
			}
		
		}
		
	}
	

	
	public void mousePressed(MouseEvent e){
			int clickX = e.getX();
			int clickY = e.getY();
			int pieceX = Math.round((float)(clickX-20)/gridSize);
			int pieceY = Math.round((float)(clickY-20)/gridSize);
			clickX = pieceX;
			clickY = pieceY;
		
			if(gbc.isValidMove(pieceX, pieceY)){
				gbc.setOneGrid(pieceX, pieceY);
				
				if (gbc.hasWin(pieceX, pieceY)){
					if (gbc.isFirstPlayer){
						JOptionPane.showMessageDialog(null, "game over, white win!");
					}
					else{
						JOptionPane.showMessageDialog(null, "game over, black win!");
					}
				}
				
				else {gbc.switchPlayer();}			
			}
			repaint();
		
			System.out.println(e.getX());
			System.out.println(e.getY());
			
		
			for (int i = 0; i<row;i++){
				for (int j = 0; j<col;j++){
					System.out.print(gbc.grids[i][j]+" ");
				
				}
				System.out.println();
			
			}
			System.out.println();
		

	}
		
	
	public void resetBoard(){
		for (int i = 0; i < row; i++){
			for (int j = 0;j < col; j++){
				gbc.grids[i][j] = 0;
			}
		}
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e){
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e){
		
	}
	

	@Override
	public void mouseEntered(MouseEvent e){
		
	}
	
	@Override
	public void mouseExited(MouseEvent e){
		
	}
	
	public void setAllChess(int[][] grids){
		this.gbc.grids = grids;
		
	}
	
	public int[][] getAllChess(){
		return gbc.grids;
	}


	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	public int getCol() {
		return col;
	}


	public void setCol(int col) {
		this.col = col;
	}

}
	
	
		
	

	

