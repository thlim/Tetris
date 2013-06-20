package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMap {

	Map map;
	Brick brick;
	
	@Before
	public void setUp() throws Exception {
		map = Map.getInstance();
		brick = Brick.getInstance();
	}

	@Test
	public void testGetInstance() {
		assertNotNull(Map.getInstance());
	}

	@Test
	public void testAddBrick() {
		map.addBrick(brick);
		for(int y = 0; y < 4; ++y)
		{
			for(int x = 0; x < 4; ++x)
			{
				if(brick.get(x,y) == true)
				{
					assertTrue(map.get(4 + x, y));
				}
			}
		}
	}

	@Test
	public void testSet() {
		map.set(0, 0, true);
		assertTrue(map.get(0, 0));
	}

	@Test
	public void testGet() {
		map.set(0, 0, true);
		assertTrue(map.get(0, 0));
	}

}
