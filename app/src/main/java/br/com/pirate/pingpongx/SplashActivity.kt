package br.com.pirate.pingpongx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        nextScreen()
    }

    private fun nextScreen() {
        Handler(Looper.getMainLooper()).postDelayed({
            val nextSreen = Intent(this, PlayerActivity::class.java)
            startActivity(nextSreen)
            finish()
        }, 2000)
    }
}