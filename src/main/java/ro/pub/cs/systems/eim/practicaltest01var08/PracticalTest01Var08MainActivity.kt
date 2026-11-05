
package ro.pub.cs.systems.eim.practicaltest01var08

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var08MainActivity : AppCompatActivity() {

    private lateinit var riddleEditText: EditText
    private lateinit var answerEditText: EditText
    private lateinit var playButton: Button

    private var gameResult: String = "Fail"

    companion object {
        private const val TAG = "PracticalTest01Var08"
        private const val RESULT_KEY = "game_result"
    }

    private val playLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->

        gameResult = result.data?.getStringExtra("result") ?: "Fail"

        Toast.makeText(
            this,
            gameResult,
            Toast.LENGTH_SHORT
        ).show()

        Log.d(TAG, "Game result: $gameResult")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var08_main)

        riddleEditText = findViewById(R.id.riddleEditText)
        answerEditText = findViewById(R.id.answerEditText)
        playButton = findViewById(R.id.playButton)

        if (savedInstanceState != null) {
            gameResult = savedInstanceState.getString(
                RESULT_KEY,
                "Fail"
            )

            Toast.makeText(
                this,
                "Restored result: $gameResult",
                Toast.LENGTH_SHORT
            ).show()

            Log.d(TAG, "Restored result: $gameResult")
        }

        playButton.setOnClickListener {
            val riddle = riddleEditText.text.toString().trim()
            val answer = answerEditText.text.toString().trim()

            if (riddle.isEmpty() || answer.isEmpty()) {
                Toast.makeText(
                    this,
                    "Complete both fields!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent = Intent(
                    this,
                    PracticalTest01Var08PlayActivity::class.java
                )

                intent.putExtra("riddle", riddle)
                intent.putExtra("answer", answer)

                playLauncher.launch(intent)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(RESULT_KEY, gameResult)

        Log.d(TAG, "Saved result: $gameResult")

        super.onSaveInstanceState(outState)
    }
}
