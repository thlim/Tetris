package model;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ModelImpl implements IModel {

	private Brick brick;
	private Map map;

	private static final int BRICK_MAX = 4;
	private static final int COL_MAX = 10;
	private static final int LINE_MAX = 18;

	@Inject
	public ModelImpl() {
		
		
		brick = Brick.getInstance();
		map = Map.getInstance();

	}

	@Override
	public void resetBrick(int style) {
		// TODO Auto-generated method stub
		

		brick.resetBrick(style);

	}

	@Override
	public void turnBrick() {
		// TODO Auto-generated method stub
		brick.turn();
	}

	@Override
	public boolean getBrickvalue(int x, int y) {

		return brick.get(x, y);
		// TODO Auto-generated method stub

	}

	@Override
	public void addBrick() {
		map.addBrick(brick);

	}

	@Override
	public boolean getMapValue(int x, int y) {

		return map.get(x, y);
	}

	@Override
	public void setMapValue(int x, int y, boolean value) {
		map.set(x, y, value);
	}

	/**
	 * @return the posX
	 */
	@Override
	public int getPosX() {
		return brick.getPosX();
	}

	/**
	 * @param posX
	 *            the posX to set
	 */
	@Override
	public void setPosX(int posX) {
		brick.setPosX(posX);
	}

	/**
	 * @return the posY
	 */
	@Override
	public int getPosY() {
		return brick.getPosY();
	}

	/**
	 * @param posY
	 *            the posY to set
	 */
	@Override
	public void setPosY(int posY) {
		brick.setPosY(posY);
	}

	@Override
	public int getScene() {
		return brick.getScene();
	}

	@Override
	public int getMapColor(int x, int y) {
		return map.getMapColor(x, y);
	}

	@Override
	public boolean[][] getNextForm() {
		return brick.getNextForm();
	}

	@Override
	public boolean valitateBrick(boolean[][] matrix, int x, int y) {
		
		for(int dy = 0; dy < BRICK_MAX; ++dy)
		{
			for(int dx = 0; dx < BRICK_MAX; ++dx)
			{
				if(matrix[dx][dy]){
					if(x + dx > 0 && x + dx < COL_MAX){
						if(y + dy > 0 && y + dy < LINE_MAX){
							
								if(map.get(x + dx, y + dy)){
									return false;
								}
							
						}
					}
				}
			
			}
		}
		return true;
	}

	@Override
	public int getLineCount() {
		return map.getLineCount();
	}

	@Override
	public void resetLineCount() {
		map.resetsetLineCount();
	}

	@Override
	public int getNextScene()
	{
		return brick.getNextScene();
	}

	@Override
	public double getLevel() {
		
		return map.getLevel();
	}

	@Override
	public int getState() {
		return map.getState();
	}

	@Override
	public void togglePause()
	{
		map.toggleState();
	}

	@Override
	public boolean isGameOver() {
		return map.isGameOver();
	}

}
