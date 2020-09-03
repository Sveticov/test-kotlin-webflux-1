package com.svetikov.testkotlinwebflux.router

import com.svetikov.testkotlinwebflux.component.MyHandler

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.function.server.RouterFunctions.route
import org.springframework.web.reactive.function.server.router


@Configuration
@EnableWebFlux
class EmployerRouter(private val handler:MyHandler) : WebFluxConfigurer{

    @Bean
    fun employerRoutes() = router{
        (accept(MediaType.APPLICATION_JSON).nest{
            GET("/employers",handler::allEmployers)
            GET("/employer/{id}",handler::selectById)
        })
    }



}