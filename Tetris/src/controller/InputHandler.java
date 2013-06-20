package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.IModel;
import view.GUI;

import com.google.inject.Guice;
import com.google.inject.Injector;

public final class InputHandler implements KeyListener
{
	private static InputHandler instance = null;
	
	private IModel model;
	
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
			
			break;
		case 39:
			model.setPosX(model.getPosX() +1);
			
			break;
		case 40:
			model.setPosY(model.getPosY() +1);
			break;
		case 38:
			model.turnBrick();
			break;
		}
		GUI.getInstance().repaint();
		
	}

	public void keyReleased(KeyEvent e)
	{
	}

	public void keyTyped(KeyEvent arg0)
	{
	}
}