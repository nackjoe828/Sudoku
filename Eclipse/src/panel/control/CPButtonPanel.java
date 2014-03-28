package panel.control;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CPButtonPanel extends JPanel{
	public CPButtonPanel(){
		super();
		this.setLayout(new GridLayout(1, 3));
		JButton back = new JButton("<");
		JButton forward = new JButton(">");
		JButton fastforward = new JButton(">>");
		this.add(back);
		this.add(forward);
		this.add(fastforward);
	}
}
