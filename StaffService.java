package it.contrader.service;

import it.contrader.converter.StaffConverter;
import it.contrader.dao.StaffDAO;
import it.contrader.dto.StaffDTO;
import it.contrader.model.Staff;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class StaffService extends AbstractService<Staff, StaffDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public StaffService(){
		this.dao = new StaffDAO();
		this.converter = new StaffConverter();
	}

}
