package com.svetikov.testkotlinwebflux.component

import com.svetikov.testkotlinwebflux.models.Employer
import com.svetikov.testkotlinwebflux.service.EmployerService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PathVariable

import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty

@Component
class MyHandler(private val service: EmployerService) {

    fun hello(request: ServerRequest): Mono<ServerResponse> =
            ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                    .body(BodyInserters.fromValue("hello kotlin"))

    fun handlerEmployer(request: ServerRequest): Mono<ServerResponse> =
            ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromValue(Employer(5, "gorg", 15)))

    fun allEmployers(request: ServerRequest): Mono<ServerResponse> {
        val employers: Flux<Employer> = service.findAll()
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(employers, Employer::class.java)
    }

    fun selectById(request: ServerRequest):Mono<ServerResponse>{

        val employer:Mono<Employer> =service.getId(Integer.parseInt(request.pathVariable("id")))//
        val notFound:Mono<ServerResponse> =ServerResponse.notFound().build()
        println(employer.map { e-> print(e.toString()) })

        return employer.flatMap{e->
            ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(e,Employer::class.java)
                .switchIfEmpty (notFound)

        }

    }


}