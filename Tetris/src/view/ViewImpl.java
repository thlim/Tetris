/**
 * 
 */
package view;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import controller.InputHandler;

/**
 * @author Bombilla
 *
 */
@Singleton
public class ViewImpl implements IView {

	GUI gui;
	TUI tui;
	/**
	 * 
	 */
	@Inject
	public ViewImpl() {
		gui = GUI.getInstance();
		//gui.addKeyListener(InputHandler.getInstance());
		tui = TUI.getInstance();
	}

	/* (non-Javadoc)
	 * @see view.IView#update()
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub
		gui.repaint();
	}
	
	public GUI getGui(){
		return gui;
	}

}
