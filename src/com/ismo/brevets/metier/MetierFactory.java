package com.ismo.brevets.metier;

import com.ismo.brevets.dao.DAO;

public class MetierFactory {

	public static IMetier getMetier(METIER type) {

		switch (type) {
		case BREVET:
			return new MetierBrevet();
		case ENTREPRISE:
			return new MetierEntreprise();
		case DOMAINE:
			return new MetierDomaine();
		case INVENTEUR:
			return new MetierInventeur();
		case INVENTION:
			return new MetierInvention();
		}

		return null;
	}
}
