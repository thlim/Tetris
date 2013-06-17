package view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

import model.Map;
import model.Brick;

public class GUI extends Frame
{
	private static final long serialVersionUID = 1L;
	private static GUI instance = null;
	Map 	map;
	Brick 	activeBrick;
	
	public static GUI getInstance()
	{
		if(instance == null)
		{
			return instance = new GUI();
		}
		return instance;
	}
	
	private GUI()
	{
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
		
		// DRAWING DEBUG RECT
		g.setColor(Color.yellow);
		g.drawRect(activeBrick.posX * 30 + x, activeBrick.posY * 30 + y, 120, 120);
		// DEBUG MONITOR
		g.setColor(Color.black);
		g.drawString("DEBUG MONITOR:", 600, 50);
		g.drawString("ActiveBrick (" + activeBrick.posX + " | " + activeBrick.posY + ")", 600, 70);
		g.drawString("most left: " + activeBrick.mostLeftX + " | " + activeBrick.mostLeftY, 600, 90);
		g.drawString("most right: " + activeBrick.mostRightX + " | " + activeBrick.mostRightY, 600, 110);
		g.drawString("most bottom: " + activeBrick.mostBottomX + " | " + activeBrick.mostBottomY, 600, 130);
	}
}
