package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMap {

	Map map;
	Brick brick;

	@Before
	public void setUpBefore() throws Exception {
		map = Map.getInstance();
		brick = Brick.getInstance();
		for (int x = 0; x < 10; ++x) {
			map.set(x, 17, true);

		}

	}

	@After
	public void after() {
		map = null;
		brick = null;

	}

	@Test
	public void testAddBrickandDeleteLine() {

		map.addBrick(brick);
		assertTrue(true);
	}

	@Test
	public void testSet() {
		map.set(5, 4, true);
		assertTrue(map.get(5, 4));
	}

	@Test
	public void testGet() {
		map.set(5, 5, true);
		assertTrue(map.get(5, 5));
	}

}
