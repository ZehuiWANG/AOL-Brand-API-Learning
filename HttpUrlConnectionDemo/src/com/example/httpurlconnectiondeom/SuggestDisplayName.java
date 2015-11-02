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
public class SuggestDisplayName {
//private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		SuggestDisplayName httpDemo2 = new SuggestDisplayName();

		System.out.println("\nTesting 2 - Send Http POST request");
		httpDemo2.sendPost2();

	}

	// HTTP POST request
	void sendPost2() throws Exception {

		String url = "https://aolapis.com/brandapi/api/suggestDisplayName";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		
		
		//con.setRequestProperty("User-Agent", USER_AGENT);
		//con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Authorization",
				"Bearer djF8ZV9iZWFyfDF8cVpPaHFoZDEtNkZlUUNHcjB6dDI2NEFtTEM2RWRHY3NqOG4xMVpGYm5HNU9QWFBudXdLR2JlcDNxS29FRGNOd3JhbnJQSUdkd0Y2LVFfd3JoUVVCQVF8bV9iZWFyfDF8amlmVmZnRHJjX2pRR2s3YTN4ZUE2VU91anNzZVd3VmJMV3pMZ3Q4TWtEaw");
		
		//String urlParameters = "namespace=brandnamespace&displayName=zhongkaifan";
		String urlParameters =  "{\"namespace\": \"brandnamespace\",\"desiredName\":\"zehui wang\",\"desiredCount\":3,\"firstName\":\"zehui\",\"lastName\":\"wang\"}";
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
