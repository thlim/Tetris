package view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Map;
import model.Brick;

public class GUI extends Frame implements KeyListener
{
	private static final long serialVersionUID = 1L;
	Map 	map;
	Brick 	activeBrick;
	
	public GUI()
	{
		addKeyListener(this);
		map = Map.getInstance();
		activeBrick = Brick.getInstance();
		setSize(800, 600);
		setLocation(0, 0);
		setResizable(false);
		setTitle("Tetris");
		setBackground(Color.white);
		setVisible(true);
	}
	
	@Override
	public void paint(Graphics g)
	{
		int x = 100;
		int y = 40;
		
		/*for(int j = 0; j < 10; ++ j)
		{
			for(int i = 0; i < 18; ++i)
			{
				if(Math.random() < 0.5)
				{
					g.setColor(Color.red);
				}
				else
				{
					g.setColor(Color.green);
				}
				g.fillRect(j * 30 + x, i * 30 + y, 30, 30);
			}
		}*/
		
		// DRAWING MAP
		for(int j = 0; j < 18; ++j)
		{
			for(int i = 0; i < 10; ++i)
			{
				if(map.get(i,  j) == true)
				{
					g.setColor(Color.red);
					g.fillRect(i * 30 + x, j * 30 + y, 30, 30);
				}
			}
		}
		
		// DRAWING ACTIVE BRICK
		for(int j = 0; j < 4; ++j)
		{
			for(int i = 0; i < 4; ++i)
			{
				if(activeBrick.form[i][j] == true)
				{
					switch(activeBrick.scene)
					{
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
					g.fillRect((activeBrick.posX + i) * 30 + x, (activeBrick.posY + j) * 30 + y, 30, 30);
				}
			}
		}
		
		// DRAWING BORDERS AT THE END
		g.setColor(Color.black);
		g.drawLine(500, 0, 500, 600);
		
		for(int j = 0; j < 11; ++j)
		{
			g.drawLine(j * 30 + x, 0 + y, j * 30 + x, 540 + y);
		}
		
		for(int i = 0; i < 19; ++i)
		{
			g.drawLine(0 + x, i * 30 + y, 300 + x, i * 30 + y);
		}
	}

	@Override
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
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
