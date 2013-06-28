package controller;

import model.IModel;
import view.IView;

import com.google.inject.Guice;
import com.google.inject.Injector;

public final class Game {

	private long timer;
	private long time;
	private IModel model;
	private IView view;
	private Collision coll;
	private static Game instance = null;
	private static final int MULTI = 1000;
	
	public static Game getInstance() {
		if (instance == null) {
			instance = new Game();
			return instance;
		}
		return instance;
	}
	
	private Game() {
		Injector injector = Guice.createInjector();
		model = injector.getInstance(IModel.class);

		coll = Collision.getInstance();
		view = injector.getInstance(IView.class);
		view.getGui().addKeyListener(InputHandler.getInstance());
		timer = 0;
		time = 0;
		

	}

	private void update(long time) {

		if (time >= MULTI / model.getLevel()) {

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
		
		switch (model.getState()) {
		case 0:
			update(time);
			if (time >= MULTI / model.getLevel()) {
				
				view.update();

				time = 0;
			}
			break;
		case 1:
			break;
		}
		time += System.currentTimeMillis() - timer;

		return InputHandler.getInstance().isExit();
	}
}