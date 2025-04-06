package com.project.hospital_managemnet_system_E4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.EncounterDao;
import com.project.hospital_managemnet_system_E4.dto.Encounter;
import com.project.hospital_managemnet_system_E4.exception.EncounterIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

@Service
public class EncounterService {

	@Autowired
	EncounterDao encounterDao;
	@Autowired
	ResponseStructure<Encounter> responseStructure;
	
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucessfully encounter created in DB ");
		responseStructure.setData(encounterDao.saveEncounter(encounter));
		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Encounter>> updateEncounterById(int oldEncounterId, Encounter newEncounter) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully encounter updated in DB ");
		responseStructure.setData(encounterDao.updateEncounterById(oldEncounterId, newEncounter));
		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Encounter>> fetchEncounterById(int encounterId) {
		Encounter encounter = encounterDao.fetchEncounterById(encounterId);
		if(encounter!=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("sucessfully encounter fetched from DB ");
		responseStructure.setData(encounterDao.fetchEncounterById(encounterId));
		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new EncounterIdNotFound();
		}
		
	}

	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounterById(int encounterId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully encounter deleted from DB ");
		responseStructure.setData(encounterDao.deleteEncounterById(encounterId));
		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.OK);
	}

	public List<Encounter> fetchAllEncounter() {
	return encounterDao.fetchAllEncounter();
	}
}
