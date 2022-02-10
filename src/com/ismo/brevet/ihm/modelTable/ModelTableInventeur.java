package com.ismo.brevet.ihm.modelTable;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.ismo.brevets.models.Inventeur;

public class ModelTableInventeur extends AbstractTableModel{

	String[] cols = {"Numero","Nom","PRENOM","ADDRESS","DATE DE NAISSANCE","ENTREPRISE"};
	List<Inventeur> inventeurs;
	
	public ModelTableInventeur(List<Inventeur> inventeurs) {
		super();
		this.inventeurs = inventeurs;
	}

	@Override
	public int getRowCount() {
		return inventeurs.size();
	}

	@Override
	public int getColumnCount() {
		return cols.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Inventeur v = inventeurs.get(rowIndex);
		switch(columnIndex) {
		case 0: return v.getNum();
		case 1: return v.getNom();
		case 2: return v.getPrenom();
		case 3: return v.getAdresse();
		case 4: return v.getDate_nais();
		case 5: return v.getEntreprise().getNom();
		}
		return null;
	}

}
