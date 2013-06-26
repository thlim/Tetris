package model;

/**
 * 
 */

import com.google.inject.ImplementedBy;

/**
 * @author Bombilla
 * 
 */
@ImplementedBy(ModelImpl.class)
public interface IModel {

	int getMapColor(int x, int y);

	int getLastScene();

	int getScene();

	void resetBrick(int style);

	void turnBrick();

	boolean getBrickvalue(int x, int y);

	void addBrick();

	boolean getMapValue(int x, int y);

	void setMapValue(int x, int y, boolean value);

	/**
	 * @param mostBottomX
	 *            the mostBottomX to set
	 */
	void setMostBottomX(int mostBottomX);

	/**
	 * @param mostBottomY
	 *            the mostBottomY to set
	 */
	void setMostBottomY(int mostBottomY);

	/**
	 * @param mostLeftX
	 *            the mostLeftX to set
	 */
	void setMostLeftX(int mostLeftX);

	/**
	 * @param mostLeftY
	 *            the mostLeftY to set
	 */
	void setMostLeftY(int mostLeftY);

	/**
	 * @param mostRightX
	 *            the mostRightX to set
	 */
	void setMostRightX(int mostRightX);

	/**
	 * @param mostRightY
	 *            the mostRightY to set
	 */
	void setMostRightY(int mostRightY);

	/**
	 * @param posX
	 *            the posX to set
	 */
	void setPosX(int posX);

	/**
	 * @param posY
	 *            the posY to set
	 */
	void setPosY(int posY);

	/**
	 * @return the mostBottomX
	 */
	int getMostBottomX();

	/**
	 * @return the mostBottomY
	 */
	int getMostBottomY();

	/**
	 * @return the mostLeftX
	 */
	int getMostLeftX();

	/**
	 * @return the mostLeftY
	 */
	int getMostLeftY();

	/**
	 * @return the mostRightX
	 */
	int getMostRightX();

	/**
	 * @return the mostRightY
	 */
	int getMostRightY();

	/**
	 * @return the posX
	 */
	int getPosX();

	/**
	 * @return the posY
	 */
	int getPosY();

}
