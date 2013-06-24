package view;

import java.io.PrintStream;

import model.IModel;

import com.google.inject.Guice;
import com.google.inject.Injector;

public final class TUI
{
	private static TUI instance = null;
	private PrintStream console;
	private IModel model;
	private boolean tuiMap[][];
	
	public static TUI getInstance()
	{
		if(instance == null)
		{
			instance = new TUI();
			return instance;
		}
		return instance;
	}
	
	private TUI()
	{
		console = System.out;
		Injector injector = Guice.createInjector();
		model = injector.getInstance(IModel.class);
		tuiMap = new boolean[10][18];
	}
	
	public void printMenu()
	{
		console.printf("Tetris\n");
		console.printf("\t1) Start game\n");
		console.printf("\tQ) Exit game\n");
	}
	
	public void printGame()
	{
		brickPos();
		for (int j = 0; j < 18; ++j) {
			for (int i = 0; i < 10; ++i) {
				boolean mapvalue = model.getMapValue(i, j);
				boolean tuiMapValue = tuiMap[i][j];
				if ( mapvalue == true || tuiMapValue == true ) {
					if(i == 9){
						console.printf("|X|\n");
					}
					else console.printf("|X");
				}
				else {
					
					if(i == 9){
						console.printf("|_|\n");
					}
					else console.printf("|_");
				}
			}
		}
		resetTuiMap();
	}
	
	private void brickPos(){
		for (int y = 0; y < 4; ++y) {
			for (int x = 0; x < 4; ++x) {
				if (model.getBrickvalue(x, y) == true && (model.getPosY() + y) < 18
						&& (model.getPosX() + x) < 10) {
					tuiMap[model.getPosX() + x][model.getPosY() + y] = true;
				}
			}
	}
	}
	
	private void resetTuiMap(){
		tuiMap = new boolean[10][18];
	}
}
