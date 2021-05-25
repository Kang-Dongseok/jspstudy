package json.simple;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Ex02_JSONArray {

	public static void main(String[] args) {
		
		// JSON : {}  ->  JSONObject
		// JSON : [{}, {}]  ->  JSONArray
		
		// JSONArray는 List 인터페이스를 구현한다.
		// 따라서, 같은 인터페이스를 구현한 ArrayList 클래스와 사용법이 같다.

		String responseData = "[{\"name\": \"브레드\", \"age\": 50}, {\"name\": \"초코\", \"age\": 30}]";
				
		JSONParser parser = new JSONParser();
		
		// JSONArray list = (JSONArray)parser.parse(responseData);
		JSONArray list = null;
		try {
			list = (JSONArray)parser.parse(responseData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// list의 각 요소는 get() 메소드로 추출한다.
		System.out.println("첫 번째 요소: " + list.get(0));
		System.out.println("두 번째 요소: " + list.get(1));
		
		for (int i = 0; i < list.size(); i++) {
			JSONObject obj = (JSONObject)list.get(i);
			System.out.println((i + 1) + "번째 요소 이름: " + obj.get("name"));
			System.out.println((i + 1) + "번째 요소 나이: " + obj.get("age"));
		}
		
	}

}