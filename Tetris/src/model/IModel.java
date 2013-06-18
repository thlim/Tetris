package model;

public interface IModel {

	
	Brick getBrick();
	void turnBrick();
	void resetBrick();
	boolean getForm(int x, int y);
	int getScene();
	int getBrickPosX();
	int getBrickPosY();
	int getBrickMLX();
	int getBrickMLY();
	int getBrickMRX();
	int getBrickMRY();
	int getBrickMBX();
	int getBrickMBY();
	void setBrickPosX(int x);
	void setBrickPosY(int y);
	void setBrickMLX(int mlx);
	void setBrickMLY(int mly);
	void setBrickMRX(int mrx);
	void setBrickMRY(int mry);
	void setBrickMBX(int mbx);
	void setBrickMBY(int mby);
	Map getMap();
	void addBrick(Brick b);
	boolean getMapValue(int x, int y);
	void setMapValue(int x, int y, boolean value);
}
