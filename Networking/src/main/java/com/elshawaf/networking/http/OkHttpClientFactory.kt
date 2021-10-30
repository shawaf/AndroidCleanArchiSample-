package com.elshawaf.networking.http

import android.text.TextUtils
import android.util.Log
import com.elshawaf.networking.http.OkHttpClientFactory.createOkHttpClient
import com.elshawaf.networking.intereceptor.LoggingProvider
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * Factory class to create an [OkHttpClient] using [createOkHttpClient].
 *
 * We are passing a nullable [SSLSocket] because in the E2E test we are using rest mock for mocking
 * API response and to make it work with an HTTPS localhost(secure) we need to pass its socket factory
 * and trust manager to the [OkHttpClient] in tests builds. Use default in debug and release builds.
 * We just wrapped the two in a single class [SSLSocket] for convenience.
 *
 * We are passing [LoggingProvider] because in each build variant we can pass different implementation
 * or use another logging tool. That's why we didn't add Timber here directly. It's up to the app
 * aka host component to pass its desired implementation.
 * Created by Mohamed Elshawaf
 */
object OkHttpClientFactory {

    fun createOkHttpClient(
        isDebug: Boolean,
        sslSocket: SSLSocket?,
        accessToken: AccessToken
    ): OkHttpClient {
        val timeout = 60L

        val builder = OkHttpClient.Builder()
            .addInterceptor(makeLoggingInterceptor(isDebug))
            .addInterceptor(makeInterceptor())
            .connectTimeout(timeout, TimeUnit.SECONDS)
            .readTimeout(timeout, TimeUnit.SECONDS)

        if (sslSocket != null) {
            builder.sslSocketFactory(sslSocket.factory, sslSocket.trustManager)
        }

        return builder.build()
    }

    private fun makeLoggingInterceptor(
        isDebug: Boolean,
    ): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()

        val debugLevel = if (isDebug) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        httpLoggingInterceptor.setLevel(debugLevel)

        return httpLoggingInterceptor
    }

    private fun makeInterceptor(): Interceptor {
        return Interceptor { chain: Interceptor.Chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
            requestBuilder.addHeader("Content-Type", "application/json")
            /**
             * In Case Wanted to add app signature
             */
            //requestBuilder.addHeader("androidSignature",new AppSignatureHelper(HakbahApplication.getInstance().getApplicationContext()).getAppSignatures().get(0));
            requestBuilder.method(original.method, original.body)
            val startTime = System.currentTimeMillis()
            val request = requestBuilder.build()
            val response = chain.proceed(request)

            /**
             * Use the following to print all info about request/response
             */
//            val estimatedTime = System.currentTimeMillis() - startTime
//            Log.d(
//                "estimatedTime",
//                estimatedTime.toString() + " millis//" + request.url
//            )
//            Log.d("request", "+++++++++++++++++ Request Forum  : $request")
////            Log.d("request", request.headers.toString())
//            Log.d("response", response.toString())


            response
        }
    }
}
