package ifs.repository;

import ifs.domain.Destination1;
import ifs.domain.Destination2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@org.springframework.stereotype.Repository
public class DestinationRepository {
	public List<Object> getDestinationTableRepository()
	{
		ArrayList<Object> al=new ArrayList<Object>();
		al.add(new Destination1("1530","29-Aug"));
		
		
		al.add(new Destination2("4-may","30-june"));
		
		return al;
	}
	
	public List<String> getDestinationTableNameRepository()
	{
		ArrayList<String> al=new ArrayList<String>();
		al.add("Destination1");
		al.add("Destination2");
		al.add("TEST");
		al.add("ABC");
		al.add("ABCDEF");
		al.add("TESTTEST");
		
		return al;
	}
	
	public Map<String, ArrayList<Object>> getDestinationTableColumnNameRepository()
	{
		Map<String, ArrayList<Object>> map = new HashMap<String, ArrayList<Object>>();
		ArrayList<Object> des1 = new ArrayList<Object>();
		des1.add("empId");
		des1.add("dob");
		map.put("Destination1", des1);
		
		ArrayList<Object> des2 = new ArrayList<Object>();
		des2.add("startdate");
		des2.add("enddate");
		map.put("Destination2", des2);
	
		return map;
	}
	
	public ArrayList<Object> getDestinationColumnNameRepository(String tablename)
	{
		
		Map<String, ArrayList<Object>> map = new HashMap<String, ArrayList<Object>>();
		map=getDestinationTableColumnNameRepository();
		ArrayList<Object> al=new ArrayList<Object>();
		
		Set<String> set=map.keySet();
		for (String string : set) {
			if(string.equalsIgnoreCase(tablename))
			{
				al=map.get(string);
				return al;
			}
			
		}
		
		return al;
	}

}
