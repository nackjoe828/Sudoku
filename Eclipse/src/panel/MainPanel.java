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
		
		
		// initializing grid with some numbers from example.
		// will be removed after implementing "initialize board" function
		grid.updateGrid(0, 0, 6);
		grid.updateGrid(0, 1, 5);
		grid.updateGrid(0, 4, 9);
		grid.updateGrid(1, 0, 4);
		grid.updateGrid(1, 3, 7);
		grid.updateGrid(1, 6, 3);
		grid.updateGrid(2, 0, 3);
		grid.updateGrid(2, 5, 1);
		grid.updateGrid(3, 2, 3);
		grid.updateGrid(3, 5, 6);
		grid.updateGrid(3, 6, 5);
		grid.updateGrid(3, 7, 4);
		grid.updateGrid(4, 1, 4);
		grid.updateGrid(4, 4, 5);
		grid.updateGrid(4, 7, 3);
		grid.updateGrid(5, 1, 9);
		grid.updateGrid(5, 2, 7);
		grid.updateGrid(5, 6, 6);
		grid.updateGrid(6, 3, 4);
		grid.updateGrid(6, 8, 2);
		grid.updateGrid(7, 2, 2);
		grid.updateGrid(7, 5, 7);
		grid.updateGrid(7, 8, 3);
		grid.updateGrid(8, 4, 1);
		grid.updateGrid(8, 7, 7);
		grid.updateGrid(8, 8, 5);
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}
	
	public void stateChanged(ChangeEvent e){
		
	}
}
