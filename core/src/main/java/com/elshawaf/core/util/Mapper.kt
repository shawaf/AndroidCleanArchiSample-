package com.elshawaf.core.util

interface Mapper<in I, out O> {

    fun mapTo(input: I): O

}