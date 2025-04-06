package com.project.hospital_managemnet_system_E4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.MedicineDao;
import com.project.hospital_managemnet_system_E4.dto.Medicine;
import com.project.hospital_managemnet_system_E4.exception.MedicineIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

@Service
public class MedicineService {
	@Autowired
	MedicineDao medicineDao;
	@Autowired
	ResponseStructure<Medicine> responseStructure;
	
	public ResponseEntity<ResponseStructure<Medicine>> saveMedicine(Medicine medicine) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucessfully medicine created in DB");
		responseStructure.setData(medicineDao.saveMedicine(medicine));
		return new ResponseEntity<ResponseStructure<Medicine>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Medicine>> updateMedicineById(int oldMedicineId, Medicine newMedicine) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully medicine updated in DB");
		responseStructure.setData(medicineDao.updateMedicineById(oldMedicineId, newMedicine));
		return new ResponseEntity<ResponseStructure<Medicine>>(responseStructure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Medicine>> fetchMedicineById(int medicineId) {
		Medicine medicine =medicineDao.fetchMedicineById(medicineId);
		if(medicine!=null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("sucessfully medicine fetched from DB");
			responseStructure.setData(medicineDao.fetchMedicineById(medicineId));
			return new ResponseEntity<ResponseStructure<Medicine>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new MedicineIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Medicine>> deleteMedicineById(int medicineId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("sucessfully medicine deleted from DB");
		responseStructure.setData(medicineDao.deleteMedicineById(medicineId));
		return new ResponseEntity<ResponseStructure<Medicine>>(responseStructure,HttpStatus.OK);
	}

	public List<Medicine> fetchAllMedicine() {
		return medicineDao.fetchAllMedicine();
	}
}
