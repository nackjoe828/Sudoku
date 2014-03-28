package panel.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controller.Controller;

public class ControlPanel extends JPanel{
	private CPButtonPanel cpbPanel;
	private Controller controller;
	private JButton cpFill;
	private SpringLayout layout;
	
	public ControlPanel(Controller controller){
		super();
		this.controller = controller;
		cpbPanel = new CPButtonPanel(this);
		cpFill = new JButton("Fill");
		cpFill.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				sendEvent(ButtonSourceType.CP_FILL);
			}
		});
		this.layout = new SpringLayout();
		this.setLayout(layout);
		
		cpbPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Constraint Propagation"));
		layout.putConstraint(layout.NORTH, cpbPanel, 10, layout.NORTH, this);
		layout.putConstraint(layout.WEST, cpbPanel, 10, layout.WEST, this);
		layout.putConstraint(layout.SOUTH, cpbPanel, 150, layout.NORTH, cpbPanel);
		layout.putConstraint(layout.EAST, cpbPanel, -10, layout.EAST, this);
		this.add(cpbPanel);
		
		layout.putConstraint(layout.NORTH, cpFill, 10, layout.SOUTH, cpbPanel);
		layout.putConstraint(layout.WEST, cpFill, 10, layout.WEST, this);
		layout.putConstraint(layout.SOUTH, cpFill, 50, layout.NORTH, cpFill);
		layout.putConstraint(layout.EAST, cpFill, -10, layout.EAST, this);
		this.add(cpFill);
	}
	
	public void sendEvent(ButtonSourceType type){
		controller.handleEvent(type);
	}
}
