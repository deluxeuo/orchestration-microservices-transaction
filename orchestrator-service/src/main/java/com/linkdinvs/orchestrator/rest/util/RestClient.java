package com.linkdinvs.orchestrator.rest.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.linkdinvs.orchestrator.exception.ResourceNotFoundException;

@Component
public class RestClient {

	public String doPost(String url, Long orderId) throws ResourceNotFoundException {

		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			OrderRequest req = new OrderRequest();
			req.setOrderId(orderId);

			MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
			map.add("orderId", orderId.toString());

		/*	HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map,
					headers);*/

			//ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
			//System.out.println("url ***** " + url);
			String response = restTemplate.postForObject(url, req, String.class);
			//System.out.println("response *** " + response);
			return response;

		} catch (RestClientException e) {
			throw new ResourceNotFoundException("service unavailable");
		}

	}

}
