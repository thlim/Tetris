package model;

public interface IModel {

	
	Brick getBrick();
	void turnBrick();
	void resetBrick();
	boolean getForm(int x, int y);
	int getScene();
	Map getMap();
	void addBrick(Brick b);
	
}
