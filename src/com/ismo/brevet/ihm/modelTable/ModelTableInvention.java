package com.ismo.brevet.ihm.modelTable;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.ismo.brevets.models.Invention;

public class ModelTableInvention extends AbstractTableModel {

	String cols[] = {"Numero","DESCRIPTIF","RESUME","DOMAINE"};
	List<Invention> inventions;
	
	public ModelTableInvention(List<Invention> inventions) {
		super();
		this.inventions = inventions;
	}

	@Override
	public int getRowCount() {
		return inventions.size();
	}

	@Override
	public int getColumnCount() {		
		return cols.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Invention v = inventions.get(rowIndex);
		switch(columnIndex) {
		case 0: return v.getNum();
		case 1: return v.getDescriptif();
		case 2: return v.getResume();
		case 3: return v.getDomaine().getNom();
		}
		return null;
	}

}
