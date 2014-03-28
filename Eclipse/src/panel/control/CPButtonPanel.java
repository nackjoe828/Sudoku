package panel.control;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CPButtonPanel extends JPanel{
	private ControlPanel cPanel;
	
	public CPButtonPanel(ControlPanel cPanel){
		super();
		this.cPanel = cPanel;
		this.setLayout(new GridLayout(3, 3));
		JButton left = new JButton("<");
		left.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				sendEvent(ButtonSourceType.LEFT);
			}
		});
		JButton right = new JButton(">");
		right.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				sendEvent(ButtonSourceType.RIGHT);
			}
		});
		JButton up = new JButton("^");
		up.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				sendEvent(ButtonSourceType.UP);
			}
		});
		JButton down = new JButton("v");
		down.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				sendEvent(ButtonSourceType.DOWN);
			}
		});
		JButton all = new JButton("All");
		all.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				sendEvent(ButtonSourceType.CP_ALL);
			}
		});
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				sendEvent(ButtonSourceType.CP_CLEAR);
			}
		});
		this.add(new JLabel());
		this.add(up);
		this.add(new JLabel());
		this.add(left);
		this.add(new JLabel());
		this.add(right);
		this.add(clear);
		this.add(down);
		this.add(all);
	}
	
	public void sendEvent(ButtonSourceType type){
		cPanel.sendEvent(type);
	}
}
