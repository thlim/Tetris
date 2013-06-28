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

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final int LOCATION = 0;
	private static final int MAPWIDTH = 10;
	private static final int MAP_HEIGHT = 18;
	private static final int BLOCK_SIZE = 30;
	private static final int BRICK_SIZE = 4;
	
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

		setSize(WIDTH, HEIGHT);
		setLocation(LOCATION, LOCATION);
		setResizable(false);
		setTitle("Tetris");
		setBackground(Color.white);
		setVisible(true);
	}

	private void drawMap(final Graphics g, final int x, final int y) {
		for (int j = 0; j < MAP_HEIGHT; ++j) {
			for (int i = 0; i < MAPWIDTH; ++i) {
				boolean mapvalue = model.getMapValue(i, j);
				if (mapvalue) {

					g.setColor(getColor(model.getMapColor(i, j)));
					g.fillRect(i * BLOCK_SIZE + x, j * BLOCK_SIZE + y, BLOCK_SIZE, BLOCK_SIZE);
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

		for (int j = 0; j < MAPWIDTH + 1; ++j) {
			g.drawLine(j * BLOCK_SIZE + x, 0 + y, j * BLOCK_SIZE + x, borderHeight + y);
		}

		for (int i = 0; i < MAP_HEIGHT + 1; ++i) {
			g.drawLine(0 + x, i * BLOCK_SIZE + y, borderWidth + x, i * BLOCK_SIZE + y);
		}

		
	}

	private void drawBrick(Graphics g, int x, int y) {

		for (int j = 0; j < BRICK_SIZE; ++j) {
			for (int i = 0; i < BRICK_SIZE; ++i) {
				boolean brickvalue = model.getBrickvalue(i, j);
				if (brickvalue) {

					g.setColor(getColor(model.getScene()));

					g.fillRect((model.getPosX() + i) * BLOCK_SIZE + x,
							(model.getPosY() + j) * BLOCK_SIZE + y, BLOCK_SIZE, BLOCK_SIZE);
				}
			}
		}

	}
	
	private void drawPreview(Graphics g, int x, int y, int scene)
	{
		boolean form[][] = new boolean[BRICK_SIZE][BRICK_SIZE];
		final int posX = 500;
		final int posY = 50;
		
		createForm(form, scene);
		
		for (int j = 0; j < BRICK_SIZE; ++j)
		{
			for (int i = 0; i < BRICK_SIZE; ++i)
			{
				if (form[i][j])
				{
					g.setColor(getColor(scene));
					g.fillRect( (x + posX) + BLOCK_SIZE * i, (y + posY) + BLOCK_SIZE * j, BLOCK_SIZE, BLOCK_SIZE);
				}
				g.setColor(Color.black);
				g.drawRect( (x + posX) + BLOCK_SIZE * i, (y + posY) + BLOCK_SIZE * j, BLOCK_SIZE, BLOCK_SIZE);
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
