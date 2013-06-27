/**
 * 
 */
package view;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Bombilla
 * 
 */
@Singleton
public class ViewImpl implements IView {

	private GUI gui;
	private TUI tui;

	/**
	 * 
	 */
	@Inject
	public ViewImpl() {
		gui = GUI.getInstance();

		tui = TUI.getInstance();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.IView#update()
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub
		gui.repaint();
		//tui.printGame();
	}

	@Override
	public GUI getGui() {
		return gui;
	}

}
