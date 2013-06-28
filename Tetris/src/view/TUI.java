package view;

import java.io.PrintStream;

import model.IModel;

import com.google.inject.Guice;
import com.google.inject.Injector;

public final class TUI {
	private static TUI instance = null;
	private PrintStream console;
	private IModel model;
	private boolean tuiMap[][];
	private final int colMax = 10;
	private final int lineMax = 18;
	private final int brickMax = 4;

	protected static TUI getInstance() {
		if (instance == null) {
			instance = new TUI();
			return instance;
		}
		return instance;
	}

	private TUI() {
		console = System.out;
		Injector injector = Guice.createInjector();
		model = injector.getInstance(IModel.class);
		tuiMap = new boolean[colMax][lineMax];
	}

	protected void printGame() {
		brickPos();
		for (int j = 0; j < lineMax; ++j) {
			for (int i = 0; i < colMax; ++i) {
				boolean mapvalue = model.getMapValue(i, j);
				boolean tuiMapValue = tuiMap[i][j];
				if (mapvalue || tuiMapValue) {
					if (i == colMax -1) {
						console.printf("|X|\n");
					} else {
						console.printf("|X");
					}
				} else {

					if (i == colMax -1) {
						console.printf("|_|\n");
					} else {
						console.printf("|_");
					}
				}
			}
		}
		console.println("Level: " + model.getLevel());
		resetTuiMap();
	}

	private void brickPos() {
		if(model.getPosY() >= 0){
		for (int y = 0; y < brickMax; ++y) {
			for (int x = 0; x < brickMax; ++x) {
				if (model.getBrickvalue(x, y) && (model.getPosY() + y) < lineMax
						&& (model.getPosX() + x) < colMax) {
					tuiMap[model.getPosX() + x][model.getPosY() + y] = true;
				}
			}
		}
		}
	}

	private void resetTuiMap() {
		tuiMap = new boolean[colMax][lineMax];
	}
}
