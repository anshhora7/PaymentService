package com.PaymentTwo.restTemplate.PaymentTwo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonFormat;

@SpringBootApplication
@RestController
@EnableZuulProxy
public class PaymentTwoApplication {
	
	@RequestMapping(value="/PaymentZull/{Id}")
	@JsonFormat
	public ResponseEntity<?> fuction(@PathVariable("Id") int Id)
	{
		Map rp=new HashMap();
		
	    HttpEntity<?> request=new HttpEntity<>(rp);
		String url="http://localhost:8888/Payment/Login?UserId="+Id+"";
		ResponseEntity<?> response = new RestTemplate().postForEntity(url, request, String.class);
		return  response;
		
	}

	public static void main(String[] args) {
		SpringApplication.run(PaymentTwoApplication.class, args);
	}

}
