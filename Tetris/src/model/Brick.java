package model;

public final class Brick {
	private static Brick instance = null;
	private boolean form[][];
	private boolean nextForm[][];
	private int scene;
	private int nextScene;
	private int posX;
	private int posY;

	private Brick() {

		//nextScene = (int) (Math.random() * 7);
		resetBrick(nextScene);
	}

	protected static Brick getInstance() {
		if (instance == null) {
			instance = new Brick();
			return instance;
		}
		return instance;
	}

	protected boolean get(int x, int y) {
		return form[x][y];
	}

	protected void resetScene(int scene) {

		form = new boolean[4][4];
		nextForm = new boolean[4][4];

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
		nextForm[0][0] = form[0][3];
		nextForm[1][0] = form[0][2];
		nextForm[2][0] = form[0][1];
		nextForm[3][0] = form[0][0];

		nextForm[0][1] = form[1][3];
		nextForm[1][1] = form[1][2];
		nextForm[2][1] = form[1][1];
		nextForm[3][1] = form[1][0];

		nextForm[0][2] = form[2][3];
		nextForm[1][2] = form[2][2];
		nextForm[2][2] = form[2][1];
		nextForm[3][2] = form[2][0];

		nextForm[0][3] = form[3][3];
		nextForm[1][3] = form[3][2];
		nextForm[2][3] = form[3][1];
		nextForm[3][3] = form[3][0];
		
		nextScene = (int) (Math.random() * 7);
	}

	protected void turn() {

		form = nextForm.clone();
		nextForm = new boolean[4][4];
		
		nextForm[0][0] = form[0][3];
		nextForm[1][0] = form[0][2];
		nextForm[2][0] = form[0][1];
		nextForm[3][0] = form[0][0];

		nextForm[0][1] = form[1][3];
		nextForm[1][1] = form[1][2];
		nextForm[2][1] = form[1][1];
		nextForm[3][1] = form[1][0];

		nextForm[0][2] = form[2][3];
		nextForm[1][2] = form[2][2];
		nextForm[2][2] = form[2][1];
		nextForm[3][2] = form[2][0];

		nextForm[0][3] = form[3][3];
		nextForm[1][3] = form[3][2];
		nextForm[2][3] = form[3][1];
		nextForm[3][3] = form[3][0];
	}

	protected void resetBrick(int style) {
		posX = 4;
		posY = 0;

		scene = style;
		resetScene(scene);
	}

	/**
	 * @return the scene
	 */
	protected int getScene() {
		return scene;
	}

	/**
	 * @return the posX
	 */
	protected int getPosX() {
		return posX;
	}

	/**
	 * @param posX
	 *            the posX to set
	 */
	protected void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * @return the posY
	 */
	protected int getPosY() {
		return posY;
	}

	/**
	 * @param posY
	 *            the posY to set
	 */
	protected void setPosY(int posY) {
		this.posY = posY;
	}
	
	protected boolean[][] getNextForm()
	{
		return nextForm;
	}
	
	protected int getNextScene()
	{
		return nextScene;
	}
}