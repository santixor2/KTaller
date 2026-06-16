package com.santig.ktaller.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.santig.ktaller.core.ui.screen.AppScreen
import com.santig.ktaller.core.ui.theme.KTallerTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splash = installSplashScreen()
        var show = true
        splash.setKeepOnScreenCondition { show }
        lifecycleScope.launch {
            delay(timeMillis = 2000)
            show = false
        }
        enableEdgeToEdge()
        setContent {
            KTallerTheme {
                AppScreen()
            }
        }
    }
}