import java.io.File;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Test {

	public static void main(String[] args) {

		String responseBody = "{\r\n" + 
				"			\"name\": \"브레드\",\r\n" + 
				"			\"age\": 50,\r\n" + 
				"			\"staff\": [\r\n" + 
				"				 {\r\n" + 
				"					 \"name\": \"초코\",\r\n" + 
				"					 \"age\": 30\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"					 \"name\": \"윌크\",\r\n" + 
				"					 \"age\": 20\r\n" + 
				"				 }\r\n" + 
				"			]\r\n" + 
				"		}";
		/*
		{
			"name": "브레드",
			"age": 50,
			"staff": [
				 {
					 "name": "초코",
					 "age": 30
				 },
				 {
					 "name": "윌크",
					 "age": 20
				 }
			]
		}
		*/
		String responseBody2 = "{\r\n" + 
				"  \"startDate\": \"2017-01-01\",\r\n" + 
				"  \"endDate\": \"2017-04-30\",\r\n" + 
				"  \"timeUnit\": \"month\",\r\n" + 
				"  \"results\": [\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"한글\",\r\n" + 
				"      \"keywords\": [\r\n" + 
				"        \"한글\",\r\n" + 
				"        \"korean\"\r\n" + 
				"      ],\r\n" + 
				"      \"data\": [\r\n" + 
				"        {\r\n" + 
				"          \"period\": \"2017-01-01\",\r\n" + 
				"          \"ratio\": 47.0\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"period\": \"2017-02-01\",\r\n" + 
				"          \"ratio\": 53.23\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"period\": \"2017-03-01\",\r\n" + 
				"          \"ratio\": 100.0\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"period\": \"2017-04-01\",\r\n" + 
				"          \"ratio\": 85.32\r\n" + 
				"        }\r\n" + 
				"      ]\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"영어\",\r\n" + 
				"      \"keywords\": [\r\n" + 
				"        \"영어\",\r\n" + 
				"        \"english\"\r\n" + 
				"      ],\r\n" + 
				"      \"data\": [\r\n" + 
				"        {\r\n" + 
				"          \"period\": \"2017-01-01\",\r\n" + 
				"          \"ratio\": 40.08\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"period\": \"2017-02-01\",\r\n" + 
				"          \"ratio\": 36.69\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"period\": \"2017-03-01\",\r\n" + 
				"          \"ratio\": 52.11\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"period\": \"2017-04-01\",\r\n" + 
				"          \"ratio\": 44.45\r\n" + 
				"        }\r\n" + 
				"      ]\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
		
		JSONParser parser = new JSONParser();
		JSONObject obj = null;
		
		File dir = new File("C:\\MyTemp");
		
		if (dir.exists() == false) {
			dir.mkdirs();
		}
		
		File file = new File(dir, "text.txt");
		
		FileWriter fw = null;
		try{
			fw = new FileWriter(file);
			obj = (JSONObject)parser.parse(responseBody2);
			String startDate = obj.get("startDate").toString();
			System.out.println(startDate);
			System.out.println("--------");
			JSONArray list = (JSONArray)obj.get("results");
			for (int i = 0; i < list.size(); i++) {
				JSONObject obj2 = (JSONObject)list.get(i);
				JSONArray data = (JSONArray)obj2.get("data");
				for(int j = 0; j < data.size(); j++) {
					JSONObject obj3 = (JSONObject)data.get(j);
					String period = obj3.get("period").toString();
					fw.write(period+'\n');
					System.out.println(period);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) { fw.close(); }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 파싱 연습
		/*JSONParser parser = new JSONParser();
		JSONObject obj = null;
		try {
			obj = (JSONObject)parser.parse(responseBody);
			String name = obj.get("name").toString();
			long age = (long)obj.get("age");
			System.out.println("이름: " + name + ", 나이: " + age);
			JSONArray staff = (JSONArray)obj.get("staff");
			for(int i = 0; i < staff.size(); i++) {
				JSONObject obj2 = (JSONObject)staff.get(i);
				String name2 = obj2.get("name").toString();
				long age2 =  (long)obj2.get("age");
				System.out.println("이름: " + name2 + ", 나이: " + age2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
	}
}
