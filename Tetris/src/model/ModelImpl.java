package model;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ModelImpl implements IModel {

	private Brick brick;
	private Map map;

	private int mostLeftX;
	private int mostLeftY;
	private int mostRightX;
	private int mostRightY;
	private int mostBottomX;
	private int mostBottomY;
	private int lastScene;

	@Inject
	public ModelImpl() {
		mostLeftX = 4;
		mostRightX = -1;
		mostBottomY = -1;
		lastScene = 0;
		brick = Brick.getInstance();
		map = Map.getInstance();

	}

	@Override
	public void resetBrick(int style) {
		// TODO Auto-generated method stub
		mostLeftX = 4;
		mostRightX = -1;
		mostBottomY = -1;

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
		// TODO Auto-generated method stub
		lastScene = brick.getScene();
		map.addBrick(brick);

	}

	@Override
	public boolean getMapValue(int x, int y) {
		// TODO Auto-generated method stub

		return map.get(x, y);
	}

	@Override
	public void setMapValue(int x, int y, boolean value) {
		// TODO Auto-generated method stub
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

	/**
	 * @return the mostLeftX
	 */
	@Override
	public int getMostLeftX() {
		return mostLeftX;
	}

	/**
	 * @param mostLeftX
	 *            the mostLeftX to set
	 */
	@Override
	public void setMostLeftX(int mostLeftX) {
		this.mostLeftX = mostLeftX;
	}

	/**
	 * @return the mostLeftY
	 */
	@Override
	public int getMostLeftY() {
		return mostLeftY;
	}

	/**
	 * @param mostLeftY
	 *            the mostLeftY to set
	 */
	@Override
	public void setMostLeftY(int mostLeftY) {
		this.mostLeftY = mostLeftY;
	}

	/**
	 * @return the mostRightX
	 */
	@Override
	public int getMostRightX() {
		return mostRightX;
	}

	/**
	 * @param mostRightX
	 *            the mostRightX to set
	 */
	@Override
	public void setMostRightX(int mostRightX) {
		this.mostRightX = mostRightX;
	}

	/**
	 * @return the mostRightY
	 */
	@Override
	public int getMostRightY() {
		return mostRightY;
	}

	/**
	 * @param mostRightY
	 *            the mostRightY to set
	 */
	@Override
	public void setMostRightY(int mostRightY) {
		this.mostRightY = mostRightY;
	}

	/**
	 * @return the mostBottomX
	 */
	@Override
	public int getMostBottomX() {
		return mostBottomX;
	}

	/**
	 * @param mostBottomX
	 *            the mostBottomX to set
	 */
	@Override
	public void setMostBottomX(int mostBottomX) {
		this.mostBottomX = mostBottomX;
	}

	/**
	 * @return the mostBottomY
	 */
	@Override
	public int getMostBottomY() {
		return mostBottomY;
	}

	/**
	 * @param mostBottomY
	 *            the mostBottomY to set
	 */
	@Override
	public void setMostBottomY(int mostBottomY) {
		this.mostBottomY = mostBottomY;
	}

	@Override
	public int getScene() {
		// TODO Auto-generated method stub
		return brick.getScene();
	}

	@Override
	public int getLastScene() {
		// TODO Auto-generated method stub
		return lastScene;
	}

	@Override
	public int getMapColor(int x, int y) {
		// TODO Auto-generated method stub
		return map.getMapColor(x, y);
	}

}
