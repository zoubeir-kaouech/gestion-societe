package tn.esprit.gui.directeur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EspaceDirecteur extends JFrame {

	private JPanel contentPane;
AddProjet addProjet;
GestionProjet gestionProjet
;
JScrollPane scrollPane ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EspaceDirecteur frame = new EspaceDirecteur();
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
	public EspaceDirecteur() {
		setTitle("Espace Directeur");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu mnGestionProjet = new JMenu("Gestion Projet");
		menuBar.add(mnGestionProjet);
		
		JMenuItem mntmAddProjet = new JMenuItem("Add projet");
		mntmAddProjet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProjet=new AddProjet();
				scrollPane.setViewportView(addProjet);
				
			}
		});
		mnGestionProjet.add(mntmAddProjet);
		
		JMenuItem mntmGestionProjet = new JMenuItem("Gestion Projet");
		mntmGestionProjet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionProjet=new GestionProjet();
				scrollPane.setViewportView(gestionProjet);
			}
		});
		mnGestionProjet.add(mntmGestionProjet);
		
		 scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
