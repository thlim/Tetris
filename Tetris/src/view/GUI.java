package view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

public class GUI extends Frame
{
	private static final long serialVersionUID = 1L;

	public GUI()
	{
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
}
