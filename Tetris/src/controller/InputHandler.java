package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.GUI;

import model.Map;
import model.Brick;

public class InputHandler implements KeyListener
{
	private static InputHandler instance = null;
	private Map map;
	private Brick activeBrick;
	
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
		map = Map.getInstance();
		activeBrick = Brick.getInstance();
	}

	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
		case 27:
			System.exit(0);
			break;
		case 37:
			--activeBrick.posX;
			break;
		case 39:
			++activeBrick.posX;
			break;
		case 40:
			++activeBrick.posY;
			break;
		case 38:
			activeBrick.turn();
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