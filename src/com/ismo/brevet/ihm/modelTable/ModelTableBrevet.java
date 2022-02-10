package com.ismo.brevet.ihm.modelTable;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.ismo.brevets.models.Brevet;

public class ModelTableBrevet extends AbstractTableModel{

	String[] cols = {"Numero","Description","Date de depot","Date de Validation","Invention","Inventeur"};
	List<Brevet> brevets;
	
	public ModelTableBrevet(List<Brevet> brevets) {
		super();
		this.brevets = brevets;
	}

	@Override
	public int getRowCount() {
		return brevets.size();
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
		Brevet b = brevets.get(rowIndex);
		switch(columnIndex) {
		case 0:return b.getNum();
		case 1:return b.getDescription();
		case 2:return b.getDateDepot();
		case 3:return b.getDateValidation();
		case 4:return b.getInventeur().getNom();
		case 5:return b.getInvention().getDescriptif();
		}
		return null;
	}

}
