
package ro.pub.cs.systems.eim.practicaltest01var08

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var08PlayActivity : AppCompatActivity() {

    private lateinit var riddleTextView: TextView
    private lateinit var playerAnswerEditText: EditText
    private lateinit var checkButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var08_play)

        riddleTextView = findViewById(R.id.riddleTextView)
        playerAnswerEditText = findViewById(R.id.playerAnswerEditText)
        checkButton = findViewById(R.id.checkButton)

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

            Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
        }
    }
}
