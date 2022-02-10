package com.ismo.brevets.ihm;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.SingleSelectionModel;

import com.ismo.brevet.ihm.modelTable.ModelTableBrevet;
import com.ismo.brevet.ihm.modelTable.ModelTableEntreprise;
import com.ismo.brevets.dao.DAO;
import com.ismo.brevets.dao.DaoBrevet;
import com.ismo.brevets.dao.DaoFactory;
import com.ismo.brevets.dao.IDAO;
import com.ismo.brevets.metier.IMetier;
import com.ismo.brevets.metier.MetierFactory;
import com.ismo.brevets.models.Brevet;
import com.ismo.brevets.models.Entreprise;
import javax.swing.JTable;
import java.awt.CardLayout;

public class lstBrevets extends JInternalFrame {
	private JTable table;
	IDAO<Brevet> brevet = new DaoBrevet();
	//private IMetier<Brevet> brevet = MetierFactory
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lstBrevets frame = new lstBrevets();
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
	public lstBrevets() {
		setBounds(100, 100, 774, 473);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		table = new JTable();
		table.setModel(new ModelTableBrevet(brevet.getAll()));
		getContentPane().add(table, "name_58657017198700");

	}
}
