package tn.esprit.gui.directeur;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import tn.esprit.delegate.GestionProjetDelegate;
import tn.esprit.domain.Projet;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

public class AddProjet extends JPanel {
	private JTextField nameProjet;

	/**
	 * Create the panel.
	 */
	public AddProjet() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Add projet", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(26, 32, 400, 190);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 81, 46, 14);
		panel.add(lblName);
		
		nameProjet = new JTextField();
		nameProjet.setBounds(94, 78, 190, 20);
		panel.add(nameProjet);
		nameProjet.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Projet projet=new Projet();
				projet.setName(nameProjet.getText());
				projet.setDateCreation(new Date());
				GestionProjetDelegate.doAddProjet(projet);
				nameProjet.setText("");
			}
		});
		btnAdd.setBounds(137, 129, 89, 23);
		panel.add(btnAdd);

	}
}
