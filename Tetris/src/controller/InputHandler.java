package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.IModel;
import view.IView;

import com.google.inject.Guice;
import com.google.inject.Injector;

public final class InputHandler implements KeyListener {
	private static InputHandler instance = null;

	private IModel model;
	private IView view;
	private boolean exit;
	private Collision coll;
	private static final int ESC = 27;
	private static final int LEFT = 37;
	private static final int RIGHT = 39;
	private static final int DOWN = 40;
	private static final int UP = 38;
	private static final int P = 80;

	public static InputHandler getInstance() {
		if (instance == null) {
			instance = new InputHandler();
			return instance;
		}
		return instance;
	}

	private InputHandler() {
		Injector injector = Guice.createInjector();
		model = injector.getInstance(IModel.class);
		view = injector.getInstance(IView.class);
		coll = Collision.getInstance();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case ESC:
			exit = true;
			break;
		case LEFT:
			if (coll.checkBrickCollisionLeft() && model.getState() == 0) {
				model.setPosX(model.getPosX() - 1);
			}
			break;
		case RIGHT:
			if (coll.checkBrickCollisionRight() && model.getState() == 0) {
				model.setPosX(model.getPosX() + 1);
			}
			break;
		case DOWN:
			if (model.getState() == 0) {
				if (coll.checkBrickCollisionDown()) {
					model.setPosY(model.getPosY() + 1);
				} else {
					model.addBrick();
					coll.resetCollisionAhead();
					model.resetBrick(model.getNextScene());
				}
			}
			break;
		case UP:
			if (model.valitateBrick(model.getNextForm(), model.getPosX(),
					model.getPosY())
					&& model.getState() == 0) {
				model.turnBrick();
				coll.checkRotationBounds();
			}
			break;
		case P:
			model.togglePause();
			break;
		}
		coll.resetCollisionAhead();
		view.update();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the exit
	 */
	public boolean isExit() {
		return exit;
	}

}