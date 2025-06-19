package com.mehru.myportfolio

import android.os.Build
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class webActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_web)

        val webViewVariable = findViewById<WebView>(R.id.webView)

        webViewSetup(webViewVariable)

    }

    @RequiresApi(Build.VERSION_CODES.O)

    private fun webViewSetup(view: WebView) {
        view.webViewClient = WebViewClient()
        view.apply {
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
            loadUrl("https://github.com/Mehruuban")
        }
    }
}