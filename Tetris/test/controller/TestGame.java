package controller;

import static org.junit.Assert.*;

import java.awt.Robot;
import model.Brick;

import org.junit.*;

public class TestGame {

	Robot robo;
	Game game;
	Brick brick;
	
	@Before
	public void setUpBefore() throws Exception {
		game = new Game();
		
	}

	@Test
	public void testGame() {
		assertNotNull(game);
	}

	
	

	



}
