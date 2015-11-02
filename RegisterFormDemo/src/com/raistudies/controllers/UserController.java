package com.raistudies.controllers;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator.OfDouble;

import javax.net.ssl.HttpsURLConnection;

import org.apache.catalina.connector.Response;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.raistudies.domain.JsonResponse;
import com.raistudies.domain.User;
import com.sun.net.httpserver.Authenticator.Success;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.xml.internal.bind.v2.runtime.Name;

import sun.misc.Perf.GetPerfAction;

@Controller
public class UserController {
	
	 String accessToken="Bearer djF8ZV9iZWFyfDF8eUxNYWk5MWpQbDd2eVRVSUU3RFBuUnBqbDJycmJMY0FHazJCSi1acTlyRHdpNmwwMUFsSXVpS2hWUmgxc2VYTVZyWHBuOW1YLVJTWFFqVVpuOEk4SUF8bV9iZWFyfDF8U09yUDQ5bFZ0c2tOUndLMWd0R3RuN094cGtVajlTdkp0UFhCWUtTeFBzMA";
	
	 private List<User> userList = new ArrayList<User>();
	 	
//   @RequestMapping(value="/ShowUsers.htm")
//   public String showUsers(ModelMap model){
//       model.addAttribute("User", userList);
//       return "ShowUsers";
//   }
	 
	 	@RequestMapping(value="/Registration.htm")
	 	public String showUsers(ModelMap model){
	 		System.out.println("test");
	 		return "Registration";
	 	}
	 	
	 	@RequestMapping(value="/SuccessPage.htm")
	 	public String showResults(ModelMap model){
	 		System.out.println("test");
	 		return "SuccessPage";
	 	}
	 	
	
	    @RequestMapping(value="/AddUser.htm",method=RequestMethod.GET)
	    public String showForm(){
	        return "AddUser";
	    }

	    @RequestMapping(value="/AddUser.htm",method=RequestMethod.POST)
	    public @ResponseBody String addUser(@ModelAttribute(value="user") User user, BindingResult result ) throws Exception{
	       // String returnText;
	        String name=user.getName();
	        Boolean res = getValidationDisplayNamePost(user.getName());
	        System.out.println(user.getName());
	        
	        if(res==true) 
	        		return "Dipslay name available";
	        else 
	        		return "Display name unavailable";  
	        
	        //String urlName="https://aolapis.com/brandapi/api/validateDisplayName";
	        //String urlParameters =  "{\"namespace\": \"brandnamespace\",\"displayName\":\""+name+"\"}";
	       // CallBrandAPi(url, urlParameters);
	    }
	    
	    @RequestMapping(value="/SuggestUser.htm",method=RequestMethod.POST)
	    public @ResponseBody String suggestUser(@ModelAttribute(value="suggestuser") User user, BindingResult result ) throws Exception{
	       // String returnText;
	    	 	//JsonResponse resjon=new JsonResponse();
	    		System.out.println("firstname is:"+user.getFirstname());
	    		System.out.println("lastname is:"+user.getLastname());
	    		
	    		sendSuggestNamePost(user.getFirstname(), user.getLastname());
	    		  
	    		if(!result.hasErrors()){
	    			//resjon.setStatus("SUCCESS");
	    			System.out.println("Valid");
	
	    		}else{
	    			//resjon.setStatus("FAIl");
	    			System.out.println("Unavaliable");
	    			
	    		}
	    		return user.getName(); 
	        
	    }
	    
	    @RequestMapping(value="/ValidateEmail.htm",method=RequestMethod.POST)
	    public @ResponseBody String validateEmail(@ModelAttribute(value="suggestuser") User user, BindingResult result ) throws Exception{
	       // String returnText;
	    		String url="https://aolapis.com/brandapi/api/validateEmail";
	    		String urlParameters =  "{\"namespace\": \"brandnamespace\",\"email\":\""+user.getEmail()+"\"}";
	  
	    		System.out.println(user.getEmail());
	    		CallBrandAPi(url, urlParameters);
	    		
	    		//sendValidateEmailPost(user.getEmail());
	    		return user.getEmail();
 
	    }
	    
