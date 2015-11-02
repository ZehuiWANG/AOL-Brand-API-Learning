package com.example.controllers;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;


public class Test {
	public static void main(String[] args)throws Exception{
		HttpResponse<String> response = Unirest.post("https://i.aol.com/oauth2/token")
				  .header("accept", "application/json")
				  .header("authorization", "Bearer djF8ZV9iZWFyfDF8REhvTVpiMHpqTmFkQmJMdjBFb0JJMURRQVphc2w0Q1VaS19GMGxwSjhTeEhMVjA2NzVBX2RYSzZEWG83cUpLdUdjUnB3UGRCUUhzN29HenljV3RJUGd8bV9iZWFyfDF8OHI4aDAwMHNFSVZac1lXaURhalZNTWJmU0UyTWxWX3NoenctNm1YcDgxZw")
				  .header("cache-control", "no-cache")
				  .header("postman-token", "46e3b2bb-01da-98d8-bd52-ef48b50567fa")
				  .header("content-type", "application/x-www-form-urlencoded")
				  .body("grant_type=password&scope=brand_api&username=aolbrandapitest%40163.com&password=8810023").asString();
		System.out.println(response.toString());
		System.out.println(response.getBody());
		System.out.println(response.getStatus());
		System.out.println(response.getStatusText());
		
	}
}
