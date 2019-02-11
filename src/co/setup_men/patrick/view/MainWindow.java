package co.setup_men.patrick.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import co.setup_men.patrick.controller.KeyController;

public class MainWindow extends JFrame {
	
	private GamePanel gamePanel;
	
	public MainWindow() {
		this.gamePanel = new GamePanel();
		this.init();
	}
	
	private void init() {
		this.setTitle("Patrick Bob: Hooded Mission");
		this.setSize(700, 600);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.add(this.gamePanel);		
		this.addKeyListener(KeyController.getInstance());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