	    @RequestMapping(value="/ValidatePassword.htm",method=RequestMethod.POST)
	    public @ResponseBody String validatePassword(@ModelAttribute(value="validatePassword") User user, BindingResult result ) throws IOException{
	       // String returnText;
	    	    
	    	    
	    	    System.out.println("FirstNameis"+user.getFirstname());
	    	    String password=user.getPassword();
	    	    
	    	    System.out.println("testpassword");
	    	    System.out.println(user.getName());
	    		String url="https://aolapis.com/brandapi/api/validatePassword";
	    		String urlParameters =  "{\"namespace\": \"brandnamespace\",\"username\":\""+user.getName()+"\",\"password\": \""+password+"\"}";
	    		
	    		System.out.println(user.getPassword());
	    		CallBrandAPi(url, urlParameters);
	    		//sendValidateEmailPost(user.getEmail());
	    		return user.getPassword();  
	    }
	    
	    @RequestMapping(value="/CreateUser.htm",method=RequestMethod.POST)
	    public @ResponseBody String CreateUser(@ModelAttribute(value="createuser") User user, BindingResult result ) throws IOException{
	       // String returnText;
	    		String url="https://aolapis.com/brandapi/api/createUser";
	    		String urlParameters =  "{\"namespace\": \"brandnamespace\",\"email\":\""+user.getEmail()+"\",\"password\":\""+user.getPassword()+"\"}";
	    		
	    		System.out.println(user.getEmail());
	    		CallBrandAPi(url, urlParameters);
	    		//sendValidateEmailPost(user.getEmail());
	    		return "SuccessPage";  
	    }
	    
	    
	    
		private Boolean getValidationDisplayNamePost(String input) throws Exception {

			String url = "https://aolapis.com/brandapi/api/validateDisplayName";
			URL obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			// add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Authorization",accessToken);
			
			String urlParameters =  "{\"namespace\": \"brandnamespace\",\"displayName\":\""+input+"\"}";
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
			//response.getStatusLine().getStatusCode())
			System.out.println(response.toString());
			
			if(response.toString().contains("success")){
				return true;
			}else{
				return null;
			}

		}
		private void sendSuggestNamePost(String name1,String name2) throws Exception {

			String url = "https://aolapis.com/brandapi/api/suggestDisplayName";
			URL obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			// add reuqest header
			con.setRequestMethod("POST");
			
			
			//con.setRequestProperty("User-Agent", USER_AGENT);
			//con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Authorization",
					accessToken);
			
			//String urlParameters = "namespace=brandnamespace&displayName=zhongkaifan";
			String urlParameters =  "{\"namespace\": \"brandnamespace\",\"desiredName\":\""+name1+" "+name2+"\",\"desiredCount\":5,\"firstName\":\""+name1+"\",\"lastName\":\""+name2+"\"}";
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
		
		 // HTTP POST request
		private void sendValidateEmailPost(String email) throws IOException {

			String url = " https://aolapis.com/brandapi/api/validateEmail";
			URL obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			// add reuqest header
			con.setRequestMethod("POST");
			
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Authorization",
					accessToken);
			
			//String urlParameters = "namespace=brandnamespace&displayName=zhongkaifan";
			String urlParameters =  "{\"namespace\": \"brandnamespace\",\"email\":\""+email+"\"}";
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
		
		
		private void CallBrandAPi(String url,String urlParameters) throws IOException {

			//String url = " https://aolapis.com/brandapi/api/validateEmail";
			URL obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			// add reuqest header
			con.setRequestMethod("POST");
			
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Authorization",
					accessToken);
			
			//String urlParameters = "namespace=brandnamespace&displayName=zhongkaifan";
			//String urlParameters =  "{\"namespace\": \"brandnamespace\",\"email\":\""+email+"\"}";
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
