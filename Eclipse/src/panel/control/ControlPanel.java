package panel.control;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ControlPanel extends JPanel{
	private CPButtonPanel cpbPanel;
	private JButton cpFill;
	private SpringLayout layout;
	
	public ControlPanel(){
		super();
		cpbPanel = new CPButtonPanel();
		cpFill = new JButton("Fill");
		this.layout = new SpringLayout();
		this.setLayout(layout);
		
		cpbPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Constraint Propagation"));
		layout.putConstraint(layout.NORTH, cpbPanel, 10, layout.NORTH, this);
		layout.putConstraint(layout.WEST, cpbPanel, 10, layout.WEST, this);
		layout.putConstraint(layout.SOUTH, cpbPanel, 70, layout.NORTH, cpbPanel);
		layout.putConstraint(layout.EAST, cpbPanel, -10, layout.EAST, this);
		this.add(cpbPanel);
		
		layout.putConstraint(layout.NORTH, cpFill, 10, layout.SOUTH, cpbPanel);
		layout.putConstraint(layout.WEST, cpFill, 10, layout.WEST, this);
		layout.putConstraint(layout.SOUTH, cpFill, 50, layout.NORTH, cpFill);
		layout.putConstraint(layout.EAST, cpFill, -10, layout.EAST, this);
		this.add(cpFill);
	}
	
	
}
