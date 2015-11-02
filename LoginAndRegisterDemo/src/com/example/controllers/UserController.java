package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.example.domain.User;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;


@Controller
public class UserController {

	String accessToken = "Bearer djF8ZV9iZWFyfDF8aWczbDY5UXdKTGNCak83Q0lORHFJNWpyTkM2Q2ZpLXZYNjVvQkRVb0N3VE9pcFdOS0ZTX1BNLXUwM2xnc3VZWWxmb3YtTWVUWV9mR3JVRHZOM1FGcVF8bV9iZWFyfDF8aU8wSVV6YzE0SktpM1kwMFNtMG5lM3lOMThkZmpuRl9WWjN3bEpDYy0zVQ";

//	@RequestMapping(value = "/index.htm")
//	public String showIndex() {
//		System.out.println("index");
//		return "index";
//	}

	@RequestMapping(value = "/Registration.htm")
	public String showUsers(ModelMap model) {
		System.out.println(" Registration test");
		return "Registration";
	}

//	@RequestMapping(value = "/SuccessPage.htm")
//	public String showResults(ModelMap model) {
//	
//		System.out.println("test");
//		return "SuccessPage";
//	}
	@RequestMapping(value = "/SuccessPage.htm", method = RequestMethod.GET)
    public ModelAndView printWelcome(@ModelAttribute("user") User user) {

        ModelAndView mav = new ModelAndView("SuccessPage");
        System.out.println(user.getEmail());
        mav.addObject("message", user.getEmail());
        return mav;
    }

	@RequestMapping(value = "/AddUser.htm", method = RequestMethod.GET)
	public String showForm() {
		return "AddUser";
	}
	@RequestMapping(value = "/AddUser.htm", method = RequestMethod.POST)
	public @ResponseBody String addUser(@ModelAttribute(value = "user") User user, BindingResult result)
			throws Exception {
		// String returnText;
		String url = "https://aolapis.com/brandapi/api/validateDisplayName";
		String urlParameters = "{\"namespace\": \"brandnamespace\",\"displayName\":\"" + user.getName() + "\"}";
		System.out.println(user.getEmail());
		CallApiTest(url, urlParameters);
		return user.getEmail();
	}
	@RequestMapping(value = "/ValidateEmail.htm", method = RequestMethod.POST)
	public @ResponseBody String validateEmail(@ModelAttribute(value = "suggestuser") User user, BindingResult result)
			throws Exception {
		// String returnText;
		String url = "https://aolapis.com/brandapi/api/validateEmail";
		String urlParameters = "{\"namespace\": \"brandnamespace\",\"email\":\"" + user.getEmail() + "\"}";

		System.out.println(user.getEmail());
		CallApiTest(url, urlParameters);
		return user.getEmail();

	}

	@RequestMapping(value = "/ValidatePassword.htm", method = RequestMethod.POST)
	public @ResponseBody String validatePassword(@ModelAttribute(value = "validatePassword") User user,
			BindingResult result) throws Exception {
		String password = user.getPassword();

		String url = "https://aolapis.com/brandapi/api/validatePassword";
		String urlParameters = "{\"namespace\": \"brandnamespace\",\"username\":\"" + user.getName()
				+ "\",\"password\": \"" + password + "\"}";

		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		CallApiTest(url, urlParameters);
		return user.getEmail();

	}

	@RequestMapping(value = "/CreateUser.htm", method = RequestMethod.POST)
	public @ResponseBody String CreateUser(@ModelAttribute(value = "createuser") User user, BindingResult result)
			throws Exception {

		String url = "https://aolapis.com/brandapi/api/createUser";
		String urlParameters = "{\"namespace\": \"brandnamespace\",\"email\":\"" + user.getEmail()
				+ "\",\"password\":\"" + user.getPassword() + "\"}";

		CallApiTest(url, urlParameters);
		return "SuccessPage";
	}

	// //using the Unirest framework
	public String CallApiTest(String url, String urlParameters) throws Exception {

		HttpResponse<String> response = Unirest.post(url).header("accept", "application/json")
				.header("authorization", accessToken).header("content-type", "application/json")
				.header("cache-control", "no-cache").body(urlParameters).asString();
		System.out.println(response.getStatus());
		System.out.println(response.getStatusText());
		System.out.println(response.getBody());
		System.out.println(response.getRawBody());
		return null;
	}

}
