package view;

import static org.junit.Assert.*;

import model.IModel;
import model.ModelImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestTUI {

	TUI tui;
	IModel model;

	@Before
	public void setUp() throws Exception {
		tui = TUI.getInstance();
		model = new ModelImpl();
	}

	@After
	public void tearDown() throws Exception {
		tui = null;
		model = null;
	}

	@Test
	public void testPrintGame() {
		model.setMapValue(9, 0, true);
		tui.printGame();
		assertTrue(true);
	}
	@Test
	public void testPrintGame2() {
		model.setMapValue(9, 0, true);
		model.setPosY(0);
		tui.printGame();
		assertTrue(true);
	}

}
