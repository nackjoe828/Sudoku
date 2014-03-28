package panel;

import java.awt.Container;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import panel.control.ControlPanel;



public class MainPanel extends JFrame implements ChangeListener{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 700;
	
	private GridPanel grid;
	private MessagePanel message;
	private ControlPanel control;
	private SpringLayout layout;
	
	public MainPanel(){
		super();
		this.setSize(WIDTH, HEIGHT);
		this.setTitle("Sudoku");
		Container container = this.getContentPane();
		layout = new SpringLayout();
		container.setLayout(layout);
		
		grid = new GridPanel(9);
		grid.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		layout.putConstraint(layout.NORTH, grid, 10, layout.NORTH, container);
		layout.putConstraint(layout.WEST, grid, 10, layout.WEST, container);
		layout.putConstraint(layout.SOUTH, grid, 500, layout.NORTH, grid);
		layout.putConstraint(layout.EAST, grid, 500, layout.WEST, grid);
		this.add(grid);
		
		message = new MessagePanel();
		message.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		layout.putConstraint(layout.NORTH, message, 10, layout.SOUTH, grid);
		layout.putConstraint(layout.WEST, message, 10, layout.WEST, container);
		layout.putConstraint(layout.SOUTH, message, -10, layout.SOUTH, container);
		layout.putConstraint(layout.EAST, message, -10, layout.EAST, container);
		this.add(message);
		
		control = new ControlPanel();
		control.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		layout.putConstraint(layout.NORTH, control, 10, layout.NORTH, container);
		layout.putConstraint(layout.WEST, control, 10, layout.EAST, grid);
		layout.putConstraint(layout.SOUTH, control, -10, layout.NORTH, message);
		layout.putConstraint(layout.EAST, control, -10, layout.EAST, container);
		this.add(control);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}
	
	public void stateChanged(ChangeEvent e){
		
	}
}
