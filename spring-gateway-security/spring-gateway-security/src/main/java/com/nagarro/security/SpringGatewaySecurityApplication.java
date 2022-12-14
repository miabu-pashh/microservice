package com.nagarro.security;

import com.nagarro.security.config.RedisHashComponent;
import com.nagarro.security.dto.ApiKey;
import com.nagarro.security.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@SpringBootApplication
public class SpringGatewaySecurityApplication {
	@Autowired
	private RedisHashComponent redisHashComponent;

	@PostConstruct
	public void initKeysToRedis() {
		List<ApiKey> apiKeys = new ArrayList<>();
		apiKeys.add(new ApiKey("343C-ED0B-4137-B27E", Stream.of(AppConstants.CUSTOMER_SERVICE_KEY,
				AppConstants.ITEM_DETAILS_SERVICE_KEY).collect(Collectors.toList())));
		apiKeys.add(new ApiKey("FA48-EF0C-427E-8CCF", Stream.of(AppConstants.ITEM_DETAILS_SERVICE_KEY)
				.collect(Collectors.toList())));
		List<Object> lists = redisHashComponent.hValues(AppConstants.RECORD_KEY);
		if (lists.isEmpty()) {
			apiKeys.forEach(k -> redisHashComponent.hSet(AppConstants.RECORD_KEY, k.getKey(), k));
		}
	}



	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(AppConstants.CUSTOMER_SERVICE_KEY,
						r -> r.path("/customer/**")
								.filters(f -> f.stripPrefix(2)).uri("http://localhost:9003"))
				.route(AppConstants.ITEM_DETAILS_SERVICE_KEY,
						r -> r.path("/itemDetails/**")
								.filters(f -> f.stripPrefix(2)).uri("http://localhost:9001"))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringGatewaySecurityApplication.class, args);
	}



}
