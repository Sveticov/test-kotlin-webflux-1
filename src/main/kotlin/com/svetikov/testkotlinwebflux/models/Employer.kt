package com.svetikov.testkotlinwebflux.models

import reactor.core.publisher.FluxSink
import java.util.function.Consumer

data class Employer(val id: Int, val name: String, val age: Int)