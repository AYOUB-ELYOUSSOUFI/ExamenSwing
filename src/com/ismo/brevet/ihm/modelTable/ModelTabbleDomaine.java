package com.ismo.brevet.ihm.modelTable;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.ismo.brevets.models.Brevet;
import com.ismo.brevets.models.Domaine;

public class ModelTabbleDomaine extends AbstractTableModel{
	
	String[] cols = {"Numero","Nom"};
	List<Domaine> domaines;
	
	
	public ModelTabbleDomaine(List<Domaine> domaines) {
		super();
		this.domaines = domaines;
	}

	@Override
	public int getRowCount() {
		return domaines.size();
	}

	@Override
	public int getColumnCount() {
		return cols.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Domaine d = domaines.get(rowIndex);
		switch(columnIndex) {
		case 0:return d.getNum();
		case 1:return d.getNom();
		}
		return null;
	}

}
