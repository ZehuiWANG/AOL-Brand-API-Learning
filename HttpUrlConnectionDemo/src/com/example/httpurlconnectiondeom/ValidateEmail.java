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
public class ValidateEmail {
    public static void main(String[] args) throws Exception {

		ValidateEmail httpDemo = new ValidateEmail();

		System.out.println("\nTesting 2 - Send Http POST request");
		httpDemo.sendValidateEmailPost();

	}
    
    // HTTP POST request
	void sendValidateEmailPost() throws IOException {

		String url = " https://aolapis.com/brandapi/api/validateEmail";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Authorization",
				"Bearer djF8ZV9iZWFyfDF8eUxNYWk5MWpQbDd2eVRVSUU3RFBuUnBqbDJycmJMY0FHazJCSi1acTlyRHdpNmwwMUFsSXVpS2hWUmgxc2VYTVZyWHBuOW1YLVJTWFFqVVpuOEk4SUF8bV9iZWFyfDF8U09yUDQ5bFZ0c2tOUndLMWd0R3RuN094cGtVajlTdkp0UFhCWUtTeFBzMA");
		
		//String urlParameters = "namespace=brandnamespace&displayName=zhongkaifan";
		String urlParameters =  "{\"namespace\": \"brandnamespace\",\"email\":\"zehuiwang345adfadfad@gmail.com\"}";
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



