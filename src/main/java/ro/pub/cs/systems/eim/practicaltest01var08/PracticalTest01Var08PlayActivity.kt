
package ro.pub.cs.systems.eim.practicaltest01var08

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var08PlayActivity : AppCompatActivity() {

    private lateinit var riddleTextView: TextView
    private lateinit var playerAnswerEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var08_play)

        riddleTextView = findViewById(R.id.riddleTextView)
        playerAnswerEditText = findViewById(R.id.playerAnswerEditText)

        val riddle = intent.getStringExtra("riddle") ?: ""

        riddleTextView.text = riddle
    }
}
