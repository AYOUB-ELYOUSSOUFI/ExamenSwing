package com.ismo.brevets.ihm;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.CardLayout;
import javax.swing.JTable;

import com.ismo.brevet.ihm.modelTable.ModelTableInvention;
import com.ismo.brevets.dao.DaoInvention;
import com.ismo.brevets.dao.IDAO;
import com.ismo.brevets.models.Invention;

public class lstInvention extends JInternalFrame {
	private JTable table;
	IDAO<Invention> invention = new DaoInvention();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lstInvention frame = new lstInvention();
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
	public lstInvention() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		table = new JTable();
		table.setModel(new ModelTableInvention(invention.getAll()));
		getContentPane().add(table, "name_592068244326600");

	}

}
