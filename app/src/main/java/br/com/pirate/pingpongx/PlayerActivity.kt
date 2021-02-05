package br.com.pirate.pingpongx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import kotlinx.android.parcel.Parcelize

class PlayerActivity : AppCompatActivity() {

    companion object{
        val KEY_EXTRA_PLAYER_ONE = "PLAYER1"
        val KEY_EXTRA_PLAYER_TWO = "PLAYER2"
     }

    private lateinit var etPlayerOne: EditText
    private lateinit var etPlayerTwo: EditText
    private lateinit var btStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        setUpView()

        btStart.setOnClickListener {
            val nextScreen = Intent(this, MainActivity::class.java)
            nextScreen.putExtra(KEY_EXTRA_PLAYER_ONE, etPlayerOne.text.toString())
            nextScreen.putExtra(KEY_EXTRA_PLAYER_TWO, etPlayerTwo.text.toString())

            startActivity(nextScreen)
        }
    }

    private fun setUpView() {
        etPlayerOne = findViewById(R.id.etPlayerOne)
        etPlayerTwo = findViewById(R.id.etPlayerTwo)

        btStart = findViewById(R.id.btStart)
    }

//    @Parcelize
//    data class Partida(
//        val timeVisitante: String,
//        val timeDaCasa: String
//    ) : Parcelable
}