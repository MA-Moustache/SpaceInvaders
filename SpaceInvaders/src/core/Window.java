package core;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Window extends JFrame{
	
	public Window(int x, int y)
	{
		// JFrame
		this.setTitle("Space Invaders");
		this.setSize(x, y);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		// JPanel
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(x, y));
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		// JTEXT
		JTextArea textArea = new JTextArea(5, 20);
		textArea.append("TEST");
		panel.add(textArea);
		// Ajout JPanel au JFrame

		
	    this.setContentPane(panel);
	    //this.pack();
	    this.setVisible(true);
		
	}

}
