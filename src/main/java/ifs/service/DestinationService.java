package ifs.service;

import ifs.repository.DestinationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
@org.springframework.stereotype.Service
public class DestinationService {
	@Autowired
	private DestinationRepository  destinationRepository;
	public List<Object> getDestinationTableService() {

		return destinationRepository.getDestinationTableRepository();
	}

	public List<String> getDestinationTableNameService() {
		
		return destinationRepository.getDestinationTableNameRepository();
	}

	public Map<String, ArrayList<Object>> getDestinationTableColumnNameService() {
		
		return destinationRepository.getDestinationTableColumnNameRepository();
	}

	public ArrayList<Object> getDestinationColumnNameService(String tablename) {
		
		return destinationRepository.getDestinationColumnNameRepository(tablename);
	}


}
