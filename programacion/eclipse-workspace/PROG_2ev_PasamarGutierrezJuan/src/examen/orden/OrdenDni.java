package examen.orden;

import java.util.Comparator;

import examen.ReservaAsiento;

public class OrdenDni implements Comparator<ReservaAsiento> {

	@Override
	public int compare(ReservaAsiento o1, ReservaAsiento o2) {
		return o1.getDni().compareTo(o2.getDni());
	}

}
