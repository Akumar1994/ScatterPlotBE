package com.scatter.demo.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import com.scatter.demo.model.Cordinate;
import com.scatter.demo.repository.CoordinatesRepository;

@Service
public class CoordinateService {

	@Autowired
	private CoordinatesRepository coordinatesRepository;
	
	public void saveAllCoornites(MultipartFile file) throws IOException {
		List<Cordinate> cordinates = new ArrayList<>();
		Reader reader = new InputStreamReader(file.getInputStream());
		CSVReader csvReader = new CSVReaderBuilder(reader)
				.withSkipLines(1)//to skip first hear lines
				.build();
		String[] line;
		try {
			while((line = csvReader.readNext()) != null) {
				String xVariable =line[0];
				String yVariable= line[1];
				//System.out.println(Double.parseDouble(xVariable)+ "added" + Double.parseDouble(yVariable));
				Cordinate cordinate = new Cordinate(Double.parseDouble(xVariable), Double.parseDouble(yVariable));
				System.out.println(cordinate+"ädded");
				cordinates.add(cordinate);
				
			}
		} catch (CsvValidationException | NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		coordinatesRepository.saveAll(cordinates);
	}
	
	public List<Cordinate> getAllCoordinates(){
		return coordinatesRepository.findAll();
	}
	public void removeAllCoordinates(){
		 coordinatesRepository.deleteAll();
	}
}
