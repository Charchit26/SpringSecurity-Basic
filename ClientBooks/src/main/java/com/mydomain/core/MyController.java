package com.mydomain.core;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class MyController {

	@Autowired
	Environment env;
	@RequestMapping("/getThem")
	public List<Book> l() {
		RestTemplate restTemplate = new RestTemplate();
		List<ServiceInstance> l = getUrl("books-micro");
		ServiceInstance s = l.get(0);
		URI g = s.getUri();//s.getHost() + ":" + s.getPort();
		System.out.println(g);
		//URI uri = UriComponentsBuilder.fromUriString(g + "/books").build().toUri();
		restTemplate.getInterceptors().add(
				  new BasicAuthorizationInterceptor(env.getProperty("auth-user-name"), env.getProperty("auth-user-password")));
		ResponseEntity<List<Book>> b = restTemplate.exchange(g + "/books", HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>(){} );
		System.out.println(b.getBody());
		return b.getBody();
	}

	@Autowired
	private DiscoveryClient discoveryClient;

	public List<ServiceInstance> getUrl(String s) {
		System.out.println("----> "+discoveryClient.getServices());
		return discoveryClient.getInstances(s);
	}
}
