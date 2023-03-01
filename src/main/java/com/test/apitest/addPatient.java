package com.test.apitest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nimbusds.jose.shaded.json.JSONObject;



public class addPatient {
	
	public String addMainPatient()throws JsonMappingException, JsonProcessingException{
	String accessToken = new Authorize().GetAccessToken();
	RestTemplate restTemplate = new RestTemplate();
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);
	// Replace  with your actual bearer token
	headers.setBearerAuth(accessToken);
	

	JSONObject patientJson = new JSONObject();
	patientJson.put("title", "");
	

	HttpEntity<String> entity = new HttpEntity<String>(patientJson.toString(), headers);
	String url = "https://mobileapp.trackdemon.in/apis/default/api/patient";
	ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
	String mainStr = response.getBody();

	return mainStr;
	}

}
