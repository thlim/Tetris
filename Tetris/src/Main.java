/*
 * 	Tetris
 * 	Softwaretechnik WS 12/13
 * 
 * @Author: Thomas Lim
 * 			Andreas Hummelsberger
 * 
 * Main.java
 */
import controller.Game;

class Main
{
	public static void main(String[] args)
	{
		Game g = new Game();
		g.init();
		g.run();
	}
}