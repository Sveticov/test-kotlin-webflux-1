package com.svetikov.testkotlinwebflux.router

import com.svetikov.testkotlinwebflux.component.MyHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.*
import java.io.ObjectInputStream

@Configuration
class MyRouter(private val handler: MyHandler) {

    @Bean
    fun route() = router {
        accept(MediaType.TEXT_PLAIN)
                .nest {
                    GET("/test").invoke(handler::hello)

                }
        accept(MediaType.APPLICATION_JSON)
                .nest { GET("/test2", handler::handlerEmployer) }
        accept(MediaType.APPLICATION_JSON)
                .nest{GET("/all",handler::allEmployers)}
        accept(MediaType.APPLICATION_JSON)
                .nest{GET("/empl/{id}",handler::selectById)}
    }
}