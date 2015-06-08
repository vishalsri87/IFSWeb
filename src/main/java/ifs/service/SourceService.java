package ifs.service;

import ifs.repository.SourceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SourceService {
	
    @Autowired
	private SourceRepository  sourceRepository;
    
	public List<Object> getSourceTableService()
	{
		 return sourceRepository.getSourceTableRepository();
		
	}
	
	public List<String> getSourceTableNameService()
	{
		 return sourceRepository.getSourceTableNameRepository();
		
	}
	
	public Map<String, ArrayList<Object>> getSourceTableColumnNameService()
	{
		return sourceRepository.getSourceTableColumnNameRepository();
	}

	public ArrayList<Object> getSourceColumnNameService(String tablename)
	{
		return sourceRepository.getSourceColumnNameRepository(tablename);
	}

	public ArrayList<Object> getSourceColumnValuesService(String tablename) {
	
		return sourceRepository.getSourceColumnValuesRepository(tablename);
	}
	
}
