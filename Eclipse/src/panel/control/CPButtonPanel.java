package panel.control;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CPButtonPanel extends JPanel{
	public CPButtonPanel(){
		super();
		this.setLayout(new GridLayout(1, 3));
		JButton display = new JButton("All");
		JButton back = new JButton("<");
		JButton forward = new JButton(">");
		this.add(display);
		this.add(back);
		this.add(forward);
	}
}
