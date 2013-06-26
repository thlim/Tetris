package controller;

import static org.junit.Assert.*;

import java.awt.Robot;
import org.junit.*;

public class TestGame {

	Robot robo;
	Game game;
	Collision coll;

	@Before
	public void setUpBefore() throws Exception {
		game = new Game(false, false);
		coll = Collision.getInstance();

	}

	@Test
	public void testRun() {
		assertFalse(game.run());

	}

	

	@After
	public void afterTest() {
		game = null;
		coll = null;
	}

}
