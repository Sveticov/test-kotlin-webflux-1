package com.svetikov.testkotlinwebflux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TestKotlinWebfluxApplication

fun main(args: Array<String>) {
    runApplication<TestKotlinWebfluxApplication>(*args)
}
