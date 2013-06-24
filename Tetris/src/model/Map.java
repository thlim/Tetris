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
	private Map() {
		map = new boolean[10][18];
		
		
	}

	protected void addBrick(Brick b) {
		for (int y = 0; y < 4; ++y) {
			for (int x = 0; x < 4; ++x) {
				if (b.get(x, y) && (b.getPosY() + y) < 18
						&& (b.getPosX() + x) < 10) {
					map[b.getPosX() + x][b.getPosY() + y] = true;
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

	/**
	 * @return the map
	 */
	protected boolean[][] getMap() {
		return map;
	}
	
	private void checkLineFull(){
		
		for (int j = 17; j >= 0; --j) {
			int i = 0;
				
			while(i < 10){
				boolean mapvalue = map[i][j];
				if ( !mapvalue ) {
					break;
				}
				else if ( i == 9){
					deleteLine(j);
					++j;
					break;
					
				}
				else{
					++i;
				}
			}
				
			
		}
		
	}
	
	private void deleteLine(int i){
		if (i != 0){
			for (int y = i; y >= 0; --y){
				if (y == 0){
					break;
				}
				else {
					for (int x = 0; x < 10; ++x){
						map[x][y] = map[x][y -1];	
					}
					
				}
			}
		}
		
		
	}
	
	
}