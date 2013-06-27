package controller;

import static org.junit.Assert.*;

import model.Brick;
import model.IModel;
import model.ModelImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCollision {
	
	Collision coll;
	IModel model;

	@Before
	public void setUp() throws Exception {
		coll = null;
		model = null;
		coll = Collision.getInstance();
		model = new ModelImpl();
		model.resetBrick(1);
		coll.resetCollisionAhead();
	}

	@After
	public void tearDown() throws Exception {
		
		coll = null;
		model = null;
	}

	@Test
	public void testCheckBrickCollisionLeftFalse() {
		model.setPosX(-1);
		
		assertFalse(coll.checkBrickCollisionLeft());
	}
	@Test
	public void testCheckBrickCollisionLeftTrue() {
		model.setPosY(18);
		
		assertTrue(coll.checkBrickCollisionLeft());
	}

	@Test
	public void testCheckBrickCollisionRightFalse() {
		model.setPosX(8);
		assertFalse(coll.checkBrickCollisionRight());
	}
	@Test
	public void testCheckBrickCollisionRightTrue() {
		model.setPosY(18);
		assertTrue(coll.checkBrickCollisionRight());
	}

	@Test
	public void testCheckBrickCollisionDownFalse() {
		model.setPosX(1);
		model.setPosY(16);
		assertFalse(coll.checkBrickCollisionDown());
	}
	@Test
	public void testCheckBrickCollisionDownTrue() {
		model.setPosX(10);
		assertTrue(coll.checkBrickCollisionDown());
	}

	@Test
	public void testCheckRotationBounds1() {
		model.resetBrick(0);
		model.setPosX(10);
		coll.checkRotationBounds();
		assertEquals(model.getPosX(), 7);
	}
	@Test
	public void testCheckRotationBounds2() {
		model.resetBrick(0);
		model.setPosX(-4);
		coll.checkRotationBounds();
		assertEquals(model.getPosX(), -1);
	}
	
	@Test
	public void testCheckRotationBounds3() {
		model.setPosY(16);
		coll.checkRotationBounds();
		assertEquals(model.getPosY(), 15);
	}

	

	@Test
	public void testResetCollisionAhead() {
		coll.resetCollisionAhead();
		assertFalse(coll.isCollisionAhead());
	}

}
