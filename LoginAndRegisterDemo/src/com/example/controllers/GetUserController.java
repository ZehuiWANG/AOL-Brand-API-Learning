package com.example.controllers;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.omg.CORBA.SystemException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.User;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

@Controller
public class GetUserController {
	@RequestMapping(value = "/LoginSuccess.htm")
	public String showResults(ModelMap model) {
		System.out.println("test->LoginSuccess");
		return "LoginSuccess";
	}
	
	
	@RequestMapping(value = "/GetUser.htm", method = RequestMethod.POST)
	public @ResponseBody User addUser(@ModelAttribute(value = "user") User user, BindingResult result)
			throws Exception {
		System.out.println("test-->getuser.html");
		System.out.println(user.getName());
		System.out.println(user.getAccessToken());//null here
		String resulttest=GetUserTest(user.getName());
		System.out.println(GetUserTest(user.getName()));
		
		JSONObject objtest=new JSONObject(resulttest) ;
		
		user.setName(objtest.getJSONObject("data").getString("username"));
		
		//user.setEmail("123@123.com");
//		try {
			
					
			System.out.println(objtest);
			//return objtest.getString("data");
			return user;
//		} catch (Exception e) {
//			
//			System.out.println(e);
//			return null;
//		}
	}
	
	public String GetUserTest(String access_token) throws Exception {
		HttpResponse<String> response = Unirest.post("https://aolapis.com/brandapi/api/getUser")
			  .header("accept", "application/json")
			  .header("authorization", "Bearer "+access_token+"")
			  .header("content-type", "application/json")
			  .header("cache-control", "no-cache")
			  .body("{\n  \"namespace\": \"brandnamespace\"\n}")
			  .asString();
	//System.out.println("testGetUser method success");
	return response.getBody();
	}
}
