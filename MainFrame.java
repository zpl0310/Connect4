import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;


public class MainFrame extends JFrame{
	private ToolBar tb;
	private TextField tf;
	private GameBoard gb;
	
	public MainFrame(){
		super();	
	}
	
	public MainFrame(String name){
		super(name);
		
		tb = new ToolBar();
		tf = new TextField();
		gb = new GameBoard(8,9);
		
		setSize(gb.getRow()*40+180, gb.getCol()*40+150);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		add(tb,BorderLayout.EAST);
		add(tf,BorderLayout.SOUTH);
		add(gb,BorderLayout.CENTER);
		
		gb.setBackground(new Color(255, 229, 229));
		gb.addMouseListener(gb);
		
		/*
		tb.setbt1Listener(new buttonListener(){
			public void resetBoard(){
				gb.resetBoard();
				
				
			}

			public void addComputer() {
				
				
			}
		});
			
		*/
	}
}
