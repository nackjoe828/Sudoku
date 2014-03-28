package model;

import java.util.ArrayList;

import javax.swing.event.ChangeListener;

import controller.Controller;
import panel.MainPanel;

public class Model {
	private int[] values;
	private int n;
	private Controller controller;
	
	public Model(int n, Controller controller){
		values = new int[n * n];
		this.n = n;
		this.controller = controller;
	}
	
	public void initialize(){
		// initializing grid with some numbers from example.
		// will be removed after implementing "initialize board" function
		set(0, 0, 6);
		set(0, 1, 5);
		set(0, 4, 9);
		set(0, 6, 7);
		set(0, 7, 2);
		set(0, 8, 4);
		set(1, 0, 4);
		set(1, 3, 7);
		set(1, 6, 3);
		set(2, 0, 3);
		set(2, 2, 9);
		set(2, 5, 1);
		set(2, 8, 6);
		set(3, 2, 3);
		set(3, 5, 6);
		set(3, 6, 5);
		set(3, 7, 4);
		set(4, 1, 4);
		set(4, 4, 5);
		set(4, 7, 3);
		set(5, 1, 9);
		set(5, 2, 7);
		set(5, 4, 2);
		set(5, 5, 4);
		set(5, 6, 6);
		set(6, 1, 6);
		set(6, 3, 4);
		set(6, 6, 1);
		set(6, 8, 2);
		set(7, 2, 2);
		set(7, 5, 7);
		set(7, 8, 3);
		set(8, 0, 8);
		set(8, 1, 3);
		set(8, 2, 4);
		set(8, 4, 1);
		set(8, 7, 7);
		set(8, 8, 5);
	}
	
	public void set(int row, int col, int val){
		values[row * n + col] = val;
		controller.updateGrid(row, col, val);
	}
	
	public int[] getCPAvailable(int row, int col){
		//if filled already
		if(values[row * n + col] != 0) return null;
		
		int[] ret = new int[n]; //flag for checking availability for each number
		
		for(int i = 0; i < n; i++)
			ret[i] = 1;
		
		//check row
		for(int i = 0; i < n; i++){
			int val = values[row * n + i];
			if(val != 0)
				ret[val - 1] = 0; //index starting 1 => index starting 0
		}
		
		//check col
		for(int i = 0; i < n; i++){
			int val = values[i * n + col];
			if(val != 0)
				ret[val - 1] = 0; //index starting 1 => index starting 0
		}
		
		//check box
		int nsqrt = (int)Math.sqrt(n);
		while(row % nsqrt != 0) row--;
		while(col % nsqrt != 0) col--;
		for(int i = 0; i < n; i++){
			int val = values[row * n + col];
			if(val != 0)
				ret[val - 1] = 0;
			col++;
			if(col % nsqrt == 0){
				col -= nsqrt;
				row++;
			}
		}
		
		return ret;
	}
	
	public int getAvailableCount(int row, int col){
		int[] availability = this.getCPAvailable(row, col);
		if(availability == null) return -1;
		
		int count = 0;
		for(int i = 0; i < n; i++)
			if(availability[i] == 1) count++;
		
		return count;
	}
	
	public void fill(int row, int col){
		int[] availability = this.getCPAvailable(row, col);
		if(availability == null) return;
		
		int count = 0, index = 0;
		for(int i = 0; i < n; i++){
			if(availability[i] == 1){
				count++;
				index = i;
			}
		}
		if(count == 1) set(row, col, index + 1);
	}
}
