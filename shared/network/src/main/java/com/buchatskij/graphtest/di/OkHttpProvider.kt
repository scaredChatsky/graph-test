package com.buchatskij.graphtest.di

import okhttp3.ConnectionSpec
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.*

object OkHttpProvider {

    private const val VERSION_PARAM = "version"
    private const val API_VERSION = "1.1"

    fun getUnsafeOkHttpClient(): OkHttpClient {
        val trustAllCerts = getTrustManager()
        val sslContext = SSLContext.getInstance("SSL")
            .apply {
                init(null, trustAllCerts, SecureRandom())
            }

        val sslSocketFactory = sslContext.socketFactory

        return OkHttpClient.Builder().apply {
            sslSocketFactory(sslSocketFactory, (trustAllCerts[0] as X509TrustManager))
            connectionSpecs(
                listOf(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS)
            )
            addInterceptor(createInterceptor())
            hostnameVerifier(HostnameVerifier { _: String?, _: SSLSession? -> true })
        }.build()
    }

    private fun createInterceptor(): Interceptor = Interceptor { chain: Interceptor.Chain ->
        var request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter(VERSION_PARAM, API_VERSION)
            .build()

        request = request.newBuilder()
            .url(url)
            .build()

        chain.proceed(request)
    }

    private fun getTrustManager(): Array<TrustManager> =
        arrayOf(
            object : X509TrustManager {
                override fun checkClientTrusted(
                    chain: Array<X509Certificate>,
                    authType: String
                ) {
                }

                override fun checkServerTrusted(
                    chain: Array<X509Certificate>,
                    authType: String
                ) {
                }

                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return arrayOf()
                }
            }
        )
}