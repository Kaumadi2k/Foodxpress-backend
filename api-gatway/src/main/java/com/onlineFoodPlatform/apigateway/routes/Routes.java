package com.onlineFoodPlatform.apigateway.routes;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {
    @Bean
    public RouterFunction<ServerResponse> productServiceRoute(){
        return GatewayRouterFunctions.route("product_service")
                .route(RequestPredicates.path("/api/v1/product/**"), HandlerFunctions.http("http://localhost:8080"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> categoryServiceRoute(){
        return GatewayRouterFunctions.route("category_service")
                .route(RequestPredicates.path("/api/v1/category/**"), HandlerFunctions.http("http://localhost:8080"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> cartServiceRoute(){
        return GatewayRouterFunctions.route("cart_service")
                .route(RequestPredicates.path("/api/v1/cart/**"), HandlerFunctions.http("http://localhost:8081"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> userServiceRoute(){
        return GatewayRouterFunctions.route("user_Service")
                .route(RequestPredicates.path("api/v1/user/**"), HandlerFunctions.http("http://localhost:8082"))
                .build();
    }
}
