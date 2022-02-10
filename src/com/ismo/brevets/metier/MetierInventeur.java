package com.ismo.brevets.metier;

import java.util.List;

import com.ismo.brevets.models.Inventeur;

public class MetierInventeur implements IMetier<Inventeur> {

	IMetier<Inventeur> dao = new MetierInventeur();
	
	@Override
	public List<Inventeur> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public Inventeur getOne(int id) {
		// TODO Auto-generated method stub
		return dao.getOne(id);
	}

	@Override
	public boolean save(Inventeur obj) {
		// TODO Auto-generated method stub
		return dao.save(obj);
	}

	@Override
	public boolean update(Inventeur obj) {
		// TODO Auto-generated method stub
		return dao.update(obj);
	}

	@Override
	public boolean delete(Inventeur obj) {
		// TODO Auto-generated method stub
		return dao.delete(obj);
	}

}
