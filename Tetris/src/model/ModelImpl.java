package model;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ModelImpl implements IModel {

	Brick brick;
	Map map;
	
	

	private int mostLeftX;
	private int mostLeftY;
	private int mostRightX;
	private int mostRightY;
	private int mostBottomX;
	private int mostBottomY;

	@Inject
	public ModelImpl() {
		mostLeftX = 4;
		mostRightX = -1;
		mostBottomY = -1;
		
		brick = Brick.getInstance();
		map = Map.getInstance();
	}

	@Override
	public void resetBrick() {
		// TODO Auto-generated method stub
		mostLeftX = 4;
		mostRightX = -1;
		mostBottomY = -1;
		
		brick.resetBrick();

	}

	@Override
	public void turnBrick() {
		// TODO Auto-generated method stub
		brick.turn();
	}

	@Override
	public boolean getBrickvalue(int x, int y) {
		boolean result = brick.get(x, y);
		
		return result;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addBrick() {
		// TODO Auto-generated method stub
		map.addBrick(brick);
	}

	@Override
	public boolean getMapValue(int x, int y) {
		// TODO Auto-generated method stub
		
		boolean result = map.get(x, y);
		return result;
	}

	@Override
	public void setMapValue(int x, int y, boolean value) {
		// TODO Auto-generated method stub
		map.set(x, y, value);
	}



	

	/**
	 * @return the posX
	 */
	public int getPosX() {
		return brick.getPosX();
	}

	/**
	 * @param posX the posX to set
	 */
	public void setPosX(int posX) {
		brick.setPosX(posX);
	}

	/**
	 * @return the posY
	 */
	public int getPosY() {
		return brick.getPosY();
	}

	/**
	 * @param posY the posY to set
	 */
	public void setPosY(int posY) {
		brick.setPosY(posY);
	}

	/**
	 * @return the mostLeftX
	 */
	public int getMostLeftX() {
		return mostLeftX;
	}

	/**
	 * @param mostLeftX the mostLeftX to set
	 */
	public void setMostLeftX(int mostLeftX) {
		this.mostLeftX = mostLeftX;
	}

	/**
	 * @return the mostLeftY
	 */
	public int getMostLeftY() {
		return mostLeftY;
	}

	/**
	 * @param mostLeftY the mostLeftY to set
	 */
	public void setMostLeftY(int mostLeftY) {
		this.mostLeftY = mostLeftY;
	}

	/**
	 * @return the mostRightX
	 */
	public int getMostRightX() {
		return mostRightX;
	}

	/**
	 * @param mostRightX the mostRightX to set
	 */
	public void setMostRightX(int mostRightX) {
		this.mostRightX = mostRightX;
	}

	/**
	 * @return the mostRightY
	 */
	public int getMostRightY() {
		return mostRightY;
	}

	/**
	 * @param mostRightY the mostRightY to set
	 */
	public void setMostRightY(int mostRightY) {
		this.mostRightY = mostRightY;
	}

	/**
	 * @return the mostBottomX
	 */
	public int getMostBottomX() {
		return mostBottomX;
	}

	/**
	 * @param mostBottomX the mostBottomX to set
	 */
	public void setMostBottomX(int mostBottomX) {
		this.mostBottomX = mostBottomX;
	}

	/**
	 * @return the mostBottomY
	 */
	public int getMostBottomY() {
		return mostBottomY;
	}

	/**
	 * @param mostBottomY the mostBottomY to set
	 */
	public void setMostBottomY(int mostBottomY) {
		this.mostBottomY = mostBottomY;
	}

	@Override
	public int getScene() {
		// TODO Auto-generated method stub
		return brick.getScene();
	}

}
