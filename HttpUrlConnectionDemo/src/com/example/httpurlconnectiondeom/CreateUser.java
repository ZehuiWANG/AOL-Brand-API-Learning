package com.example.httpurlconnectiondeom;



import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author Zehui WANG
 */
public class CreateUser {
    	public static void main(String[] args) throws Exception {

		CreateUser httpDemo2 = new CreateUser();

		System.out.println("\nTesting 2 - Send Http POST request");
		httpDemo2.sendPost3();

	}

	// HTTP POST request
	void sendPost3() throws IOException {

		String url = "https://aolapis.com/brandapi/api/createUser";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		
		
		//con.setRequestProperty("User-Agent", USER_AGENT);
		//con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Authorization",
				"Bearer djF8ZV9iZWFyfDF8NEpaLV9QckpsX1BlUUF2ZlpWdzRRS1J2UlBnNlhaMFFFVWdwcy1TQjVnNnNOWFdERlRpcG5RaEZwczhWYmJnVms2cW1GSnV5NEgyQjJIaEh1QWtZcWd8bV9iZWFyfDF8aC00UHN0YTZ1WDBENm9GUUtxTk55VlR0MlByNUZCVkVHeW92Q0hveVNzTQ");
		
		//String urlParameters = "namespace=brandnamespace&displayName=zhongkaifan";
		String urlParameters =  "{\"namespace\": \"brandnamespace\",\"email\":\"zehuiwang345adfadfadf@gmail.com\",\"password\":\"sadfadfadfads\"}";
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());

	}
}
