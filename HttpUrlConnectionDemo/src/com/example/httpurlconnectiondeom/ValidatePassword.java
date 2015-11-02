package com.example.httpurlconnectiondeom;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author Zehui WANG
 */
public class ValidatePassword {
    public static void main(String[] args) throws Exception {

		ValidatePassword httpDemo = new ValidatePassword();

		System.out.println("\nTesting 2 - Send Http POST request");
		httpDemo.sendValidatePassword();

	}
    
    // HTTP POST request
	void sendValidatePassword() throws Exception {

		String url = "  https://aolapis.com/brandapi/api/validatePassword";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Authorization",
				"Bearer djF8ZV9iZWFyfDF8NlFGaFVLbnZWM0FianQ2cTlCSDdhN0FMVnNBbS1YLWI0U2hhTXpKRE5ZOVZieTJmbmo1aDEzc1B4MXg0OFoxVXZOSDVOOVlldlMzWWh0TWFZS2dWNnd8bV9iZWFyfDF8ckh3eUVYVlc2eC1CSTAzLXJ3MHNmWmI4dGk4cEhzelJRUzZSMC1iOFpCZw");
		
		//String urlParameters = "namespace=brandnamespace&displayName=zhongkaifan";
		String urlParameters =  "{\"namespace\": \"brandnamespace\",\"email\":\"zehuiwang345@gmail.com\"}";
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

