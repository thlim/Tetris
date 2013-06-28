package view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

import com.google.inject.Guice;
import com.google.inject.Injector;

import model.IModel;

public final class GUI extends Frame {
	private static final long serialVersionUID = 1L;
	private static GUI instance = null;

	private IModel model;

	private final int width = 800;
	private final int height = 600;
	private final int location = 0;
	private final int mapWidth = 10;
	private final int mapHeight = 18;
	private final int blockSize = 30;
	private final int brickSize = 4;
	
	public static GUI getInstance() {
		if (instance == null) {
			instance = new GUI();
			return instance;
		}
		return instance;
	}

	private GUI() {
		Injector injector = Guice.createInjector();
		model = injector.getInstance(IModel.class);

		setSize(width, height);
		setLocation(location, location);
		setResizable(false);
		setTitle("Tetris");
		setBackground(Color.white);
		setVisible(true);
	}

	private void drawMap(final Graphics g, final int x, final int y) {
		for (int j = 0; j < mapHeight; ++j) {
			for (int i = 0; i < mapWidth; ++i) {
				boolean mapvalue = model.getMapValue(i, j);
				if (mapvalue) {

					g.setColor(getColor(model.getMapColor(i, j)));
					g.fillRect(i * blockSize + x, j * blockSize + y, blockSize, blockSize);
				}
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		final int x = 100;
		final int y = 40;
		final int borderX = 500;
		final int borderY = 600;
		final int borderWidth = 300;
		final int borderHeight = 540;

		drawMap(g, x, y);
		drawBrick(g, x, y);
		drawPreview(g, x, y, model.getNextScene());
		drawScore(g);

		// DRAWING BORDERS AT THE END
		g.setColor(Color.black);
		g.drawLine(borderX, 0, borderX, borderY);

		for (int j = 0; j < mapWidth + 1; ++j) {
			g.drawLine(j * blockSize + x, 0 + y, j * blockSize + x, borderHeight + y);
		}

		for (int i = 0; i < mapHeight + 1; ++i) {
			g.drawLine(0 + x, i * blockSize + y, borderWidth + x, i * blockSize + y);
		}

		
	}

	private void drawBrick(Graphics g, int x, int y) {

		for (int j = 0; j < brickSize; ++j) {
			for (int i = 0; i < brickSize; ++i) {
				boolean brickvalue = model.getBrickvalue(i, j);
				if (brickvalue) {

					g.setColor(getColor(model.getScene()));

					g.fillRect((model.getPosX() + i) * blockSize + x,
							(model.getPosY() + j) * blockSize + y, blockSize, blockSize);
				}
			}
		}

	}
	
	private void drawPreview(Graphics g, int x, int y, int scene)
	{
		boolean form[][] = new boolean[brickSize][brickSize];
		final int posX = 500;
		final int posY = 50;
		
		createForm(form, scene);
		
		for (int j = 0; j < brickSize; ++j)
		{
			for (int i = 0; i < brickSize; ++i)
			{
				if (form[i][j])
				{
					g.setColor(getColor(scene));
					g.fillRect( (x + posX) + blockSize * i, (y + posY) + blockSize * j, blockSize, blockSize);
				}
				g.setColor(Color.black);
				g.drawRect( (x + posX) + blockSize * i, (y + posY) + blockSize * j, blockSize, blockSize);
			}
		}
	}
	
	private void drawScore(Graphics g)
	{
		final int posX = 550;
		final int levelPosY = 300;
		final int escPosY = 500;
		final int pPosY = 520;
		final int centerX = 400;
		final int centerY = 300;
		
		g.drawString("Level: " + model.getLevel(), posX, levelPosY);
		g.drawString("Press ESC to exit.", posX, escPosY);
		g.drawString("Press p to pause.", posX, pPosY);
		
		if(model.getState() == 1)
		{
			if(model.isGameOver())
			{
				g.setColor(Color.red);
				g.drawString("GAME OVER!", centerX, centerY);
			}
			else
			{
				g.setColor(Color.red);
				g.drawString("Pause", centerX, centerY);
			}
		}
	}

	private Color getColor(int scene) {
		switch (scene) {
		case 0:
			return Color.red;
		case 1:
			return Color.green;

		case 2:
			return Color.blue;

		case 3:
			return Color.magenta;

		case 4:
			return Color.orange;

		case 5:
			return Color.cyan;

		case 6:
			return Color.pink;

		}
		return null;
	}

	private void createForm(boolean form[][], int scene)
	{
		switch (scene) 
		{
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
			form[1][0] = true;
			form[1][1] = true;
			form[1][2] = true;
			form[0][2] = true;
			break;

		case 5:
			form[1][1] = true;
			form[2][1] = true;
			form[0][2] = true;
			form[1][2] = true;
			break;

		case 6:
			form[1][1] = true;
			form[2][1] = true;
			form[2][2] = true;
			form[3][2] = true;
			break;
		}
	}
}
