package view;

import java.awt.Graphics;

public class ViewImpl implements IView {

	@Override
	public GUI getGui() {
		// TODO Auto-generated method stub
		return GUI.getInstance();
	}

	@Override
	public void updateView(Graphics g) {
		// TODO Auto-generated method stub
		GUI.getInstance().paint(g);
	}

}
