package panel;

import java.awt.Color;
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
				button.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
				button.setOpaque(true);
				button.setBackground(Color.WHITE);
				cells[row][col] = button;
				this.add(cells[row][col]);
			}
	}
	
	public void updateGrid(int row, int col, int val){
		buttons[row * n + col].setText("" + val);
		buttons[row * n + col].setForeground(Color.BLACK);
	}
	
	public void focus(int row, int col){
		buttons[row * n + col].setOpaque(false);
		
		for(int i = 0; i < n; i++)
			buttons[row * n + i].setBackground(Color.LIGHT_GRAY);
		
		for(int i = 0; i < n; i++)
			buttons[i * n + col].setBackground(Color.LIGHT_GRAY);
		
		int nsqrt = (int)Math.sqrt(n);
		while(row % nsqrt != 0) row--;
		while(col % nsqrt != 0) col--;
		for(int i = 0; i < n; i++){
			buttons[row * n + col].setBackground(Color.LIGHT_GRAY);
			col++;
			if(col % nsqrt == 0){
				col -= nsqrt;
				row++;
			}
		}
	}
	
	public void clear(int row, int col){
		buttons[row * n + col].setOpaque(true);
		
		for(int i = 0; i < n; i++)
			buttons[row * n + i].setBackground(Color.WHITE);
		
		for(int i = 0; i < n; i++)
			buttons[i * n + col].setBackground(Color.WHITE);
		
		int nsqrt = (int)Math.sqrt(n);
		while(row % nsqrt != 0) row--;
		while(col % nsqrt != 0) col--;
		for(int i = 0; i < n; i++){
			buttons[row * n + col].setBackground(Color.WHITE);
			col++;
			if(col % nsqrt == 0){
				col -= nsqrt;
				row++;
			}
		}
	}
	
	public void show(int row, int col, int val){
		if(val == -1){
			buttons[row * n + col].setText("");
			buttons[row * n + col].setForeground(Color.BLACK);
		}
		else{
			buttons[row * n + col].setText("" + val);
			if(val == 1)
				buttons[row * n + col].setForeground(Color.RED);
			else
				buttons[row * n + col].setForeground(Color.GREEN);
		}
	}
}
