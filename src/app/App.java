package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import interfaces_graficas.Alta_Propietario;

public class App extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		JFrame app = new App();
		
		
		JPanel panel1 = new Alta_Propietario(app);
		
		app.setContentPane(panel1);
		app.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		app.setSize(1040, 800);
		app.setResizable(false);
		app.setLocationRelativeTo(null);
		app.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public App() {

	}


}
