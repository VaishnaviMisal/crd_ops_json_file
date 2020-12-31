package com.mycompany;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class App {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		
        //First Employee
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("firstName", "Sakshi");
        employeeDetails.put("lastName", "Gupta");
        employeeDetails.put("website", "java.com");
         
        JSONObject employeeObject = new JSONObject(); 
        employeeObject.put("employee", employeeDetails);
         
        //Second Employee
        JSONObject employeeDetails2 = new JSONObject();
        employeeDetails2.put("firstName", "Priya");
        employeeDetails2.put("lastName", "Patil");
        employeeDetails2.put("website", "example.com");
         
        JSONObject employeeObject2 = new JSONObject(); 
        employeeObject2.put("employee", employeeDetails2);
         
        //Add employees to list
        JSONArray employeeList = new JSONArray();
        employeeList.add(employeeObject);
        employeeList.add(employeeObject2);
        System.out.println("before delete or remove from employeeDetails2");
        System.out.println(employeeDetails2);
        deleteFromObject(employeeDetails2,"website");
        System.out.println("after delete or remove website from employeeDetails2");
        System.out.println(employeeDetails2);
         
        //Write JSON file
        try (FileWriter file = new FileWriter("employees.json")) {
 
            file.write(employeeList.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
      //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("employees.json"))
        {
            //Read JSON file
            Object obj = null;
			try {
				obj = jsonParser.parse(reader);
			} catch (org.json.simple.parser.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            JSONArray employeeList1 = (JSONArray) obj;
            System.out.println("bhupesh");
            
            System.out.println(employeeList1);
        
            //Iterate over employee array
            employeeList1.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	private static void writeToFile(JSONObject employee,String path) {
		
//		  File file=new File("C:/Users/Public/Documents/JsonFile.json");  
		  File file=new File(path);  
	       
	        try {
	        	 FileWriter fileWriter = new FileWriter(file);
				file.createNewFile();
				 fileWriter.write(employee.toJSONString());  
		            fileWriter.flush();  
		            fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
	}
    private static void parseEmployeeObject(JSONObject employee)
    {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("employee");
         
       writeToFile(employeeObject, "C:/Users/Public/Documents/JsonFile.json");
       
          
    }
    private static void deleteFromObject(JSONObject Obj, String Key)
    {
    	Obj.remove(Key);
    }
    
  
}