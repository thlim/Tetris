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
		game = new Game();
		coll = Collision.getInstance();

	}

	@Test
	public void testRun() {
		assertFalse(game.run());

	}

	@Test
	public void testRun2() {
		game.level = -1;
		assertFalse(game.run());
	}

	@Test
	public void testRun3() {
		game.level = -1;
		coll.collisionAhead = true;
		assertFalse(game.run());
	}

	@After
	public void afterTest() {
		game = null;
		coll = null;
	}

}
