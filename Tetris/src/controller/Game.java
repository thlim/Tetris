package controller;

import model.IModel;
import view.IView;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Game {

	private long timer;
	private long time;
	private byte state;
	private IModel model;
	private IView view;
	private Collision coll;
	private boolean consoleFlag;
	private boolean consoleOnlyFlag;

	public Game(boolean console, boolean consoleOnly) {
		Injector injector = Guice.createInjector();
		model = injector.getInstance(IModel.class);

		coll = Collision.getInstance();
		view = injector.getInstance(IView.class);
		view.getGui().addKeyListener(InputHandler.getInstance());
		timer = 0;
		time = 0;
		state = 0;
		
		consoleFlag = console;
		consoleOnlyFlag = consoleOnly;
		if (consoleFlag) {
			// TODO CONSOLE AKTIVIEREN
		}
		if (consoleOnlyFlag) {
			// TODO CONSOLE AKTIVIEREN UND GUI DEAKTIVIEREN
		}

	}

	private void update(long time) {

		if (time >= 1000 / model.getLevel()) {

			if (coll.isCollisionAhead()) {
				model.addBrick();
				coll.resetCollisionAhead();
				model.resetBrick(model.getNextScene());
			} else {
				if (coll.checkBrickCollisionDown()) {
					model.setPosY(model.getPosY() + 1);
				}
			}
		}
	}

	public boolean run() {

		timer = System.currentTimeMillis();
		
		switch (state) {
		case 0:
			update(time);
			if (time >= 1000 / model.getLevel()) {
				
				view.update();

				time = 0;
			}
			break;
		// case 1:
		// update(time);
		// break;
		}
		time += System.currentTimeMillis() - timer;

		return InputHandler.getInstance().isExit();
	}
}