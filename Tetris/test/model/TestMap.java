package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMap {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetInstance() {
		assertNotNull(Map.getInstance());
	}

	@Test
	public void testAddBrick() {
		Map.getInstance().addBrick(Brick.getInstance());
		for(int y = 0; y < 4; ++y)
		{
			for(int x = 0; x < 4; ++x)
			{
				if(Brick.getInstance().get(x,y) == true)
				{
					assertTrue(Map.getInstance().get(4 + x, y));
				}
			}
		}
	}

	@Test
	public void testSet() {
		Map.getInstance().set(0, 0, true);
		assertTrue(Map.getInstance().get(0, 0));
	}

	@Test
	public void testGet() {
		Map.getInstance().set(0, 0, true);
		assertTrue(Map.getInstance().get(0, 0));
	}

}
