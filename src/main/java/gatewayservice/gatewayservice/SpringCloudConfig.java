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
                        .filters(f -> f.rewritePath("news-portal/", ""))
                        .uri("lb://news-portal/"))
                .route(r -> r.path("/currency-exchange/**")
                        .filters(f -> f.rewritePath("currency-exchange/", ""))
                        .uri("lb://currency-exchange/"))
                .build();
    }

}