package controller;

import model.Model;
import panel.MainPanel;
import panel.control.ButtonSourceType;

public class Controller {
	private MainPanel panel;
	private Model model;
	private int n;
	private int rowindex;
	private int colindex;
	private int flag;
	
	public Controller(MainPanel panel, int n){
		this.panel = panel;
		this.n = n;
	}
	
	public void addModel(Model model){
		this.model = model;
	}
	
	public void handleEvent(ButtonSourceType type){
		int[] availability = null;
		switch(type){
		case UP:
			if(rowindex == 0) break;
			availability = model.getCPAvailable(--rowindex, colindex);
			panel.showMessage(availability);
			panel.clear(rowindex + 1, colindex);
			panel.focus(rowindex, colindex);
			break;
		case LEFT:
			if(colindex == 0) break;
			availability = model.getCPAvailable(rowindex, --colindex);
			panel.showMessage(availability);
			panel.clear(rowindex, colindex + 1);
			panel.focus(rowindex, colindex);
			break;
		case RIGHT:
			if(colindex == n - 1) break;
			availability = model.getCPAvailable(rowindex, ++colindex);
			panel.showMessage(availability);
			panel.clear(rowindex, colindex - 1);
			panel.focus(rowindex, colindex);
			break;
		case DOWN:
			if(rowindex == n - 1) break;
			availability = model.getCPAvailable(++rowindex, colindex);
			panel.showMessage(availability);
			panel.clear(rowindex - 1, colindex);
			panel.focus(rowindex, colindex);
			break;
		case CP_ALL:
			int val = 0;
			for(int row = 0; row < n; row++)
				for(int col = 0; col < n; col++)
					if((val = model.getAvailableCount(row, col)) >= 0)
						panel.showCount(row, col, val);
			flag = 1;
			break;
		case CP_CLEAR:
			val = 0;
			for(int row = 0; row < n; row++)
				for(int col = 0; col < n; col++)
					if((val = model.getAvailableCount(row, col)) >= 0)
						panel.showCount(row, col, -1);
			flag = 0;
			panel.focus(rowindex, colindex);
			break;
		case CP_FILL:
			for(int row = 0; row < n; row++)
				for(int col = 0; col < n; col++)
					if(model.fill(row, col)){
						if(flag == 1)
							handleEvent(ButtonSourceType.CP_ALL);
						else
							handleEvent(ButtonSourceType.CP_CLEAR);
						return;
					}
			
			//if none filled, start searching
			for(int row = 0; row < n; row++)
				for(int col = 0; col < n; col++){
					if(model.getAvailableCount(row, col) == 2){
						int[] availableList = model.getCPAvailable(row, col);
						for(int i = 0; i < n; i++){
							if(availableList[i] == 1){
								int[] init = model.getValues();
								init[n * row + col] = i + 1;
								MainPanel newPanel = new MainPanel(init);
							}
						}
						return;
					}
				}
			
			// model.printcells(); <= used to obtain instructions to fill the complete grid
			break;
		}
	}
	
	public void updateGrid(int row, int col, int val){
		panel.updateGrid(row, col, val);
	}
}
