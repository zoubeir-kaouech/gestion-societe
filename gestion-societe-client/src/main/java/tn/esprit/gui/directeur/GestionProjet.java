package tn.esprit.gui.directeur;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import tn.esprit.delegate.GestionProjetDelegate;
import tn.esprit.domain.Projet;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestionProjet extends JPanel {
	private JTable table;
	List<Projet> projets;

	/**
	 * Create the panel.
	 */
	public GestionProjet() {
		projets=new ArrayList<Projet>();
		projets=GestionProjetDelegate.doFindAllProjets();
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 23, 430, 266);
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(94, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(projets.get(table.getSelectedRow()).getName());
			}
		});
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		initDataBindings();

	}

	protected void initDataBindings() {
		JTableBinding<Projet, List<Projet>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, projets, table);
		//
		BeanProperty<Projet, Integer> projetBeanProperty = BeanProperty.create("id");
		jTableBinding.addColumnBinding(projetBeanProperty).setColumnName("Id");
		//
		BeanProperty<Projet, String> projetBeanProperty_1 = BeanProperty.create("name");
		jTableBinding.addColumnBinding(projetBeanProperty_1).setColumnName("Name");
		//
		jTableBinding.bind();
	}
}
