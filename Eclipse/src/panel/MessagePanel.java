package panel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MessagePanel extends JPanel{
	private JTextArea field;
	
	public MessagePanel(){
		super();
		this.setLayout(new GridLayout(1, 1));
		field = new JTextArea();
		this.add(field);
	}
	
	public void showAvailability(int[] availability){
		if(availability == null){
			field.setText("Spot already taken.");
			return;
		}
		String buf = "Available Numbers: ";
		for(int i = 0; i < availability.length; i++){
			if(availability[i] == 1) buf += (i + 1) + ", ";
		}
		buf = buf.substring(0, buf.length() - 2);
		
		field.setText(buf);
	}
}
