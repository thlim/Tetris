package model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestModelImpl {

	static ModelImpl model;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		model = new ModelImpl();
	}

	@Test
	public void testGetBrickvalue() {
		assertNotNull(model.getBrickvalue(0, 0));

	}

	@Test
	public void testResetBrick() {
		model.resetBrick(0);
		assertEquals(model.getScene(), 0);
		model.resetBrick(1);
		assertEquals(model.getScene(), 1);
		model.resetBrick(2);
		assertEquals(model.getScene(), 2);
		model.resetBrick(3);
		assertEquals(model.getScene(), 3);
		model.resetBrick(4);
		assertEquals(model.getScene(), 4);
		model.resetBrick(5);
		assertEquals(model.getScene(), 5);
		model.resetBrick(6);
		assertEquals(model.getScene(), 6);
	}

	@Test
	public void testTurn() {
		model.turnBrick();
		assertNotNull(model.getBrickvalue(0, 0));
	}

	@Test
	public void setTest() {
		int expect = 4;
		model.setPosX(expect);
		model.setPosY(expect);
		assertEquals(expect, model.getPosX());
		assertEquals(expect, model.getPosY());
	}

	@Test
	public void testAddBrick() {
		model.addBrick();
		for (int y = 0; y < 4; ++y) {
			for (int x = 0; x < 4; ++x) {
				if (model.getBrickvalue(x, y) == true) {
					assertTrue(true);
				}
			}
		}
	}

	@Test
	public void testSet() {
		model.setMapValue(0, 0, true);
		assertTrue(model.getMapValue(0, 0));
	}
	
	@Test
	public void testMapColor(){
		assertEquals(model.getMapColor(0, 0), -1);
	}
	
	@Test
	public void testLineCount(){
		model.resetLineCount();
		assertEquals(model.getLineCount(), 0);
	}
	
	@Test
	public void testGetNextForm() {
		assertNotNull(model.getNextForm());
	}
	
	@Test
	public void testValitate(){
		model.resetBrick(0);
		assertTrue(model.valitateBrick(model.getNextForm(), model.getPosX(), model.getPosY()));
	}

	@Test
	public void testValitateFalse(){
		model.resetBrick(0);
		model.setMapValue(2, 2, true);
		assertFalse(model.valitateBrick(model.getNextForm(), 1, 1));
	}
}
