package com.scatter.demo.controller;

import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.scatter.demo.model.Cordinate;
import com.scatter.demo.service.CoordinateService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class Controller {
	
	public Controller(CoordinateService coordinateService) {
		super();
		this.coordinateService = coordinateService;
	}

	@Autowired
	private CoordinateService coordinateService;
	
	@GetMapping("/coordinates")
	public List<Cordinate> getAllCoordinates(){
		List<Cordinate> coordinates = coordinateService.getAllCoordinates();
		System.out.println("The cordinates" + coordinates);
		return coordinates;
	}
	
	@PostMapping(value="/coordinates",  consumes = { "multipart/form-data" })
	@Operation(summary="Upload a single File")
	public ResponseEntity<String> uploadCordinates(@RequestPart("file") MultipartFile file){
		try {
			coordinateService.saveAllCoornites(file);
			return ResponseEntity.ok().body("Saving was Successfull");
		}catch(IOException e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Filed to save FIle"+ e.getMessage());
		}
	}
	
	@DeleteMapping("/coordinates")
	public ResponseEntity<String> deleteAllCordinates(){
		try {
			coordinateService.removeAllCoordinates();
			return ResponseEntity.ok().body("All the co-ordinates were deleted");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Filed to delete all co-ordinates"+ e.getMessage());
		}
		
	}

}
