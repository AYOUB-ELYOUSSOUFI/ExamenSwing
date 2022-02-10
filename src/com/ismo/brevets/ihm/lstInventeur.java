package com.ismo.brevets.ihm;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.CardLayout;
import javax.swing.JTable;

import com.ismo.brevet.ihm.modelTable.ModelTableInventeur;
import com.ismo.brevets.dao.DaoInventeur;
import com.ismo.brevets.dao.IDAO;
import com.ismo.brevets.models.Inventeur;

public class lstInventeur extends JInternalFrame {
	private JTable table;
	IDAO<Inventeur> inventeur = new DaoInventeur();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lstInventeur frame = new lstInventeur();
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
	public lstInventeur() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		table = new JTable();
		table.setModel(new ModelTableInventeur(inventeur.getAll()));
		getContentPane().add(table, "name_591639974260300");

	}

}
