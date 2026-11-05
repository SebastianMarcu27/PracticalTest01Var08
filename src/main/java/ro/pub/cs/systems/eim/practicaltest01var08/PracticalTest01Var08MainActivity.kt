
package ro.pub.cs.systems.eim.practicaltest01var08

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var08MainActivity : AppCompatActivity() {

    private lateinit var riddleEditText: EditText
    private lateinit var answerEditText: EditText
    private lateinit var playButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var08_main)

        riddleEditText = findViewById(R.id.riddleEditText)
        answerEditText = findViewById(R.id.answerEditText)
        playButton = findViewById(R.id.playButton)

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
                startActivity(intent)
            }
        }
    }
}
