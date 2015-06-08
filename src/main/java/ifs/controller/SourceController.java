package ifs.controller;
import ifs.service.SourceService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class SourceController {
	
	@Autowired
	private SourceService sourceService;
	
	@RequestMapping(value = "/getSourceTable", method = RequestMethod.GET)
	public ResponseEntity<List<Object>> getSoucreTableController()
	{
		List<Object> list=sourceService.getSourceTableService();
		return new ResponseEntity<List<Object>>(list,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getSourceTableName", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getSoucreTableNameController()
	{
		List<String> list=sourceService.getSourceTableNameService();
		return new ResponseEntity<List<String>>(list,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getSourceTableColumnName", method = RequestMethod.GET)
	public ResponseEntity<Map<String, ArrayList<Object>>> getSourceTableColumnNameController()
	{
		Map<String,ArrayList<Object>> map=sourceService.getSourceTableColumnNameService();
		return new ResponseEntity<Map<String, ArrayList<Object>>>(map,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/getSourceColumnName/{tablename}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Object>> getSourceTableColumnNameController(@PathVariable("tablename") String tablename)
	{
		ArrayList<Object> map=sourceService.getSourceColumnNameService(tablename);
		return new ResponseEntity<ArrayList<Object>>(map,HttpStatus.OK);
		
	}
		
	
	
}