import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class TextField extends JPanel{
	private JTextArea jta;
	
	public TextField(){
		Border innerBorder = BorderFactory.createTitledBorder("Result:");
		Border outterBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outterBorder, innerBorder));
		
		
		jta = new JTextArea();
		
		setLayout(new BorderLayout());
		
		add(jta,BorderLayout.CENTER);
		
		add(new JScrollPane(jta),BorderLayout.CENTER);
	}
	
	public void setText(String text){
		jta.append(text);
		
	}
}
