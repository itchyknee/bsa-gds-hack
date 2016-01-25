package uk.nhsbsa.gds.hack.conf;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GovpayConfig {

	@Value("${bearerToken:1557c300-0305-472d-9630-c970a35eaf8c}")
	private String bearerToken;
	
	@Bean
	public RestTemplate createGovpayRestTemplate() {
		
		return new RestTemplate();
	}
	
	@Bean(name="httpHeadersPost")
	public HttpHeaders createHttpHeadersPost() {

		HttpHeaders headers = new HttpHeaders();
		auth(headers);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

	@Bean(name="httpHeadersGet")
	public HttpHeaders createHttpHeadersGet() {

		HttpHeaders headers = new HttpHeaders();
		auth(headers);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	}

	private void auth(HttpHeaders headers) {
		headers.add("authorization", "Bearer " + bearerToken);
	}
	
}
