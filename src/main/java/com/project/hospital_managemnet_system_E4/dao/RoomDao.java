package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Address;
import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.Patient;
import com.project.hospital_managemnet_system_E4.dto.Room;
import com.project.hospital_managemnet_system_E4.repo.RoomRepo;

@Repository
public class RoomDao {

	@Autowired
	RoomRepo roomRepo;
	@Autowired
	PatientDao patientDao;
	
	public Room saveRoom(Room room) {
		return roomRepo.save(room);
	}
	
	public Room updateRoomById(int oldRoomId, Room newRoom) {
		newRoom.setRoomId(oldRoomId);
	//	return RoomRepo.save(newRoom);
		return saveRoom(newRoom);
	}
	
	public Room fetchRoomById(int roomId) {
		 Optional<Room> room = roomRepo.findById(roomId);
		 if(room.isEmpty()) {
			 return null;
		 }
		 else {
			 return room.get();
		 }
	}
	
	public Room deleteRoomById(int roomId) {
	//	Room Room=RoomRepo.findById(RoomId).get();
		Room room=fetchRoomById(roomId);
		roomRepo.delete(room);
		return room;
	}
	
	public List<Room> fetchAllRoom(){
		return roomRepo.findAll();
	}
	
	public Room addExistingPatientToExistingRoom(int patientId,int roomId) {
		Room room=fetchRoomById(roomId);
		Patient patient= patientDao.fetchPatientById(patientId);
		room.setPatient(patient);
		return saveRoom(room);
		
	}
	
	
	
}
