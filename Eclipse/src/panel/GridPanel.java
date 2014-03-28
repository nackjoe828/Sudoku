package panel;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

class GridPanel extends JPanel{
	private JButton[][] cells;
	private JButton[] buttons;
	private int n;
	private int nsqrt;
	
	public GridPanel(int n){
		super();
		this.n = n;
		this.nsqrt = (int)Math.sqrt(n);
		this.setLayout(new GridLayout(n, n));
		
		cells = new JButton[n][n];
		buttons = new JButton[n * n];
		int index = 0;
		for(int row = 0; row < 9; row++)
			for(int col = 0; col < 9; col++){
				JButton button = new JButton();
				buttons[index] = button;
				index++;
				//button.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
				cells[row][col] = button;
				this.add(cells[row][col]);
			}
	}
	
	public void updateGrid(int row, int col, int val){
		buttons[row * n + col].setText("" + val);
	}
}
