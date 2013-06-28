package model;

public final class Map {
	private static Map instance = null;

	protected static Map getInstance() {
		if (instance == null) {
			instance = new Map();
			return instance;
		}
		return instance;
	}

	private static boolean map[][];
	private static int mapColor[][];
	private int lineCount;
	private double level;
	private int state;
	private boolean gameOver;
	
	private static final int MAP_WIDTH = 10;
	private static final int MAP_HEIGHT = 18;
	private static final int BRICK_SIZE = 4;

	private Map() {
		map = new boolean[MAP_WIDTH][MAP_HEIGHT];
		mapColor = new int[MAP_WIDTH][MAP_HEIGHT];
		lineCount = 0;
		level = 1.0;
		state = 0;
		gameOver = false;
		initMapColor();
	}

	private void initMapColor() {

		for (int y = 0; y < MAP_HEIGHT; ++y) {
			for (int x = 0; x < MAP_WIDTH; ++x) {
				mapColor[x][y] = -1;
			}
		}

	}

	protected void addBrick(Brick b) {
		for (int y = 0; y < BRICK_SIZE; ++y) {
			for (int x = 0; x < BRICK_SIZE; ++x) {
				if (b.get(x, y) && (b.getPosY() + y) < MAP_HEIGHT
						&& (b.getPosY() + y >= 0)
						&& (b.getPosX() + x) < MAP_WIDTH) {
					map[b.getPosX() + x][b.getPosY() + y] = true;
					mapColor[b.getPosX() + x][b.getPosY() + y] = b.getScene();
				}
				if(b.getPosY() + y < 0 && b.get(x, y))
				{
					state = 1;
					gameOver = true;
				}
			}
		}
		checkLineFull();
	}

	protected void set(int x, int y, boolean value) {
		map[x][y] = value;
	}

	protected boolean get(int x, int y) {
		return map[x][y];
	}

	private void checkLineFull() {

		for (int j = MAP_HEIGHT - 1; j >= 0; --j) {
			int i = 0;

			while (i < MAP_WIDTH) {
				boolean mapvalue = map[i][j];
				if (!mapvalue) {
					break;
				} else if (i == MAP_WIDTH - 1) {
					deleteLine(j);
					++lineCount;
					if(lineCount == 1){
					  ++level;
					  lineCount = 0;
					}
					++j;
					break;

				} else {
					++i;
				}
			}

		}

	}

	private void deleteLine(int i) {
		if (i != 0) {
			for (int y = i; y >= 0; --y) {
				if (y == 0) {
					break;
				} else {
					for (int x = 0; x < MAP_WIDTH; ++x) {
						map[x][y] = map[x][y - 1];
						mapColor[x][y] = mapColor[x][y-1];
					}

				}
			}
		}

	}

	protected int getMapColor(int x, int y) {
		return mapColor[x][y];
	}

	/**
	 * @return the lineCount
	 */
	protected int getLineCount() {
		return lineCount;
	}

	/**
	 * @param lineCount the lineCount to set
	 */
	protected void resetsetLineCount() {
		this.lineCount = 0;
	}
	
	protected double getLevel(){
		return level;
	}
	
	protected void toggleState()
	{
		if(state == 0)
		{
			state = 1;
		}
		else
		{
			state = 0;
		}
	}
	
	protected int getState()
	{
		return state;
	}
	
	protected boolean isGameOver()
	{
		return gameOver;
	}
}