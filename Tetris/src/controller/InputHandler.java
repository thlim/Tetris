package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.IModel;
import view.IView;

import com.google.inject.Guice;
import com.google.inject.Injector;

public final class InputHandler implements KeyListener
{
	private static InputHandler instance = null;
	
	private IModel model;
	private IView view;
	public boolean exit;
	private Collision coll;
	
	
	public static InputHandler getInstance()
	{
		if(instance == null)
		{
			instance = new InputHandler();
			return instance;
		}
		return instance;
	}
	
	private InputHandler()
	{
		Injector injector = Guice.createInjector();
		model = injector.getInstance(IModel.class);
		view = injector.getInstance(IView.class);
		coll = Collision.getInstance();
	}

	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
		case 27:
			exit = true;
			break;
		case 37:
			model.setPosX(model.getPosX() -1);
			coll.checkBrickCollision();
			coll.getDistances();
			break;
		case 39:
			model.setPosX(model.getPosX() +1);
			coll.checkBrickCollision();
			coll.getDistances();
			break;
		case 40:
			model.setPosY(model.getPosY() +1);
			coll.checkBrickCollision();
			coll.getDistances();
			break;
		case 38:
			model.turnBrick();
			coll.checkBrickCollision();
			coll.getDistances();
			break;
		}
		if(coll.isCollisionAhead()){
			model.addBrick();
			
			model.resetBrick((int)(Math.random() * 7));
		}
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

	
}