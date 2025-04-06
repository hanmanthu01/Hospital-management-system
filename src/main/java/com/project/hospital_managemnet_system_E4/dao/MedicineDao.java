package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Medicine;
import com.project.hospital_managemnet_system_E4.repo.MedicineRepo;
@Repository
public class MedicineDao {

	@Autowired
	MedicineRepo medicineRepo;
	
	
	public Medicine saveMedicine(Medicine medicine) {
		return medicineRepo.save(medicine);
	}
	
	public Medicine updateMedicineById(int oldMedicineId, Medicine newMedicine) {
		newMedicine.setMedicineId(oldMedicineId);
	//	return MedicineRepo.save(newMedicine);
		return saveMedicine(newMedicine);
	}
	
	public Medicine fetchMedicineById(int medicineId) {
		Optional<Medicine> medicine = medicineRepo.findById(medicineId);
		if(medicine.isEmpty()) {
			return null;
		}
		else {
			return medicine.get();
		}
	}
	
	public Medicine deleteMedicineById(int medicineId) {
	//	Medicine Medicine=MedicineRepo.findById(medicineId).get();
		Medicine Medicine=fetchMedicineById(medicineId);
		medicineRepo.delete(Medicine);
		return Medicine;
	}
	
	public List<Medicine> fetchAllMedicine(){
		return medicineRepo.findAll();
	}
}
