package model;

public final class Brick {
	private static Brick instance = null;
	private boolean form[][];
	private int scene;
	private int posX;
	private int posY;

	private Brick() {
		resetBrick();
		
	}

	public static Brick getInstance() {
		if (instance == null) {
			instance = new Brick();
			return instance;
		}
		return instance;
	}

	public boolean get(int x, int y) {
		return form[x][y];
	}

	private void resetScene() {

		form = new boolean[4][4];
		

		switch (scene) {

		case 0:
			form[1][1] = true;
			form[2][1] = true;
			form[1][2] = true;
			form[2][2] = true;
			break;

		case 1:
			form[1][0] = true;
			form[1][1] = true;
			form[1][2] = true;
			form[1][3] = true;
			break;

		case 2:
			form[1][0] = true;
			form[1][1] = true;
			form[1][2] = true;
			form[2][2] = true;
			break;

		case 3:
			form[0][1] = true;
			form[1][1] = true;
			form[2][1] = true;
			form[1][2] = true;
			break;

		case 4:
			form[0][1] = true;
			form[1][1] = true;
			form[2][1] = true;
			form[2][2] = true;
			break;

		case 5:
			form[1][1] = true;
			form[2][1] = true;
			form[0][2] = true;
			form[1][2] = true;
			break;

		case 6:
			form[1][0] = true;
			form[1][1] = true;
			form[1][2] = true;
			form[0][2] = true;
			break;

		}
	}

	public void turn() {
		boolean temp[][] = new boolean[4][4];

		// Brick b = getInstance();

		temp[0][0] = form[0][3];
		temp[1][0] = form[0][2];
		temp[2][0] = form[0][1];
		temp[3][0] = form[0][0];

		temp[0][1] = form[1][3];
		temp[1][1] = form[1][2];
		temp[2][1] = form[1][1];
		temp[3][1] = form[1][0];

		temp[0][2] = form[2][3];
		temp[1][2] = form[2][2];
		temp[2][2] = form[2][1];
		temp[3][2] = form[2][0];

		temp[0][3] = form[3][3];
		temp[1][3] = form[3][2];
		temp[2][3] = form[3][1];
		temp[3][3] = form[3][0];

		form = temp;

	}

	public void resetBrick() {
		posX = 4;
		posY = 0;
		scene = (int) (Math.random() * 7);
		resetScene();
	}

	/**
	 * @return the scene
	 */
	public int getScene() {
		return scene;
	}



	/**
	 * @return the posX
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * @param posX the posX to set
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * @return the posY
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * @param posY the posY to set
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}
}