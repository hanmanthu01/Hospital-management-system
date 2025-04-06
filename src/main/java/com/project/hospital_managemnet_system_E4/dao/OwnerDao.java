package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Hospital;
import com.project.hospital_managemnet_system_E4.dto.Owner;
import com.project.hospital_managemnet_system_E4.repo.OwnerRepo;

@Repository
public class OwnerDao {
	
	@Autowired
	OwnerRepo ownerRepo;
	@Autowired
	HospitalDao hospitalDao;
	
	public Owner saveOwner(Owner owner) {
		return ownerRepo.save(owner);
	}
	
	public Owner updateOwnerById(int oldOwnerId, Owner newOwner) {
		newOwner.setOwnerId(oldOwnerId);
	//	return ownerRepo.save(newOwner);
		return saveOwner(newOwner);
	}
	
	public Owner fetchOwnerById(int ownerId) {
		Optional<Owner> owner = ownerRepo.findById(ownerId);
		if (owner.isEmpty()) {
			return null;
		} 
		else {
			return owner.get();
		}
	}
	
	public Owner deleteOwnerById(int ownerId) {
	//	Owner owner=ownerRepo.findById(ownerId).get();
		Owner owner=fetchOwnerById(ownerId);
		ownerRepo.delete(owner);
		return owner;
	}
	
	public List<Owner> fetchAllOwner(){
		return ownerRepo.findAll();
	}
	
	public Owner addExistingHospitalToExistingOwner(int hospitalId, int ownerId) {
		Owner owner = fetchOwnerById(ownerId);
		Hospital hospital = hospitalDao.fetchHospitalById(hospitalId);
		owner.setHospital(hospital);
		// return saveOwner(owner);
		return ownerRepo.save(owner);
	}
	
	public Owner addNewHospitalToExistingOwner(int ownerId,Hospital newhospital) {
		Owner owner=fetchOwnerById(ownerId);
		Hospital hospital=hospitalDao.saveHospital(newhospital);
		owner.setHospital(hospital);
		return saveOwner(owner);
	}

}
