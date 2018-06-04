package com.revature.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.revature.beans.Coffee;


@Component("coffeeClient")
public class CoffeeClient {

	@Autowired
	private RestTemplate restTemplate;

	private String resourceUrl;

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	public Coffee getCoffee() {
			ResponseEntity<Coffee> response = this.restTemplate.exchange(this.resourceUrl + "/gimme",
					HttpMethod.GET, null, new ParameterizedTypeReference<Coffee>() {
					});
			return response.getBody();
		}

}


