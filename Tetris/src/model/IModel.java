/**
 * 
 */
package model;

import com.google.inject.ImplementedBy;

/**
 * @author Bombilla
 *
 */
@ImplementedBy(ModelImpl.class)
public interface IModel {

	
	int getScene();
	void resetBrick();
	void turnBrick();
	boolean getBrickvalue(int x, int y);
	void addBrick();
	boolean getMapValue(int x, int y);
	void setMapValue(int x, int y, boolean value);
	/**
	 * @param mostBottomX the mostBottomX to set
	 */
	public void setMostBottomX(int mostBottomX);
	/**
	 * @param mostBottomY the mostBottomY to set
	 */
	public void setMostBottomY(int mostBottomY);
	/**
	 * @param mostLeftX the mostLeftX to set
	 */
	public void setMostLeftX(int mostLeftX);
	/**
	 * @param mostLeftY the mostLeftY to set
	 */
	public void setMostLeftY(int mostLeftY);
	/**
	 * @param mostRightX the mostRightX to set
	 */
	public void setMostRightX(int mostRightX);
	/**
	 * @param mostRightY the mostRightY to set
	 */
	public void setMostRightY(int mostRightY);
	/**
	 * @param posX the posX to set
	 */
	public void setPosX(int posX);
	/**
	 * @param posY the posY to set
	 */
	public void setPosY(int posY);
	/**
	 * @return the mostBottomX
	 */
	public int getMostBottomX();
	/**
	 * @return the mostBottomY
	 */
	public int getMostBottomY();
	/**
	 * @return the mostLeftX
	 */
	public int getMostLeftX();
	/**
	 * @return the mostLeftY
	 */
	public int getMostLeftY();
	/**
	 * @return the mostRightX
	 */
	public int getMostRightX();
	/**
	 * @return the mostRightY
	 */
	public int getMostRightY();
	/**
	 * @return the posX
	 */
	public int getPosX();
	/**
	 * @return the posY
	 */
	public int getPosY();
	
	
}
