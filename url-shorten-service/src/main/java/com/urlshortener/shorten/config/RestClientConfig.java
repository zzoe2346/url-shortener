package com.urlshortener.shorten.config;

import com.urlshortener.shorten.client.PersistenceClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfig {
    @Bean
    public PersistenceClient persistenceClient() {
        RestClient restClient = RestClient.builder()
                .baseUrl("not conclude")
                .requestFactory(getClientRequestFactory())
                .build();

        return HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
                .build()
                .createClient(PersistenceClient.class);
    }

    private ClientHttpRequestFactory getClientRequestFactory() {
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setConnectTimeout(3000);
        simpleClientHttpRequestFactory.setReadTimeout(3000);
        return simpleClientHttpRequestFactory;
    }
}
