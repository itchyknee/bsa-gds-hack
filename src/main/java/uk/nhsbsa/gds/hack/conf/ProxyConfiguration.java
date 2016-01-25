package uk.nhsbsa.gds.hack.conf;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.ProxyAuthenticationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

public class ProxyConfiguration {
	
	/** Logger. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ProxyConfiguration.class);

	@Value("${proxy.host:proxy}")
	private String proxyHost;
	
	@Value("${proxy.port:8080}")
	private Integer proxyPort;
	
	@Value("${proxy.user:user}")
	private String proxyUser;
	
	@Value("${proxy.password:password}")
	private String proxyPassword;
	
	public CredentialsProvider createCredentialsProvider() {
		
		LOGGER.info("Credentials provider: {}@{}:{}", new Object[]{
				proxyUser,
				proxyHost,
				proxyPort
		});
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials( new AuthScope(proxyHost, proxyPort),
				new UsernamePasswordCredentials(proxyUser, proxyPassword) );
		return credsProvider;
	}
	
	public HttpClientBuilder createHttpClientBuilder() {
		HttpClientBuilder clientBuilder = HttpClientBuilder.create();
		clientBuilder.useSystemProperties();
		clientBuilder.setProxy(new HttpHost(proxyHost, proxyPort));
		clientBuilder.setDefaultCredentialsProvider(createCredentialsProvider());
		clientBuilder.setProxyAuthenticationStrategy(new ProxyAuthenticationStrategy());
		return clientBuilder;
	}
	
	@Bean
	public HttpComponentsClientHttpRequestFactory createHttpComponentsClientHttpRequestFactory() {
		
		CloseableHttpClient client = createHttpClientBuilder().build();
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setHttpClient(client);
		return factory;
	}
}
