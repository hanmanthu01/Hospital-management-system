package com.project.hospital_managemnet_system_E4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hospital_managemnet_system_E4.dto.Room;
import com.project.hospital_managemnet_system_E4.service.RoomService;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



@RestController
public class RoomController {

	@Autowired
	RoomService roomService;
	
	@Operation(summary = "Save Room", description = "API is used to save the Room")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Room not found for the given id") })
	
	@PostMapping("/saveRoom")
	public ResponseEntity<ResponseStructure<Room>> saveRoom(@RequestBody Room room) {
		return roomService.saveRoom(room);
	}
	@PutMapping("/updateRoomById")
	public ResponseEntity<ResponseStructure<Room>> updateRoomById(@RequestParam int oldRoomId,@RequestBody Room newRoom) {

		return roomService.updateRoomById(oldRoomId, newRoom);
	}
	@GetMapping("/fetchRoomById")
	public ResponseEntity<ResponseStructure<Room>> fetchRoomById(@RequestParam int roomId) {
		return roomService.fetchRoomById(roomId);
	}
	@DeleteMapping("/deleteRoomById")
	public ResponseEntity<ResponseStructure<Room>> deleteRoomById(@RequestParam int roomId) {

		return roomService.deleteRoomById(roomId);
	}
	@GetMapping("/fetchAllRoom")
	public List<Room> fetchAllRoom() {
		return roomService.fetchAllRoom();
	}
	@PutMapping("/addExistingPatientToExistingRoom")
	public Room addExistingPatientToExistingRoom(@RequestParam int patientId,@RequestParam int roomId) {
		return roomService.addExistingPatientToExistingRoom(patientId,roomId);
	}
	
}
