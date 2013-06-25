package view;

import javax.swing.JFrame;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	private int windowWidth = 800;
	private int windowHeight = 600;

	public MainWindow() {
		setSize(windowWidth, windowHeight);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}