
package ro.pub.cs.systems.eim.practicaltest01var08

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var08PlayActivity : AppCompatActivity() {

    private lateinit var riddleTextView: TextView
    private lateinit var playerAnswerEditText: EditText
    private lateinit var checkButton: Button
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var08_play)

        riddleTextView = findViewById(R.id.riddleTextView)
        playerAnswerEditText = findViewById(R.id.playerAnswerEditText)
        checkButton = findViewById(R.id.checkButton)
        backButton = findViewById(R.id.backButton)

        val riddle = intent.getStringExtra("riddle") ?: ""
        val correctAnswer = intent.getStringExtra("answer") ?: ""

        riddleTextView.text = riddle

        checkButton.setOnClickListener {
            val playerAnswer = playerAnswerEditText.text.toString()

            val result = if (playerAnswer == correctAnswer) {
                "Yes"
            } else {
                "No"
            }

            returnResult(result)
        }

        backButton.setOnClickListener {
            returnResult("Fail")
        }

        onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    returnResult("Fail")
                }
            }
        )
    }

    private fun returnResult(result: String) {
        val resultIntent = Intent()
        resultIntent.putExtra("result", result)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}
