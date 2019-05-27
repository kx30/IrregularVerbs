package com.example.irregularverbs.gateway.local

import com.example.irregularverbs.mvp.models.Verb

interface VerbGateway {
    fun loadVerbs(complexity: Int?): ArrayList<Verb>
}