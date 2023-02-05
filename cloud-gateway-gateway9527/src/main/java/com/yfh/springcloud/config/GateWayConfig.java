package com.yfh.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangfei
 * @data 2023/1/26 - 15:05
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

//        routes.route("path_route_yfh", new Function<PredicateSpec, Route.AsyncBuilder>() {
//            @Override
//            public Route.AsyncBuilder apply(PredicateSpec predicateSpec) {
//                return predicateSpec.path("/payment/get/**").uri("http://localhost:8001");
//            }
//        }).build();

//        routes.route("path_route_yfh", predicateSpec ->
//                predicateSpec.path("/payment/get/**").
//                        uri("http://localhost:8001")).build();

        routes.route("path_route_bilibili",
                r -> r.path("/v/douga")
                        .uri("https://www.bilibili.com/v/douga")).build();
//        routes.route("path_route_bilibili2",
//                r -> r.path("/v/douga")
//                        .uri("https://www.bilibili.com")).build();

        return routes.build();
    }
}
