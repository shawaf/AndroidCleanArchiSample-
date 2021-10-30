package com.elshawaf.networking.http

import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.X509TrustManager

/**
 * Created by
 */

data class SSLSocket(
    val factory: SSLSocketFactory,
    val trustManager: X509TrustManager
)
