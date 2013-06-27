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

		setSize(800, 600);
		setLocation(0, 0);
		setResizable(false);
		setTitle("Tetris");
		setBackground(Color.white);
		setVisible(true);
	}

	private void drawMap(final Graphics g, final int x, final int y) {
		for (int j = 0; j < 18; ++j) {
			for (int i = 0; i < 10; ++i) {
				boolean mapvalue = model.getMapValue(i, j);
				if (mapvalue) {

					g.setColor(getColor(model.getMapColor(i, j)));
					g.fillRect(i * 30 + x, j * 30 + y, 30, 30);
				}
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		int x = 100;
		int y = 40;

		drawMap(g, x, y);
		drawBrick(g, x, y);
		drawPreview(g, x, y, model.getNextScene());

		// DRAWING BORDERS AT THE END
		g.setColor(Color.black);
		g.drawLine(500, 0, 500, 600);

		for (int j = 0; j < 11; ++j) {
			g.drawLine(j * 30 + x, 0 + y, j * 30 + x, 540 + y);
		}

		for (int i = 0; i < 19; ++i) {
			g.drawLine(0 + x, i * 30 + y, 300 + x, i * 30 + y);
		}

		
	}

	private void drawBrick(Graphics g, int x, int y) {
		for (int j = 0; j < 4; ++j) {
			for (int i = 0; i < 4; ++i) {
				boolean brickvalue = model.getBrickvalue(i, j);
				if (brickvalue) {

					g.setColor(getColor(model.getScene()));

					g.fillRect((model.getPosX() + i) * 30 + x,
							(model.getPosY() + j) * 30 + y, 30, 30);
				}
			}
		}

	}
	
	private void drawPreview(Graphics g, int x, int y, int scene)
	{
		boolean form[][] = new boolean[4][4];
		
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
		for (int j = 0; j < 4; ++j)
		{
			for (int i = 0; i < 4; ++i)
			{
				if (form[i][j])
				{
					g.setColor(getColor(scene));
					g.fillRect( (x + 500) + 30 * i, (y + 50) + 30 * j, 30, 30);
				}
				g.setColor(Color.black);
				g.drawRect( (x + 500) + 30 * i, (y + 50) + 30 * j, 30, 30);
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

}
