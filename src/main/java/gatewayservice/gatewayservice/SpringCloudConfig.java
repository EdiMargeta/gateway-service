package gatewayservice.gatewayservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/news-portal/**")
                        .uri("http://localhost:9100/"))
                .route(r -> r.path("/currency-exchange/**")
                        .uri("http://localhost:9101/"))
                .build();
    }

}