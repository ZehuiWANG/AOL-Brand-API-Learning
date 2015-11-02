package com.example.controllers;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.JsonResponse;
import com.example.domain.User;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

@Controller
public class LoginController {
	
	String accessToken = "Bearer djF8ZV9iZWFyfDF8NlNYaVpZRTA1WHM3b2REelFGYnFNN2QweV9LZDRYWjRxMmFpRnd0WDdzSVRBdXRmSGRWMVl0a2RfN2tJLVBWQTZsVmlsUnJDYVY1UkVKMDlXM2tnTlF8bV9iZWFyfDF8WjVyaHdVcjZZaGd5UGlhVmc3XzhQTWZteUoxd1AxaGdCUlF2Vlc4cW9OUQ";
	
	@RequestMapping(value = "/index.htm")
	public String showIndex() {
		System.out.println("index");
		return "index";
	}
	
	@RequestMapping(value = "/Login.htm", method = RequestMethod.POST)
	public @ResponseBody String addUser(@ModelAttribute(value = "user") User user, BindingResult result)
			throws Exception {

		String url = "https://aolapis.com/brandapi/api/validateDisplayName";
		String urlParameters = "{\"namespace\": \"brandnamespace\",\"displayName\":\"" + user.getName() + "\"}";
		
		System.out.println("Login Success!");
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		System.out.println(LoginTest(user.getEmail(),user.getPassword()));
		String test=LoginTest(user.getEmail(),user.getPassword());
		System.out.println(test);
		
		JSONObject obj=new JSONObject(test);
		System.out.println(obj.getString("access_token"));
		return obj.getString("access_token");
	}
	public String LoginTest(String name, String password) throws Exception {
		HttpResponse<String> response = Unirest.post("https://i.aol.com/oauth2/token")
				  .header("accept", "application/json")
				  .header("authorization", accessToken)
				  .header("cache-control", "no-cache")
				  .header("postman-token", "3ac10b3a-bf16-228a-c7de-9ee4d4f4648e")
				  .header("content-type", "application/x-www-form-urlencoded")
				  .body("grant_type=password&scope=brand_api&username="+name+"&password="+password+"")
				  .asString();
		System.out.println(response.toString());
	System.out.println(response.getBody());
		System.out.println(response.getStatusText());
		return response.getBody();
		
	}
}
