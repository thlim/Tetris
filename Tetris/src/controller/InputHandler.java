package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.google.inject.Guice;
import com.google.inject.Injector;

import view.GUI;

import model.IModel;
import model.Map;
import model.Brick;
import model.ModelImpl;

public class InputHandler implements KeyListener
{
	private static InputHandler instance = null;
	//private Map map;
	//private Brick activeBrick;
	private IModel model;
	
	public static InputHandler getInstance()
	{
		if(instance == null)
		{
			return instance = new InputHandler();
		}
		return instance;
	}
	
	private InputHandler()
	{
		Injector injector = Guice.createInjector();
		model = injector.getInstance(IModel.class);
		//map = Map.getInstance();
		//activeBrick = Brick.getInstance();
	}

	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
		case 27:
			System.exit(0);
			break;
		case 37:
			model.setPosX(model.getPosX() -1);
			//--activeBrick.posX;
			break;
		case 39:
			model.setPosX(model.getPosX() +1);
			//++activeBrick.posX;
			break;
		case 40:
			//++activeBrick.posY;
			model.setPosY(model.getPosY() +1);
			break;
		case 38:
			//activeBrick.turn();
			model.turnBrick();
			break;
		}
		GUI.getInstance().repaint();
		//System.out.println(e.getKeyCode());	
	}

	public void keyReleased(KeyEvent e)
	{
	}

	public void keyTyped(KeyEvent arg0)
	{
	}
}