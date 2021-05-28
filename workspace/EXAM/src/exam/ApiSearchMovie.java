package exam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ApiSearchMovie {

    public static void main(String[] args) {
        String clientId = "UJJ0irOUg5sIZIfzX2Bl"; //애플리케이션 클라이언트 아이디값"
        String clientSecret = "b_bl392RVL"; //애플리케이션 클라이언트 시크릿값"

        String text = null;
        try {
        	Scanner sc = new Scanner(System.in);
        	System.out.print("영화제목 입력 >>> ");
        	String movieTitle = sc.nextLine();
            text = URLEncoder.encode(movieTitle, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }


        String apiURL = "https://openapi.naver.com/v1/search/movie?query=" + text;    // json 결과
        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과


        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(apiURL,requestHeaders);

        // 추가한 내용
        JSONParser parser = new JSONParser();
        JSONObject obj = null;
        File file = new File("search_result.txt");
        FileWriter fw = null;
        try {
        	
        	fw = new FileWriter(file);
        	obj = (JSONObject)parser.parse(responseBody);
        	JSONArray items = (JSONArray)obj.get("items");
        	for (int i = 0; i < items.size(); i++) {
        		JSONObject obj2 = (JSONObject)items.get(i);
        		String title = obj2.get("title").toString();
        		title = title.replace("<b>", "");
        		title = title.replace("</b>", "");
        		title = title.replace("&lt;", "");
        		title = title.replace("&gt;", "");
        		title = title.replace("&amp;", "");
        		fw.write(title + '\n');
        	}
        } catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw != null) {fw.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        // 에러메시지 및 일시 출력
        File file2= new File("search_error.txt");
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
        System.out.println(sdf.format(now));
        try {
        	fw = new FileWriter(file2);
        	fw.write(sdf.format(now));
        } catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw != null) {fw.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    }


    private static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }


            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 에러 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }


    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }


    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);


        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();


            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }


            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
}