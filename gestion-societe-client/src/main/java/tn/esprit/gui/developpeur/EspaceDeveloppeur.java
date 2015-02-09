package tn.esprit.gui.developpeur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class EspaceDeveloppeur extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EspaceDeveloppeur frame = new EspaceDeveloppeur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EspaceDeveloppeur() {
		setTitle("Espace developpeur");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEspaceDeveloppeur = new JLabel("Espace developpeur");
		lblEspaceDeveloppeur.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEspaceDeveloppeur.setBounds(30, 129, 342, 37);
		contentPane.add(lblEspaceDeveloppeur);
	}

}
