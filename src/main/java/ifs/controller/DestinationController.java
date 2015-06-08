package ifs.controller;

import ifs.service.DestinationService;

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
public class DestinationController {
	
	@Autowired
	private DestinationService destinationService;
	
	
	@RequestMapping(value = "/getDestinationTableName", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getDestinationTableNameController()
	{
		List<String> list=destinationService.getDestinationTableNameService();
		return new ResponseEntity<List<String>>(list,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getDestinationTableColumnName", method = RequestMethod.GET)
	public ResponseEntity<Map<String, ArrayList<Object>>> getDestinationTableColumnNameController()
	{
		Map<String,ArrayList<Object>> map=destinationService.getDestinationTableColumnNameService();
		return new ResponseEntity<Map<String, ArrayList<Object>>>(map,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/getDestinationColumnName/{tablename}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Object>> getDestinationTableColumnNameController(@PathVariable("tablename") String tablename)
	{
		ArrayList<Object> map=destinationService.getDestinationColumnNameService(tablename);
		return new ResponseEntity<ArrayList<Object>>(map,HttpStatus.OK);
		
	}


}
