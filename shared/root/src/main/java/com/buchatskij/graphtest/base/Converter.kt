package com.buchatskij.graphtest.base

interface Converter<From, To> {

    operator fun invoke(from: From): To
}