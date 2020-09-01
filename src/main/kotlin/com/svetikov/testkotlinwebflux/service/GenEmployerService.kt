package com.svetikov.testkotlinwebflux.service

import com.svetikov.testkotlinwebflux.models.Employer
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
@Service
class GenEmployerService : EmployerService {
  private  var listEmployer:ArrayList<Employer> = arrayListOf(Employer(1,"Jery",12),Employer(2,"Holy",14),
    Employer(3,"Grifin",90))


    override fun findAll(): Flux<Employer> {
       return Flux.fromIterable(listEmployer)
    }

    override fun getId(id: Int): Mono<Employer> {
      return Mono.just(listEmployer[id])
    }

    override fun save(employer: Employer) {
       listEmployer.add(employer)
    }
}