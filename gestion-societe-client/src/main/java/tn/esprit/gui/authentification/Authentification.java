package tn.esprit.gui.authentification;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;

import tn.esprit.delegate.GestionEmployeeDelagate;
import tn.esprit.domain.Developpeur;
import tn.esprit.domain.Directeur;
import tn.esprit.domain.Employee;
import tn.esprit.gui.commercial.EspaceCommercial;
import tn.esprit.gui.developpeur.EspaceDeveloppeur;
import tn.esprit.gui.directeur.EspaceDirecteur;
import tn.esprit.services.gestion.employee.GestionEmployeeRemote;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Authentification extends JFrame {

	private JPanel contentPane;
	private JTextField login;
	private JTextField pwd;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification frame = new Authentification();
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
	public Authentification() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAuthentification = new JLabel("Authentification");
		lblAuthentification.setFont(new Font("Times New Roman", Font.ITALIC, 50));
		lblAuthentification.setBounds(56, 28, 350, 45);
		contentPane.add(lblAuthentification);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(42, 84, 364, 116);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(21, 23, 46, 14);
		panel.add(lblLogin);
		
		JLabel lblPwd = new JLabel("pwd");
		lblPwd.setBounds(21, 60, 46, 14);
		panel.add(lblPwd);
		
		login = new JTextField();
		login.setBounds(107, 20, 185, 20);
		panel.add(login);
		login.setColumns(10);
		
		pwd = new JTextField();
		pwd.setBounds(107, 57, 185, 20);
		panel.add(pwd);
		pwd.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee employee=GestionEmployeeDelagate.doAuthentificate(login.getText(), pwd.getText());
				if(employee!=null){
					
					
					if(employee instanceof Developpeur){
						EspaceDeveloppeur developpeur=new EspaceDeveloppeur();
						developpeur.setVisible(true);
					}
					else 
						if(employee instanceof Directeur){
							new EspaceDirecteur().setVisible(true);
						}
						else 
							new EspaceCommercial().setVisible(true);
				}
				
			}
		});
		btnLogin.setBounds(129, 88, 89, 23);
		panel.add(btnLogin);
	}
}
