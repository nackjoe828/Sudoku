package panel.control;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EtchedBorder;

public class ControlPanel extends JPanel{
	private CPButtonPanel cpbPanel;
	private SpringLayout layout;
	
	public ControlPanel(){
		super();
		cpbPanel = new CPButtonPanel();
		this.layout = new SpringLayout();
		this.setLayout(layout);
		
		cpbPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		layout.putConstraint(layout.NORTH, cpbPanel, 10, layout.NORTH, this);
		layout.putConstraint(layout.WEST, cpbPanel, 10, layout.WEST, this);
		layout.putConstraint(layout.SOUTH, cpbPanel, 50, layout.NORTH, cpbPanel);
		layout.putConstraint(layout.EAST, cpbPanel, -10, layout.EAST, this);
		this.add(cpbPanel);
	}
	
	
}
