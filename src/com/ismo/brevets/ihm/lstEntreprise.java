package com.ismo.brevets.ihm;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;

import com.ismo.brevet.ihm.modelTable.ModelTableBrevet;
import com.ismo.brevet.ihm.modelTable.ModelTableEntreprise;
import com.ismo.brevets.dao.DAO;
import com.ismo.brevets.dao.DaoFactory;
import com.ismo.brevets.dao.IDAO;
import com.ismo.brevets.metier.IMetier;
import com.ismo.brevets.metier.METIER;
import com.ismo.brevets.metier.MetierFactory;
import com.ismo.brevets.models.Brevet;
import com.ismo.brevets.models.Entreprise;

public class lstEntreprise extends JInternalFrame {
	private JTable table;
	IMetier<Entreprise> entreprises = MetierFactory.getMetier(METIER.ENTREPRISE);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lstEntreprise frame = new lstEntreprise();
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
	public lstEntreprise() {
		setBounds(100, 100, 616, 400);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		table = new JTable();
		table.setModel(new ModelTableEntreprise(entreprises.getAll()));
		getContentPane().add(table, "name_589325278144900");
	}

}
