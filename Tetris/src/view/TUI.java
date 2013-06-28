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
	private static final int COL_MAX = 10;
	private static final int LINE_MAX = 18;
	private static final int BRICK_MAX = 4;

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
		tuiMap = new boolean[COL_MAX][LINE_MAX];
	}

	protected void printGame() {
		brickPos();
		for (int j = 0; j < LINE_MAX; ++j) {
			for (int i = 0; i < COL_MAX; ++i) {
				boolean mapvalue = model.getMapValue(i, j);
				boolean tuiMapValue = tuiMap[i][j];
				if (mapvalue || tuiMapValue) {
					if (i == COL_MAX -1) {
						console.printf("|X|\n");
					} else {
						console.printf("|X");
					}
				} else {

					if (i == COL_MAX -1) {
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
		for (int y = 0; y < BRICK_MAX; ++y) {
			for (int x = 0; x < BRICK_MAX; ++x) {
				if (model.getBrickvalue(x, y) && (model.getPosY() + y) < LINE_MAX
						&& (model.getPosX() + x) < COL_MAX) {
					tuiMap[model.getPosX() + x][model.getPosY() + y] = true;
				}
			}
		}
		}
	}

	private void resetTuiMap() {
		tuiMap = new boolean[COL_MAX][LINE_MAX];
	}
}
