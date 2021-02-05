package br.com.pirate.pingpongx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.parcel.Parcelize
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var tvPlayerOneScore: TextView
    private lateinit var tvPlayerTwoScore: TextView
    private lateinit var tvPlayerOneName: TextView
    private lateinit var tvPlayerTwoName: TextView
    private lateinit var btPlayerOneScore: Button
    private lateinit var btPlayerTwoScore: Button
    private lateinit var btFinishMatch: Button
    private lateinit var btRevenge: Button

    private var playerOneScore = 0
    private var playerTwoScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpView()
        fillFields()
        setUpListeners()

        if (savedInstanceState != null) {
            playerOneScore = savedInstanceState.getInt("PLAYER_ONE_SCORE")
            playerTwoScore = savedInstanceState.getInt("PLAYER_TWO_SCORE")

            tvPlayerOneScore.text = playerOneScore.toString()
            tvPlayerTwoScore.text = playerTwoScore.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("PLAYER_ONE_SCORE", playerOneScore)
        outState.putInt("PLAYER_TWO_SCORE", playerTwoScore)
    }

    private fun setUpListeners() {
        btPlayerOneScore.setOnClickListener {
            playerOneScore++
            tvPlayerOneScore.text = playerOneScore.toString()
        }

        btPlayerTwoScore.setOnClickListener {
            playerTwoScore++
            tvPlayerTwoScore.text = playerTwoScore.toString()
        }

        btFinishMatch.setOnClickListener {
            finish()
        }

        btRevenge.setOnClickListener {
            playerOneScore = 0
            playerTwoScore = 0

            tvPlayerOneScore.text = playerOneScore.toString()
            tvPlayerTwoScore.text = playerTwoScore.toString()
        }
    }

    private fun fillFields() {
        tvPlayerOneName.text = intent.getStringExtra(PlayerActivity.KEY_EXTRA_PLAYER_ONE)
        tvPlayerTwoName.text = intent.getStringExtra(PlayerActivity.KEY_EXTRA_PLAYER_TWO)
    }

    private fun setUpView() {
        tvPlayerOneScore = findViewById(R.id.tvPlayerOneScore)
        tvPlayerTwoScore = findViewById(R.id.tvPlayerTwoScore)
        tvPlayerOneName = findViewById(R.id.tvPlayerOneName)
        tvPlayerTwoName = findViewById(R.id.tvPlayerTwoName)
        btPlayerOneScore = findViewById(R.id.btPlayerOneScore)
        btPlayerTwoScore = findViewById(R.id.btPlayerTwoScore)
        btFinishMatch = findViewById(R.id.btFinishMatch)
        btRevenge = findViewById(R.id.btRevenge)
    }
}