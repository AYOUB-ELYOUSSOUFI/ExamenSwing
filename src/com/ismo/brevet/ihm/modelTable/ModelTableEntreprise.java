package com.ismo.brevet.ihm.modelTable;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.ismo.brevets.models.Entreprise;

public class ModelTableEntreprise extends AbstractTableModel{
	
	String[] cols = {"Numero","Raison Social","Activite","CA","Ville"};
	List<Entreprise> entreprises;

	public ModelTableEntreprise(List<Entreprise> entreprises) {
		super();
		this.entreprises = entreprises;
	}
	
	@Override
	public int getRowCount() {
		return entreprises.size();
	}

	@Override
	public int getColumnCount() {
		return cols.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return cols[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Entreprise e = entreprises.get(rowIndex);
		switch(columnIndex) {
		case 0:return e.getNum();
		case 1:return e.getNom();
		case 2:return e.getActivite();
		case 3:return e.getCa();
		case 4:return e.getVille();
		}
		return null;
	}

}
