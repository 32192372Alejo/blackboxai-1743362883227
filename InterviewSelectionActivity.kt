package com.example.interviewsimulator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class InterviewSelectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interview_selection)

        val startSimulationButton: Button = findViewById(R.id.start_simulation)
        val difficultyGroup: RadioGroup = findViewById(R.id.difficulty_level)

        startSimulationButton.setOnClickListener {
            val selectedDifficultyId = difficultyGroup.checkedRadioButtonId
            val selectedDifficulty: String = when (selectedDifficultyId) {
                R.id.easy -> "Fácil"
                R.id.normal -> "Normal"
                R.id.difficult -> "Difícil"
                else -> "No seleccionado"
            }

            // Start the interview simulation activity
            val intent = Intent(this, InterviewSimulationActivity::class.java)
            intent.putExtra("DIFFICULTY_LEVEL", selectedDifficulty)
            startActivity(intent)
        }
    }
}