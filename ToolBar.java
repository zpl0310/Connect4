
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBar extends JPanel implements ActionListener{
	private JButton bt1;
	private JButton bt2;
	private buttonListener bl;
	
	public ToolBar(){
		setBorder(BorderFactory.createDashedBorder(Color.PINK, 600, 0));
		
		bt1 = new JButton ("New Game");
		bt2 = new JButton("Add Computer");
		//bt3 = new JButton("Quit");
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(bt1);
		panel.add(bt2);
		//panel.add(bt3);
		
		bt1.setBackground( new Color(255,255,230) );
		bt2.setBackground( new Color(255,255,230) );
		//bt3.setBackground( new Color(255,255,230) );
		   

		bt1.setMaximumSize( new Dimension(  200, 50) );
		bt2.setMaximumSize( new Dimension(  200, 50) );
		//bt3.setMaximumSize( new Dimension(  200, 50) );

		bt1.setAlignmentX( Component.CENTER_ALIGNMENT );
		bt2.setAlignmentX( Component.CENTER_ALIGNMENT );
		//bt3.setAlignmentX( Component.CENTER_ALIGNMENT );
		   		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		//bt3.addActionListener(this);
		
		add(panel);
		
		
		
	}
	
	public void setbt1Listener(buttonListener bl){
		this.bl = bl;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == bt1){
			if (bl!= null){
				bl.resetBoard();
			}
		}
		if (e.getSource() == bt2){
			if (bl!= null){
				bl.addComputer();
			}
			
		}
	}
	

	
	
}
