package com.svetikov.testkotlinwebflux.service

import com.svetikov.testkotlinwebflux.models.Employer
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface EmployerService {
    fun findAll(): Flux<Employer>
    fun getId(id: Int): Mono<Employer>
    fun save(employer: Employer)
}