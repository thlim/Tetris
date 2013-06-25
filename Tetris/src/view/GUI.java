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
	
	private void drawMap(final Graphics g, final int x, final int y){
		for (int j = 0; j < 18; ++j) {
			for (int i = 0; i < 10; ++i) {
				boolean mapvalue = model.getMapValue(i, j);
				if (mapvalue) {
					g.setColor(Color.red);
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
		

		// DRAWING BORDERS AT THE END
		g.setColor(Color.black);
		g.drawLine(500, 0, 500, 600);

		for (int j = 0; j < 11; ++j) {
			g.drawLine(j * 30 + x, 0 + y, j * 30 + x, 540 + y);
		}

		for (int i = 0; i < 19; ++i) {
			g.drawLine(0 + x, i * 30 + y, 300 + x, i * 30 + y);
		}

		// DRAWING DEBUG RECT
		g.setColor(Color.yellow);
		g.drawRect(model.getPosX() * 30 + x, model.getPosY() * 30 + y, 120, 120);
		// DEBUG MONITOR
		g.setColor(Color.black);
		g.drawString("DEBUG MONITOR:", 600, 50);
		g.drawString(
				"ActiveBrick (" + model.getPosX() + " | " + model.getPosY()
						+ ")", 600, 70);
		g.drawString(
				"most left: " + model.getMostLeftX() + " | "
						+ model.getMostLeftY(), 600, 90);
		g.drawString(
				"most right: " + model.getMostRightX() + " | "
						+ model.getMostRightY(), 600, 110);
		g.drawString(
				"most bottom: " + model.getMostBottomX() + " | "
						+ model.getMostBottomY(), 600, 130);
	}

	private void drawBrick(Graphics g, int x, int y) {
		for (int j = 0; j < 4; ++j) {
			for (int i = 0; i < 4; ++i) {
				boolean brickvalue = model.getBrickvalue(i, j);
				if (brickvalue) {
					switch (model.getScene()) {
					case 0:
						g.setColor(Color.red);
						break;
					case 1:
						g.setColor(Color.green);
						break;
					case 2:
						g.setColor(Color.blue);
						break;
					case 3:
						g.setColor(Color.magenta);
						break;
					case 4:
						g.setColor(Color.orange);
						break;
					case 5:
						g.setColor(Color.cyan);
						break;
					case 6:
						g.setColor(Color.pink);
						break;
					}
					g.fillRect((model.getPosX() + i) * 30 + x,
							(model.getPosY() + j) * 30 + y, 30, 30);
				}
			}
		}
		
	}
}
