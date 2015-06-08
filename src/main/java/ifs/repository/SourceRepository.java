package ifs.repository;

import ifs.domain.Source1;
import ifs.domain.Source2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@org.springframework.stereotype.Repository
public class SourceRepository {
	
	public List<Object> getSourceTableRepository()
	{
		ArrayList<Object> al=new ArrayList<Object>();
		al.add(new Source1("Pinki","25"));
		/*al.add(new Source1("Akshda",23));
		al.add(new Source1("Suvarna",23));
		al.add(new Source1("Pooja",23));*/
		
		al.add(new Source2("1525","Goyal"));
		/*al.add(new Source2("1530","Kadam"));
		al.add(new Source2("1525382","Patil"));
		al.add(new Source2("1533","Dhokale"));
		*/
		return al;
	}
	
	public List<String> getSourceTableNameRepository()
	{
		ArrayList<String> al=new ArrayList<String>();
		al.add("Source1");
		al.add("Source2");
		
		return al;
	}
	
	public Map<String, ArrayList<Object>> getSourceTableColumnNameRepository()
	{
		Map<String, ArrayList<Object>> map = new HashMap<String, ArrayList<Object>>();
		ArrayList<Object> src1 = new ArrayList<Object>();
		src1.add("dob");
		src1.add("age");
		map.put("Source1", src1);
		
		ArrayList<Object> src2 = new ArrayList<Object>();
		src2.add("empId");
		src2.add("name");
		map.put("Source2", src2);
	
		return map;
	}
	
	public ArrayList<Object> getSourceColumnNameRepository(String tablename)
	{
		
		Map<String, ArrayList<Object>> map = new HashMap<String, ArrayList<Object>>();
		map=getSourceTableColumnNameRepository();
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

	public ArrayList<Object> getSourceColumnValuesRepository(String tablename) {
		
		return null;
	}

}
	
