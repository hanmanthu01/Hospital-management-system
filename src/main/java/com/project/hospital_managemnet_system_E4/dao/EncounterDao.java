package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Encounter;
import com.project.hospital_managemnet_system_E4.repo.EncounterRepo;

@Repository
public class EncounterDao {
	@Autowired
	EncounterRepo encounterRepo;
	
	
	public Encounter saveEncounter(Encounter encounter) {
		return encounterRepo.save(encounter);
	}
	
	public Encounter updateEncounterById(int oldEncounterId, Encounter newEncounter) {
		newEncounter.setEncounterId(oldEncounterId);
		return saveEncounter(newEncounter);
	}
	
	public Encounter fetchEncounterById(int EncounterId) {
		Optional<Encounter> encounter = encounterRepo.findById(EncounterId);
		if(encounter.isEmpty()) {
			return null;
		}
		else {
			return encounter.get();
		}
	}
	
	public Encounter deleteEncounterById(int encounterId) {
		Encounter encounter=fetchEncounterById(encounterId);
		encounterRepo.delete(encounter);
		return encounter;
	}
	
	public List<Encounter> fetchAllEncounter(){
		return encounterRepo.findAll();
	}

}
