package com.ismo.brevets.ihm;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;

import com.ismo.brevet.ihm.modelTable.ModelTabbleDomaine;
import com.ismo.brevets.dao.DaoDomaine;
import com.ismo.brevets.dao.IDAO;
import com.ismo.brevets.models.Domaine;

import java.awt.CardLayout;

public class lstDomaine extends JInternalFrame {
	private JTable table;
	IDAO<Domaine> domaine = new DaoDomaine();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lstDomaine frame = new lstDomaine();
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
	public lstDomaine() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		table = new JTable();
		table.setModel(new ModelTabbleDomaine(domaine.getAll()));
		getContentPane().add(table, "name_589989230199800");

	}
}
